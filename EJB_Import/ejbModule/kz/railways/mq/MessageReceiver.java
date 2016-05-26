package kz.railways.mq;

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
    		System.out.println("----------------RESEIVED MESSAGE---------------------");
    		byte[] data = new byte[(int) bm.getBodyLength()];
    		bm.readBytes(data);
    		String content = new String(data);
    		try(Scanner mess = new Scanner(content);)
    		{
	    		while (mess.hasNext()){
	        		switch (mess.next()){
		        		case "(:902" : 	{parceMessage902(content);}
		        			break;
		        		}    
	    		}
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
			System.out.println(content);
			System.out.println(" ----------------END---------------------");
		} catch (JMSException e) {
			e.printStackTrace();
		}
        
    }
    
	public void parceMessage902(String m){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date()); // Date date
		int year = calendar.get(Calendar.YEAR);
		String day, month, hour, minute;
		String tmp;
		
		try(Scanner mess = new Scanner(m);){
			Poezd podhod = new Poezd();
			List<Vagon> vagList = new ArrayList<Vagon>();
			if (mess.next().equals("(:902")){
				//mess.next();
				podhod.setKodOp(0);
				podhod.setStPer(String.format("%-5s", mess.next()).replace(' ', '0'));  //вставка 5го символа 0 справа
				podhod.setnPoezd(mess.next());
				podhod.setStForm(mess.next());
				podhod.setnSost(String.format("%03d", Integer.parseInt(mess.next()))); //вставка 3го символа 0 слева
				podhod.setStNazn(mess.next());
				podhod.setPrSpis(mess.nextInt());
				day = mess.next();
				month = mess.next();
				hour = mess.next();
				minute = mess.next();
				podhod.setDvOtpr(Timestamp.valueOf(Integer.toString(year)+"-"+month+"-"+day+" "+hour+":"+minute+":00.000"));//"2016-01-19 14:01:00.000000"
				podhod.setUdl(mess.nextInt());
				podhod.setBrutto(mess.nextInt());
				podhod.setPrik(mess.nextInt());
				podhod.setNegab(mess.nextInt());
				podhod.setGivn(mess.nextInt());
				podhod.setMarsh(mess.next());
				podhod.setKodSt("000000");
				podhod.setKodOp(0);
				podhod.setDvOper(podhod.getDvOtpr());
				
				String sql = "select KOD_ST from STAN where KOD_ST like ?"; // and LENGTH(RTRIM(LTRIM(KOD_ST))) = 6
				
				try (Connection conn = dataSource.getConnection();){
						PreparedStatement ps;
						ps = conn.prepareStatement(sql);
						
						ps.setString(1, podhod.getStPer()+"%");
						ResultSet rs;
						rs = ps.executeQuery();
						while (rs.next()){
							podhod.setStPer(rs.getString("KOD_ST"));
						}	
						rs.close();
						ps.close();
							
						ps = conn.prepareStatement(sql);
						ps.setString(1, podhod.getStForm()+"%");
						rs = ps.executeQuery();
						while (rs.next()){
							podhod.setStForm(rs.getString("KOD_ST"));
						}
						rs.close();
						ps.close();
							
						ps = conn.prepareStatement(sql);
						ps.setString(1, podhod.getStNazn()+"%");
						rs = ps.executeQuery();
						while (rs.next()){
							podhod.setStNazn(rs.getString("KOD_ST"));
						}
						rs.close();
						ps.close();
						
						podhod.setIndPoezd(podhod.getStForm()+podhod.getnSost()+podhod.getStNazn());/**/
				}catch(SQLException e){
					e.printStackTrace();
				}
				/*podhod.setKolVag(mess.nextInt());
				podhod.setNvagN(mess.next());
				podhod.setNvagK(mess.next());
				podhod.setPrOhr(mess.nextInt());
				podhod.setNetto(mess.nextInt());
				list.add(podhod.getIndPoezd());*/
				while (mess.hasNext()){
					if (!(tmp = mess.next()).equals(":)")){
						Vagon vagon = new Vagon();
						vagon.setNpp(Integer.parseInt(tmp));
						vagon.setnVag(mess.next()); 
						tmp = mess.next();
						vagon.setQual(tmp.substring(0,1)); 
						vagon.setKodSob(tmp.substring(1,3)); 
						vagon.setRolik(tmp.substring(3)); 
						vagon.setVesGr(mess.nextInt()); 
						vagon.setStNaznV(mess.next()); 
						vagon.setKodGr(mess.next());
						vagon.setGrPol(mess.next()); 
						vagon.setMarsh(mess.next()); 
						vagon.setPrik(mess.next()); 
						vagon.setGivn(mess.next()); 
						vagon.setKolPl(mess.nextInt()); 
						tmp = mess.next();
						vagon.setGrKont(Integer.parseInt(tmp.substring(1,2))); 
						vagon.setPorKont(Integer.parseInt(tmp.substring(3,5)));
						vagon.setEsrVp(mess.next()); 
						vagon.setTara(mess.nextDouble()); 
						vagon.setPrim(mess.next());
						vagon.setIndPoezd(podhod.getIndPoezd());
						vagon.setTaraUt(0);
						vagList.add(vagon);
					}
				}
				podhod.setNvagN(vagList.get(0).getnVag());
				podhod.setNvagK(vagList.get(vagList.size() - 1).getnVag());
				podhod.setVagonList(vagList);
				podhodBean.add(podhod);
			}
			/*System.out.printf("KOD_OP = %d, ST_PER = %s, N_POEZD = %s, ST_FORM = %s, N_SOST = %s, "
					+ "ST_NAZN = %s, PR_SPIS = %d, DV_OPER = %s, USL = %d, BRUTTO = %d, PRIK = %d, "
					+ "NEGAB = %d, MARSH = %s, IND_POEZD = %s",podhod.getKodOp(), podhod.getStPer(),
					podhod.getnPoezd(), podhod.getStForm(), podhod.getnSost(), podhod.getStNazn(), 
					podhod.getPrSpis(), format.format(podhod.getDvOtpr()), podhod.getUslDl(), podhod.getBrutto(),
					podhod.getPrik(), podhod.getNegab(), podhod.getGivn(), podhod.getMarsh(), podhod.getIndPoezd());*/
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
