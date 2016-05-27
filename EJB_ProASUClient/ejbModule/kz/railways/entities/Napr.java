package kz.railways.entities;

import java.io.Serializable;

public class Napr implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int kod;
	private String naim;
	
	public int getKod() {
		return kod;
	}
	public String getKodString() {
		return String.valueOf(kod);
	}
	
	public void setKod(int kod) {
		this.kod = kod;
	}
	public String getNaim() {
		return naim;
	}
	public void setNaim(String naim) {
		this.naim = naim;
	}

}
