package kz.railways.model;

import java.util.List;

import javax.ejb.Local;

@Local
public interface UserServiceBeanLocal {
	
	public User find(String name);
	
	public List<String> getStations(String name);
	
	public void switchStation(String name, String kodSt);

}
