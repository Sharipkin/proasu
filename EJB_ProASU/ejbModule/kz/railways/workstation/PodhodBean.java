package kz.railways.workstation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.sql.DataSource;

import kz.railways.entities.Poezd;
import kz.railways.entities.Vagon;
import kz.railways.workstation.PodhodBeanLocal;

@Stateless
@LocalBean
public class PodhodBean implements PodhodBeanLocal {
	
	@Resource(mappedName = "jdbc/DB2Asuss")
    private DataSource dataSource;

	@Override
	public List<Poezd> showPodhod(String napr, String kodst) {
		
		/*String sql = "select ST_PER,N_POEZD,IND_POEZD,ST_FORM,N_SOST,ST_NAZN,PR_SPIS,DV_OTPR, "
				+ "UDL,BRUTTO,PRIK,NEGAB,GIVN,MARSH,NETTO,KOL_VAG,NVAG_N,NVAG_K,KOL_OS,KOL_ROL,PR_OHR,"
				+ "HAR_P,KOD_OP,DV_OPER,PR_DOST,KOD_ST,NBE"
				+ " from P_TEK where KOD_OP<2";*/
		String sqlPodhod = "select ST_PER,N_POEZD,IND_POEZD,ST_FORM,N_SOST,ST_NAZN,DV_OTPR, "
				+ "UDL,BRUTTO,PRIK,NEGAB,GIVN,MARSH,KOL_VAG,KOL_OS,KOL_ROL,PR_OHR"
				+ " from TABLE(PODHOD(?, ?, ?))";
		
		String sqlVagon = "select IND_POEZD, NPP, NVAG, QUAL, KOD_SOB, ROLIK, VESGR, "
				+ "ST_NAZNV, KODGR, GRPOL, MARSH, PRIK, GIVN, KOL_PL, GR_KONT, "
				+ "POR_KONT, ESR_VP, TARA_UT, PRIM, EDV, PR_ARND, PR_SOB "
				+ "from P_VAG where IND_POEZD Like ?";
		
		List<Poezd> lp = new ArrayList<>();
		
		
		try (Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sqlPodhod);
			PreparedStatement psVag = conn.prepareStatement(sqlVagon);
			)	
		{
			
			ps.setString(1, napr);
			ps.setString(2, kodst);
			ps.setString(3, "%");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				Poezd poezd = new Poezd();
				List<Vagon> lv = new ArrayList<>();
				
				poezd.setStPer(rs.getString("ST_PER"));
				poezd.setnPoezd(rs.getString("N_POEZD"));
				poezd.setIndPoezd(rs.getString("IND_POEZD"));
				poezd.setStForm(rs.getString("ST_FORM"));
				poezd.setnSost(rs.getString("N_SOST"));
				poezd.setStNazn(rs.getString("ST_NAZN"));
				poezd.setDvOtpr(rs.getTimestamp("DV_OTPR"));
				poezd.setUdl(rs.getInt("UDL"));
				poezd.setBrutto(rs.getInt("BRUTTO"));
				poezd.setPrik(rs.getInt("PRIK"));
				poezd.setNegab(rs.getInt("NEGAB"));
				poezd.setGivn(rs.getInt("GIVN"));
				poezd.setMarsh(rs.getString("MARSH"));
				poezd.setKolVag(rs.getInt("KOL_VAG"));
				poezd.setKolOs(rs.getInt("KOL_OS"));
				poezd.setKolRol(rs.getInt("KOL_ROL"));
				poezd.setPrOhr(rs.getInt("PR_OHR"));
			
				
				/*poezd.setStPer(rs.getString("ST_PER"));
				poezd.setnPoezd(rs.getString("N_POEZD"));
				poezd.setIndPoezd(rs.getString("IND_POEZD"));
				poezd.setStForm(rs.getString("ST_FORM"));
				poezd.setnSost(rs.getString("N_SOST"));
				poezd.setStNazn(rs.getString("ST_NAZN"));
				poezd.setPrSpis(rs.getInt("PR_SPIS"));
				poezd.setDvOtpr(rs.getTimestamp("DV_OTPR"));
				poezd.setUdl(rs.getInt("UDL"));
				poezd.setBrutto(rs.getInt("BRUTTO"));
				poezd.setPrik(rs.getInt("PRIK"));
				poezd.setNegab(rs.getInt("NEGAB"));
				poezd.setGivn(rs.getInt("GIVN"));
				poezd.setMarsh(rs.getString("MARSH"));
				poezd.setNetto(rs.getInt("NETTO"));
				poezd.setKolVag(rs.getInt("KOL_VAG"));
				poezd.setNvagN(rs.getString("NVAG_N"));
				poezd.setNvagK(rs.getString("NVAG_K"));
				poezd.setKolOs(rs.getInt("KOL_OS"));
				poezd.setKolRol(rs.getInt("KOL_ROL"));
				poezd.setPrOhr(rs.getInt("PR_OHR"));
				poezd.setHarP(rs.getString("HAR_P"));
				poezd.setKodOp(rs.getInt("KOD_OP"));
				poezd.setDvOper(rs.getTimestamp("DV_OPER"));
				poezd.setPrDost(rs.getInt("PR_DOST"));	
				poezd.setKodSt(rs.getString("KOD_ST"));
				poezd.setNbe(rs.getString("NBE"));*/
								
				psVag.setString(1, rs.getString("IND_POEZD"));
				ResultSet rsVag = psVag.executeQuery();
				while (rsVag.next())
				{
					
					Vagon vag = new Vagon();
										
					vag.setIndPoezd(rsVag.getString("IND_POEZD"));
					vag.setNpp(rsVag.getInt("NPP"));
					vag.setnVag(rsVag.getString("NVAG"));
					vag.setQual(rsVag.getString("QUAL"));
					vag.setKodSob(rsVag.getString("KOD_SOB"));
					vag.setRolik(rsVag.getString("ROLIK"));
					vag.setVesGr(rsVag.getInt("VESGR"));
					vag.setStNaznV(rsVag.getString("ST_NAZNV"));
					vag.setKodGr(rsVag.getString("KODGR"));
					vag.setGrPol(rsVag.getString("GRPOL"));
					vag.setMarsh(rsVag.getString("MARSH"));
					vag.setPrik(rsVag.getString("PRIK"));
					vag.setGivn(rsVag.getString("GIVN"));
					vag.setKolPl(rsVag.getInt("KOL_PL"));
					vag.setGrKont(rsVag.getInt("GR_KONT"));
					vag.setPorKont(rsVag.getInt("GR_KONT"));
					vag.setEsrVp(rsVag.getString("ESR_VP"));
					vag.setTaraUt(rsVag.getInt("TARA_UT"));
					vag.setPrim(rsVag.getString("PRIM"));
					vag.setEdv(rsVag.getInt("EDV"));
					vag.setPrArnd(rsVag.getInt("PR_ARND"));
					vag.setPrSob(rsVag.getInt("PR_SOB"));
					
					lv.add(vag);
				}
				rsVag.close();
				
				poezd.setVagonList(lv);
				lp.add(poezd);
				
			}
			
