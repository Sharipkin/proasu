package kz.railways.entities;

import java.io.Serializable;

public class Station  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String kod;
	private String naim;
	private Boolean active;
	private int kodS;
	
	public Station(){
	}	
	
	public Station(String kod, String naim, int kodS, Boolean active) {
		super();
		this.kod = kod;
		this.naim = naim;
		this.kodS = kodS;
		this.active = active;		 
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public String getKod() {
		return kod;
	}
	public void setKod(String kod) {
		this.kod = kod;
	}
	public String getNaim() {
		return naim;
	}
	public void setNaim(String naim) {
		this.naim = naim;
	}
	
	public int getKodS() {
		return kodS;
	}
	public void setKodS(int kodS) {
		this.kodS = kodS;
	}

}
