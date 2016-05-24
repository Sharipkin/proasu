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
	public List<Poezd> showPodhod(String kodst) {
		
		String sql = "select * from P_TEK where KOD_OP<2";
		
		List<Poezd> lp = new ArrayList<>();
		
		try (Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();)	
		{
			while (rs.next())
			{
				Poezd poezd = new Poezd();
				poezd.setStPer(rs.getString("ST_PER"));
				poezd.setStNazn(rs.getString("ST_NAZN"));
				poezd.setStForm(rs.getString("ST_FORM"));
				poezd.setnSost(rs.getString("N_SOST"));
				poezd.setnPoezd(rs.getString("N_POEZD"));
				poezd.setDvOtpr(rs.getTimestamp("DV_OTPR"));
				poezd.setUslDl(rs.getInt("UDL"));
				poezd.setKolVag(rs.getInt("KVP"));
				poezd.setVesPoezd(rs.getInt("BRUTTO"));
				poezd.setNegab(rs.getInt("NEGAB"));
				
				lp.add(poezd);
				
			}
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
			return null;
		}
				
		return lp;
	}

	@Override
	public void add(Poezd poezd) {
		
		String sql = "insert into P_TEK(IND_POEZD, GIVN, ST_PER, ST_FORM, N_SOST, ST_NAZN, P_SPIS, "
				+ "MARSH, UDL, BRUTTO, NETTO, KVP, NVAG_N, NVAG_K, P_OHR, KOD_ST, KOD_OP, DV_OTPR, DV_OPER, N_POEZD) "
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
				ps.setInt(9, poezd.getUslDl());
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
			
			sql = "insert into P_VAG(IND_POEZD, NPP, NVAG, QUAL, KOD_SOB, ROLIK, VESGR, ST_NAZN, "
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
					ps.setString(8, v.getStNazn());
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
