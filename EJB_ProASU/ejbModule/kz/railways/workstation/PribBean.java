package kz.railways.workstation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.sql.DataSource;

import kz.railways.entities.Poezd;


@Stateful
@LocalBean
public class PribBean implements PribBeanLocal {
	
	@Resource(mappedName = "jdbc/DB2Asuss")
    private DataSource dataSource;
	
	private Connection conn;
	
	private Poezd poezd;
	private String nPoezd;
	private String kodSt;
	private Timestamp dvOper;
	
	private String nPark;
	private String nPut;

	public Poezd getPoezd() {
		return poezd;
	}

	@Override
	public short checkPoezd(String indPoezd) {
		
		Poezd poezd = new Poezd();

		String sql = "select ST_PER,N_POEZD,IND_POEZD,ST_FORM,N_SOST,ST_NAZN,PR_SPIS,DV_OTPR, "
				+ "UDL,BRUTTO,PRIK,NEGAB,GIVN,MARSH,NETTO,KOL_VAG,NVAG_N,NVAG_K,KOL_OS,KOL_ROL,PR_OHR,"
				+ "HAR_P,KOD_OP,DV_OPER,PR_DOST,KOD_ST,NBE"
				+ " from P_TEK where IND_POEZD Like ? and KOD_ST Like '000000'";
		
		try(Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);)
		{
			ps.setString(1, indPoezd);
			
			System.out.println(indPoezd);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				poezd.setStPer(rs.getString("ST_PER"));
				poezd.setnPoezd(rs.getString("N_POEZD"));
				poezd.setIndPoezd(rs.getString("IND_POEZD"));
				poezd.setStForm(rs.getString("ST_FORM"));
				poezd.setnSost(rs.getString("N_SOST"));
				poezd.setStNazn(rs.getString("ST_NAZN"));				
			}
			
			rs.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		
		if (poezd.getIndPoezd() == null)
		{
			return 0;
		}
		else 
		{
			this.nPoezd = poezd.getnPoezd();
			this.poezd = poezd;
			return 1;
		}
		
		
	}

	@Override
	public short prib(String nPoezd, String kodSt, Timestamp dvOper, String nPark, String nPut) 
	{
		if (!nPoezd.isEmpty())
		{
			this.nPoezd = nPoezd;
		}
		this.kodSt = kodSt;
		this.dvOper = dvOper;
		this.nPark = nPark;
		this.nPut = nPut;
		
		
		try 
		{
			this.conn = dataSource.getConnection();	
			zapP_TEK();
			zapP_POP();
			return 1;
		}
		catch (SQLException e) 
		{
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return -1;
		}
		finally
		{
			try {	
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return -1;
			}
		}	
	}
	
	private void zapP_TEK() throws SQLException
	{
		String sql = "update P_TEK set N_POEZD = ?, KOD_OP = 2, DV_OPER = ?, KOD_ST = ? where IND_POEZD = ?";
		
		try(PreparedStatement ps = this.conn.prepareStatement(sql);)
		{
			ps.setString(1, this.nPoezd);
			ps.setTimestamp(2, this.dvOper);
			ps.setString(3, this.kodSt);
			ps.setString(4, this.poezd.getIndPoezd());
			
			ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new SQLException();
			
		}
	
	}
	
	private void zapP_POP() throws SQLException
	{
		String sql = "INSERT INTO P_POP(IND_POEZD, N_PARK, N_PUT, ST_FORM, N_SOST, ST_NAZN, N_POEZD,"
			    	+ "MNKD_OP, PR_TR, S_TGNL, PR_RASF, DV_OPER, HAR_P, KOL_OS, KOL_ROL, RAB_LOK, KOD_ST) "
			    	+"VALUES(?, ?, ?, ?, ?, ?, ?, ?, 0, '', 0, ?, '', ?, ?, 0, ?)";
		
		try(PreparedStatement ps = this.conn.prepareStatement(sql);)
		{
			ps.setString(1, this.poezd.getIndPoezd());
			ps.setString(2, this.nPark);
			ps.setString(3, this.nPut);
			ps.setString(4, this.poezd.getStForm());
			ps.setString(5, this.poezd.getnSost());
			ps.setString(6, this.poezd.getStNazn());
			ps.setString(7,this.nPoezd);
			
			ps.setString(8,"œ–»¡");

			ps.setTimestamp(9,this.dvOper);
			ps.setInt(10,this.poezd.getKolRol());
			ps.setInt(11,this.poezd.getKolRol());
			ps.setString(12,this.kodSt);
			
			
			ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new SQLException();
			
		}
		
	}

}
