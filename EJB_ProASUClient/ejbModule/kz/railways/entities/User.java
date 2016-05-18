package kz.railways.entities;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String kodSt;
	private List<String> listKodSt;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKodSt() {
		return kodSt;
	}
	public void setKodSt(String kodSt) {
		this.kodSt = kodSt;
	}
	public List<String> getListKodSt() {
		return listKodSt;
	}
	public void setListKodSt(List<String> listKodSt) {
		this.listKodSt = listKodSt;
	}
		
}
