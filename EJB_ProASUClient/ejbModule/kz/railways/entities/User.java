package kz.railways.entities;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Station station;
	private List<Station> listStations;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Station getStation() {
		return station;
	}
	public void setStation(Station station) {
		this.station = station;
	}
	public List<Station> getListStations() {
		return listStations;
	}
	public void setListStations(List<Station> listStations) {
		this.listStations = listStations;
	}
		
}
