package kz.railways.beans;

import java.util.List;

import javax.ejb.Local;

import kz.railways.entities.Station;
import kz.railways.entities.User;

@Local
public interface UserServiceBeanLocal {
	
	public User find(String name);
	
	public List<Station> getStations(String name);
	
	public void switchStation(String name, String kodSt);

}
