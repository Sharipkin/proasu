package kz.railways.mq;

import java.io.UnsupportedEncodingException;
//import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.sql.DataSource;

import kz.railways.workstation.PodhodBeanLocal;
import kz.railways.entities.Poezd;
import kz.railways.entities.Vagon;

@MessageDriven(mappedName = "jms/ImportQueue")
public class MessageReceiver implements MessageListener {

	@EJB
	PodhodBeanLocal podhodBean;

	@Resource(mappedName = "jdbc/DB2Asuss")
	private DataSource dataSource;

	public void onMessage(Message message) {

		BytesMessage bm = (BytesMessage) message;

		try {
			byte[] data = new byte[(int) bm.getBodyLength()];
			bm.readBytes(data);
			String rusASCII = null;
			//String rusANSI = null;
			String content = null;
			try {
				rusASCII = new String(data, "cp866");
				//rusANSI = new String(rusASCII.getBytes(), "cp1251");
				content = new String(rusASCII.getBytes());
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			String text = null;
			text = new Date().toString();
			text = "----------------RESEIVED MESSAGE---------------------";
			System.out.println(text);
			try (Scanner mess = new Scanner(content);) {
				while (mess.hasNext()) {
					switch (mess.next()) {
					case "(:902": {
						parceMessage902(content);
					}
						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(content);
			text = content;
			text = "-----------------END---------------------";
			System.out.println(text);
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

	public void parceMessage902(String m) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date()); // Date date
		int year = calendar.get(Calendar.YEAR);
		String day, month, hour, minute;
		String tmp;

		try (Scanner line = new Scanner(m);) {
			line.useDelimiter(System.getProperty("line.separator"));
			Poezd podhod = new Poezd();
			List<Vagon> vagList = new ArrayList<Vagon>();
			while (line.hasNext()) {
				if (!(tmp = line.next()).isEmpty()) {
					try (Scanner mess = new Scanner(tmp);) {
						try (Connection conn = dataSource.getConnection();) {
							ResultSet rs;
							PreparedStatement ps;
							String sql;
							if (mess.hasNext()) {
								if ((tmp = mess.next()).equals("(:902")) {
									// mess.next();
									podhod.setKodOp(0);
									
									podhod.setStPer(mess.next()); // вставка 5го символа 0 справа
									podhod.setnPoezd(mess.next());
									podhod.setStForm(mess.next());//(String.format("%-5s", mess.next()).replace(' ', '0'));
									podhod.setnSost(String.format("%03d", Integer.parseInt(mess.next()))); // вставка 3го символа 0 слева
									podhod.setStNazn(mess.next());//(String.format("%-5s", mess.next()).replace(' ', '0'));
									podhod.setPrSpis(mess.nextInt());
									day = mess.next();
									month = mess.next();
									hour = mess.next();
									minute = mess.next();
									podhod.setDvOtpr(Timestamp.valueOf(Integer.toString(year) + "-" + month + "-" + day
											+ " " + hour + ":" + minute + ":00.000"));// "2016-01-19 14:01:00.000000"
									podhod.setUdl(mess.nextInt());
									podhod.setBrutto(mess.nextInt());
									podhod.setPrik(mess.nextInt());
									podhod.setNegab(mess.next());
									podhod.setGivn(mess.nextInt());
									podhod.setMarsh(mess.next());
									podhod.setKodSt("000000");
									podhod.setKodOp(0);
									podhod.setDvOper(podhod.getDvOtpr());
									
									sql = "select KOD_ST from STAN where KOD_ST like ?";// and LENGTH(RTRIM(LTRIM(KOD_ST))) = 6
									
									if (podhod.getStPer().length() == 4){										
										ps = conn.prepareStatement(sql);
		
										ps.setString(1, podhod.getStPer()+"0"+"%");
										
										rs = ps.executeQuery();
										while (rs.next()) {
											podhod.setStPer(rs.getString("KOD_ST"));
										}
										rs.close();
										ps.close();
									}else{
										podhod.setStPer(podhod.getStPer().substring(0, 4)+"0"+podhod.getStPer().substring(4));
									}
									
									if (podhod.getStForm().equals("0000") || podhod.getStForm().equals("0001")) {
										podhod.setStForm(String.format("%-6s", podhod.getStForm()).replace(' ', '0'));
										podhod.setStNazn(String.format("%-6s", podhod.getStNazn()).replace(' ', '0'));
									}else{
										if (podhod.getStForm().length() == 4){										
											ps = conn.prepareStatement(sql);
			
											ps.setString(1, podhod.getStForm()+"0"+"%");
											
											rs = ps.executeQuery();
											while (rs.next()) {
												podhod.setStForm(rs.getString("KOD_ST"));
											}
											rs.close();
											ps.close();
										}else{
											podhod.setStForm(podhod.getStForm().substring(0, 4)+"0"+podhod.getStForm().substring(4));
										}
										
										if (podhod.getStNazn().length() == 4){										
											ps = conn.prepareStatement(sql);
			
											ps.setString(1, podhod.getStNazn()+"0"+"%");
											
											rs = ps.executeQuery();
											while (rs.next()) {
												podhod.setStNazn(rs.getString("KOD_ST"));
											}
											rs.close();
											ps.close();
										}else{
											podhod.setStNazn(podhod.getStNazn().substring(0, 4)+"0"+podhod.getStNazn().substring(4));
										}
									}/**/
	
									podhod.setIndPoezd(podhod.getStForm() + podhod.getnSost() + podhod.getStNazn());
	
									podhod.setHarP("00");
									podhod.setNbe("00000");
									/*
									 * podhod.setKolVag(mess.nextInt());
									 * podhod.setNvagN(mess.next());
									 * podhod.setNvagK(mess.next());
									 * podhod.setPrOhr(mess.nextInt());
									 * podhod.setNetto(mess.nextInt());
									 * list.add(podhod.getIndPoezd());
									 */
								} else {
									//while (mess.hasNext()) {
										if (!tmp.equals(":)")) {
											Vagon vagon = new Vagon();
											vagon.setNpp(Integer.parseInt(tmp));
											vagon.setnVag(mess.next());
											tmp = mess.next();
											vagon.setQual(tmp.substring(0, 1));
											vagon.setKodSob(tmp.substring(1, 3));
											vagon.setRolik(tmp.substring(3));
											vagon.setVesGr(mess.nextInt());
	
											
											tmp = mess.next();
											vagon.setStNaznV(tmp.substring(0, 4)+"0"+tmp.substring(4));
											/*sql = "select KOD_ST from STAN where KOD_ST like ?";
											ps = conn.prepareStatement(sql);
											ps.setString(1, tmp + "%");
											rs = ps.executeQuery();
											while (rs.next()) {
												if (rs.getString("KOD_ST").isEmpty()){
													tmp = "000000";
												}else{
													tmp = rs.getString("KOD_ST");
												}
												vagon.setStNaznV(tmp);
											}
											rs.close();	ps.close();*/
	
											
											sql = "select KODGR from GRUZ where KODGR like ?";
											
											ps = conn.prepareStatement(sql);
											ps.setString(1, mess.next() + "%"); 
											rs = ps.executeQuery(); 
											while (rs.next()) {
												vagon.setKodGr(rs.getString("KODGR")); 
											} 
											rs.close(); ps.close();
											//vagon.setKodGr(mess.next());
											vagon.setGrPol(mess.next());
											vagon.setMarsh(mess.next());
											vagon.setPrik(mess.next());
											vagon.setGivn(mess.next());
											vagon.setKolPl(mess.nextInt());
											tmp = mess.next();
											vagon.setGrKont(Integer.parseInt(tmp.substring(1, 2)));
											vagon.setPorKont(Integer.parseInt(tmp.substring(3, 5)));
	
											/*sql = "select ESR_VP from STAN_VPOGR where ESR_VP like ?";
											
											if ((tmp = mess.next()).equals("00000")){
												tmp = "000000";
											}else{
												ps = conn.prepareStatement(sql);
												ps.setString(1, tmp + "%");
												rs = ps.executeQuery();
												while (rs.next()) {
													if (rs.getString("ESR_VP").isEmpty()){
														tmp = "000000";
													}else{
														tmp = rs.getString("ESR_VP");
													}
												}
												rs.close();
												ps.close();
											}*/
											tmp = mess.next();
											vagon.setEsrVp(tmp.substring(0, 4)+"0"+tmp.substring(4));
											vagon.setTaraUt(mess.nextInt());
											if (!mess.hasNext()){
												tmp = " ";
											}else{
												tmp = mess.next();
												if (tmp.indexOf(":") > -1) {
													tmp = tmp.substring(0, tmp.indexOf(":"));
												}
											}
											vagon.setPrim(tmp);
											vagon.setIndPoezd(podhod.getIndPoezd());
											vagon.setTara(0);
	
											vagList.add(vagon);
										}
									//}
									podhod.setNvagN(vagList.get(0).getnVag());
									podhod.setNvagK(vagList.get(vagList.size() - 1).getnVag());
									podhod.setVagonList(vagList);
								}
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			podhodBean.add(podhod);
			/*
			 * System.out.printf(
			 * "KOD_OP = %d, ST_PER = %s, N_POEZD = %s, ST_FORM = %s, N_SOST = %s, "
			 * +
			 * "ST_NAZN = %s, PR_SPIS = %d, DV_OPER = %s, USL = %d, BRUTTO = %d, PRIK = %d, "
			 * + "NEGAB = %d, MARSH = %s, IND_POEZD = %s",podhod.getKodOp(),
			 * podhod.getStPer(), podhod.getnPoezd(), podhod.getStForm(),
			 * podhod.getnSost(), podhod.getStNazn(), podhod.getPrSpis(),
			 * format.format(podhod.getDvOtpr()), podhod.getUslDl(),
			 * podhod.getBrutto(), podhod.getPrik(), podhod.getNegab(),
			 * podhod.getGivn(), podhod.getMarsh(), podhod.getIndPoezd());
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