			rs.close();
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
			return null;
		}
				
		return lp;
	}

	@Override
	public void add(Poezd poezd) {
		
		String sql = "insert into P_TEK(IND_POEZD, GIVN, ST_PER, ST_FORM, N_SOST, ST_NAZN, PR_SPIS, "
				+ "MARSH, UDL, BRUTTO, NETTO, KOL_VAG, NVAG_N, NVAG_K, PR_OHR, KOD_ST, KOD_OP, DV_OTPR, DV_OPER, N_POEZD) "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try(Connection conn = dataSource.getConnection();)
		{
			try(PreparedStatement ps = conn.prepareStatement(sql);)
			{			
				
				ps.setString(1, poezd.getIndPoezd());
				ps.setInt(2, poezd.getGivn());
				ps.setString(3, poezd.getStPer());
				ps.setString(4, poezd.getStForm());
				ps.setString(5, poezd.getnSost());
				ps.setString(6, poezd.getStNazn());
				ps.setInt(7, poezd.getPrSpis());
				ps.setString(8, poezd.getMarsh());
				ps.setInt(9, poezd.getUdl());
				ps.setInt(10, poezd.getBrutto());
				ps.setInt(11, poezd.getNetto());
				ps.setInt(12, poezd.getKolVag());
				ps.setString(13, poezd.getNvagN());
				ps.setString(14, poezd.getNvagK());
				ps.setInt(15, poezd.getPrOhr());
				ps.setString(16, poezd.getKodSt());
				ps.setInt(17, poezd.getKodOp());
				ps.setTimestamp(18, poezd.getDvOtpr());
				ps.setTimestamp(19, poezd.getDvOper());
				ps.setString(20, poezd.getnPoezd());
				ps.executeUpdate();
				ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			sql = "insert into P_VAG(IND_POEZD, NPP, NVAG, QUAL, KOD_SOB, ROLIK, VESGR, ST_NAZNV, "
					+ "GRPOL, MARSH, PRIK, GIVN, KOL_PL, GR_KONT, POR_KONT, ESR_VP, TARA_UT, PRIM) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			try(PreparedStatement ps = conn.prepareStatement(sql);)
			{	
				for (Vagon v : poezd.getVagonList()){
					ps.setString(1, v.getIndPoezd());
					ps.setInt(2, v.getNpp());
					ps.setString(3, v.getnVag());
					ps.setString(4, v.getQual());
					ps.setString(5, v.getKodSob());
					ps.setString(6, v.getRolik());
					ps.setInt(7, v.getVesGr());
					ps.setString(8, v.getStNaznV());
					ps.setString(9, v.getGrPol());
					ps.setString(10, v.getMarsh());
					ps.setString(11, v.getPrik());
					ps.setString(12, v.getGivn());
					ps.setInt(13, v.getKolPl());
					ps.setInt(14, v.getGrKont());
					ps.setInt(15, v.getPorKont());
					ps.setString(16, v.getEsrVp());
					ps.setDouble(17, v.getTara());
					ps.setString(18, v.getPrim());
					
					ps.executeUpdate();
					/*System.out.printf("NPP = %d, NVAG = %s, QUAL = %s, KOD_SOB = %s, ROLIK = %s, "
					+ "VESGR = %d, ST_NAZN = %s, GR_POL = %s, MARSH = %s, PRIK = %s, GIVN = %s, "
					+ "KOL_PL = %s, GR_KONT = %d, POR_KONT = %d, ESR_VP = %s, PRIM = %s",v.getNpp(), v.getnVag(),
					v.getQual(), v.getKodSob(), v.getRolik(), v.getVesGr(), 
					v.getStNazn(), v.getGrPol(), v.getMarsh(), v.getPrik(),
					v.getPrik(), v.getKolPl(), v.getGrKont(), v.getPorKont(), v.getEsrVp(), v.getPrim());*/
				}			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			sql = "call WEBUSER.ZAP_SFRAZA(?,?,?,?)";
			
			try(PreparedStatement ps = conn.prepareStatement(sql);)
			{	
				ps.setString(1, poezd.getIndPoezd());
				ps.setTimestamp(2, poezd.getDvOper());
				ps.setInt(3, poezd.getKodOp());
				ps.setInt(4, poezd.getPrDost());
					
				ps.executeUpdate();		
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
