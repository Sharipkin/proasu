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

import kz.railways.entities.Napr;

@Stateless
@LocalBean
public class NaprBean implements NaprBeanLocal {
		
	@Resource(mappedName = "jdbc/DB2Asuss")
    private DataSource dataSource;

	@Override
	public List<Napr> getNapr(String kodst) {
		
		String sql = "select  KOD_NAPR, NAIM_NAPR from NAPR where KOD_ST=? and PR_CH > 0 order by KOD_NAPR";
		
		List<Napr> naprs = new ArrayList<Napr>();
		
		try (Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);) 
		{
			ps.setString(1, kodst);
			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{
				Napr napr = new Napr();
				
				napr.setKod(Integer.parseInt(rs.getString("KOD_NAPR")));
				napr.setNaim(rs.getString("NAIM_NAPR"));
				naprs.add(napr);
			}
			
			rs.close();
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
			return null;
		}
		       
		return naprs;
	}

}
