package kz.railways.entities;

import java.io.Serializable;

public class Put implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int npp;
	private int nPark;
	private int nPut;
	private int dlPut;
	private int prP;
	private int prZ;
	private String kodSt;
	private String mnkdPut;
	private String naimPut;
	private Poezd poezd;
	
	
	public int getNpp() {
		return npp;
	}
	public void setNpp(int npp) {
		this.npp = npp;
	}
	public int getnPark() {
		return nPark;
	}
	public void setnPark(int nPark) {
		this.nPark = nPark;
	}
	public int getnPut() {
		return nPut;
	}
	public void setnPut(int nPut) {
		this.nPut = nPut;
	}
	public int getDlPut() {
		return dlPut;
	}
	public void setDlPut(int dlPut) {
		this.dlPut = dlPut;
	}
	public int getPrP() {
		return prP;
	}
	public void setPrP(int prP) {
		this.prP = prP;
	}
	public int getPrZ() {
		return prZ;
	}
	public void setPrZ(int prZ) {
		this.prZ = prZ;
	}
	public String getKodSt() {
		return kodSt;
	}
	public void setKodSt(String kodSt) {
		this.kodSt = kodSt;
	}
	public String getMnkdPut() {
		return mnkdPut;
	}
	public void setMnkdPut(String mnkdPut) {
		this.mnkdPut = mnkdPut;
	}
	public String getNaimPut() {
		return naimPut;
	}
	public void setNaimPut(String naimPut) {
		this.naimPut = naimPut;
	}
	public Poezd getPoezd() {
		return poezd;
	}
	public void setPoezd(Poezd poezd) {
		this.poezd = poezd;
	}
	
}
