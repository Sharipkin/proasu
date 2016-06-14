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

import kz.railways.entities.Park;
import kz.railways.entities.Put;
import kz.railways.entities.Poezd;
import kz.railways.entities.Vagon;

import kz.railways.workstation.ParkiBeanLocal;

/**
 * Session Bean implementation class ParkiBean
 */
@Stateless
@LocalBean
public class ParkiBean implements ParkiBeanLocal {
	
	@Resource(mappedName = "jdbc/DB2Asuss")
    private DataSource dataSource;
    /**
     * Default constructor. 
     */
	@Override
	public List<Park> getPOPark(String kodst){
		String sql = "SELECT N_PARK, NAIM_PARK, KOD_S FROM STATION_PARK WHERE TIP_PARK<>2 AND KOD_ST = ? ORDER BY NPP, N_PARK";
		
		List<Park> lp = new ArrayList<>();
		
		try (Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);)	
		{			
			ps.setString(1, kodst);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				Park park = new Park();
				park.setnPark(rs.getInt("N_PARK"));
				park.setName(rs.getString("NAIM_PARK"));
				park.setKodS(rs.getInt("KOD_S"));
				
				List<Put> lpPut = getPuti(kodst, park.getnPark());
				
				park.setPutList(lpPut);
				lp.add(park);
				
			}
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
			return null;
		}
				
		return lp;
	}
	
	@Override
	public List<Put> getPuti(String kodst, int park){
		List<Put> lpPut = new ArrayList<>();
		String sqlPut = "SELECT STATION_PARKPUT.KOD_ST, STATION_PARKPUT.N_PARK,STATION_PARKPUT.N_PUT,STATION_PARKPUT.MNKD_PUT,STATION_PARKPUT.NAIM_PUT,"+
		        "P_POP.IND_POEZD,P_POP.N_PARK,P_POP.N_PUT,P_POP.ST_NAZN,P_POP.N_SOST, "+
		        "P_POP.ST_FORM,P_POP.N_POEZD,P_POP.MNKD_OP,P_POP.PR_TR,P_POP.S_TGNL, "+
		        "P_POP.PR_RASF, P_POP.DV_OPER, "+
		        "P_POP.HAR_P,P_POP.KOL_OS,P_POP.KOL_ROL,P_POP.KOD_ST,P_POP.RAB_LOK, "+
		        "P_TEK.IND_POEZD,P_TEK.BRUTTO,P_TEK.UDL,P_TEK.NEGAB, P_TEK.GIVN, "+
		        "P_TEK.KOL_VAG,P_TEK.NVAG_N,P_TEK.NVAG_K,P_TEK.PR_OHR,P_TEK.PRIK,P_TEK.KOD_OP,P_TEK.MARSH "+
		        "FROM STATION_PARKPUT LEFT JOIN P_POP "+
		             "ON STATION_PARKPUT.N_PARK = P_POP.N_PARK AND "+ 
		                   "STATION_PARKPUT.N_PUT = P_POP.N_PUT AND STATION_PARKPUT.KOD_ST = P_POP.KOD_ST "+
		                "LEFT JOIN P_TEK ON P_POP.IND_POEZD = P_TEK.IND_POEZD and P_POP.KOD_ST=P_TEK.KOD_ST "+
		                "WHERE STATION_PARKPUT.N_PARK = ? AND STATION_PARKPUT.KOD_ST = ? ORDER BY STATION_PARKPUT.N_PUT";
		try(Connection conn = dataSource.getConnection();
			PreparedStatement psPut = conn.prepareStatement(sqlPut)){
			psPut.setInt(1, park);
			psPut.setString(2, kodst);
			
			ResultSet rsPut = psPut.executeQuery();
			while(rsPut.next()){
				Put put = new Put();
				put.setnPark(rsPut.getInt("N_PARK"));
				put.setnPut(rsPut.getInt("N_PUT"));
				put.setNaimPut(rsPut.getString("NAIM_PUT"));
				
				Poezd poezd = new Poezd();
				poezd.setIndPoezd(rsPut.getString("IND_POEZD"));
				poezd.setnPoezd(rsPut.getString("N_POEZD"));
				poezd.setStForm(rsPut.getString("ST_FORM"));
				poezd.setnSost(rsPut.getString("N_SOST"));
				poezd.setStNazn(rsPut.getString("ST_NAZN"));
				poezd.setMnkdOp(rsPut.getString("MNKD_OP"));				
				poezd.setDvOper(rsPut.getTimestamp("DV_OPER"));
				poezd.setKolVag(rsPut.getInt("KOL_VAG"));
				poezd.setBrutto(rsPut.getInt("BRUTTO"));
				poezd.setUdl(rsPut.getInt("UDL"));
				poezd.setKolOs(rsPut.getInt("KOL_OS"));
				poezd.setKolRol(rsPut.getInt("KOL_ROL"));
				poezd.setsTgnl(rsPut.getString("S_TGNL"));
				poezd.setHarP(rsPut.getString("HAR_P"));
				poezd.setNegab(rsPut.getString("NEGAB"));
				poezd.setGivn(rsPut.getInt("GIVN"));
				poezd.setPrik(rsPut.getInt("PRIK"));
				poezd.setPrOhr(rsPut.getInt("PR_OHR"));
				poezd.setNvagK(rsPut.getString("NVAG_N"));
				poezd.setNvagN(rsPut.getString("NVAG_K"));
				poezd.setRabLok(rsPut.getInt("RAB_LOK"));
				
				List<Vagon> lpVagon = new ArrayList<>();
				String sqlVagon = "SELECT NPP, NVAG, KOD_SOB, ROLIK, VESGR, ST_NAZNV, KODGR, GRPOL, MARSH, PRIK, GIVN, KOL_PL, GR_KONT, POR_KONT, ESR_VP, TARA_UT, PRIM FROM P_VAG "+
				                "WHERE IND_POEZD = ? ORDER BY NPP";
				
				try(PreparedStatement psVagon = conn.prepareStatement(sqlVagon)){
						psVagon.setString(1, poezd.getIndPoezd());						
						ResultSet rsVagon = psVagon.executeQuery();
						while(rsVagon.next()){
							Vagon vagon = new Vagon();
							vagon.setNpp(rsVagon.getInt("NPP"));
							vagon.setnVag(rsVagon.getString("NVAG"));
							vagon.setKodSob(rsVagon.getString("KOD_SOB"));
							vagon.setRolik(rsVagon.getString("ROLIK")); 
							vagon.setVesGr(rsVagon.getInt("VESGR"));  
							vagon.setStNaznV(rsVagon.getString("ST_NAZNV")); 
							vagon.setKodGr(rsVagon.getString("KODGR")); 
							vagon.setGrPol(rsVagon.getString("GRPOL")); 
							vagon.setMarsh(rsVagon.getString("MARSH")); 
							vagon.setPrik(rsVagon.getString("PRIK")); 
							vagon.setGivn(rsVagon.getString("GIVN")); 
							vagon.setKolPl(rsVagon.getInt("KOL_PL"));
							vagon.setGrKont(rsVagon.getInt("GR_KONT"));
							vagon.setPorKont(rsVagon.getInt("POR_KONT"));
							vagon.setEsrVp(rsVagon.getString("ESR_VP"));
							vagon.setTaraUt(rsVagon.getInt("TARA_UT"));
							vagon.setPrim(rsVagon.getString("PRIM"));
							  
							lpVagon.add(vagon);
						}
				}
				poezd.setVagonList(lpVagon);
				put.setPoezd(poezd);
				lpPut.add(put);
			}
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			return null;
		}
		
		return lpPut;
	}
	
	@Override
	public List<Put> getSortPark(String kodst){
		String sql = "SELECT * FROM STATION_PARKPUT where N_PARK = 3 and KOD_ST = ?";
		List<Put> lp = new ArrayList<>();
		
		try (Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);)
		{
			ps.setString(1, kodst);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Put put = new Put();
				put.setnPark(rs.getInt("N_PARK"));
				put.setnPut(rs.getInt("N_PUT"));
				put.setNaimPut(rs.getString("NAIM_PUT"));
				//put.setPoezd(put);
				lp.add(put);
				
			}
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		
		return lp;		
	}
}
