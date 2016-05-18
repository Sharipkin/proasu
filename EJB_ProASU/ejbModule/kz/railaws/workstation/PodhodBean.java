package kz.railaws.workstation;

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

import kz.railaws.workstation.PodhodBeanLocal;
import kz.railways.entities.Podhod;

@Stateless
@LocalBean
public class PodhodBean implements PodhodBeanLocal {
	
	@Resource(mappedName = "jdbc/DB2Asuss")
    private DataSource dataSource;

	@Override
	public List<Podhod> showPodhod(String kodst) {
		
		String sql = "select * from P_TEK where KOD_OP<2";
		
		List<Podhod> lp = new ArrayList<>();
		
		try (Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();)	
		{
			while (rs.next())
			{
				Podhod poezd = new Podhod();
				poezd.setStPer(rs.getString("ST_PER"));
				poezd.setStNazn(rs.getString("ST_NAZN"));
				poezd.setStForm(rs.getString("ST_FORM"));
				poezd.setnSost(rs.getString("N_SOST"));
				poezd.setnPoezd(rs.getString("N_POEZD"));
				poezd.setDvOtpr(rs.getTimestamp("DV_OTPR"));
				poezd.setUslDl(rs.getInt("UDL"));
				poezd.setKolVag(rs.getInt("KVP"));
				poezd.setVesPoezd(rs.getInt("BRUTTO"));
				poezd.setNegab(rs.getString("NEGAB"));
				
				lp.add(poezd);
				
			}
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
			return null;
		}
				
		return lp;
	}

}
