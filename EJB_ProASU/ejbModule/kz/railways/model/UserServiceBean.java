package kz.railways.model;

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

import kz.railways.beans.UserServiceBeanLocal;
import kz.railways.entities.Station;
import kz.railways.entities.User;

@Stateless
@LocalBean
public class UserServiceBean implements UserServiceBeanLocal {

	@Resource(mappedName = "jdbc/DB2Asuss")
    private DataSource dataSource;

	@Override
	public User find(String name) {
		
		User user = new User();
		
		String sql = "select U.USERNAME as username, US.KOD_ST as kodst, S.NAIM_ST as naimst from USERS as U " +
					 "INNER JOIN USER_STATIONS as US on US.USER_ID = U.ID  " +
				     "INNER JOIN STATION as S on S.KOD_ST = US.KOD_ST " + 
					 "WHERE US.ACTIV_ST = 1 AND U.USERNAME like ?";
		
		try (Connection conn = dataSource.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql);){
			
			
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{
				user.setName(rs.getString("username"));
				user.setStation(new Station(rs.getString("kodst"), rs.getString("naimst"), true));
			}
			
			rs.close();
			
			user.setListStations(this.getStations(user.getName()));
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
			return null;
		}
		
		
		return user;

	}


	@Override
	public List<Station> getStations(String name) {
		List<Station> listKodSt = new ArrayList<Station>();
		
		String sql = "select US.KOD_ST, S.NAIM_ST, US.ACTIV_ST from USERS as U  " +
					 "INNER JOIN USER_STATIONS as US on US.USER_ID = U.ID  " +
					 "INNER JOIN STATION as S on S.KOD_ST = US.KOD_ST "+
				 	 "WHERE U.USERNAME like ? AND US.ACTIV_ST = 0";
	
		try(Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);) 
		{
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{
				listKodSt.add(new Station(rs.getString("KOD_ST"),
										  rs.getString("NAIM_ST"),
									  	  rs.getBoolean("ACTIV_ST")));
			}
			
			rs.close();

		} catch (SQLException e) 
		{
			e.printStackTrace();
			return null;
		}
		finally{
			
		}
		
		
		return listKodSt;
	}


	@Override
	public void switchStation(String name, String kodSt) {
		try {

			Connection conn = dataSource.getConnection();
			PreparedStatement ps;

			String sql = "update USER_STATIONS set ACTIV_ST = 0 where " +
					 "USER_ID in (select ID from USERS where USERNAME like ?)";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.executeUpdate();
			ps.close();
			
			sql = "update USER_STATIONS set ACTIV_ST = 1 where " +
					 "USER_ID in (select ID from USERS where USERNAME like ?) "+
					"and KOD_ST like ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, kodSt);
			ps.executeUpdate();
			ps.close();
			
			conn.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

}
