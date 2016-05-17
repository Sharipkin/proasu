package kz.railways.model;

import java.io.Serializable;
import java.util.Date;

public class Podhod implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String stPer;
	private String nPoezd;
	private String stForm;
	private String nSost;
	private String stNazn;
	private Date dvOtpr;
	private int uslDl;
	private int kolVag;
	private int vesPoezd;
	private String negab;
	
	
	
	public String getStPer() {
		return stPer;
	}
	public void setStPer(String stPer) {
		this.stPer = stPer;
	}
	public String getnPoezd() {
		return nPoezd;
	}
	public void setnPoezd(String nPoezd) {
		this.nPoezd = nPoezd;
	}
	public String getStForm() {
		return stForm;
	}
	public void setStForm(String stForm) {
		this.stForm = stForm;
	}
	public String getnSost() {
		return nSost;
	}
	public void setnSost(String nSost) {
		this.nSost = nSost;
	}
	public String getStNazn() {
		return stNazn;
	}
	public void setStNazn(String stNazn) {
		this.stNazn = stNazn;
	}
	public Date getDvOtpr() {
		return dvOtpr;
	}
	public void setDvOtpr(Date dvOtpr) {
		this.dvOtpr = dvOtpr;
	}
	public int getUslDl() {
		return uslDl;
	}
	public void setUslDl(int uslDl) {
		this.uslDl = uslDl;
	}
	public int getKolVag() {
		return kolVag;
	}
	public void setKolVag(int kolVag) {
		this.kolVag = kolVag;
	}
	public int getVesPoezd() {
		return vesPoezd;
	}
	public void setVesPoezd(int vesPoezd) {
		this.vesPoezd = vesPoezd;
	}
	public String getNegab() {
		return negab;
	}
	public void setNegab(String negab) {
		this.negab = negab;
	}

}
