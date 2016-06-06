package kz.railways.entities;

import java.io.Serializable;
import java.util.List;


public class Park implements Serializable{
	private static final long serialVersionUID = 1L;
	private int npp;
	private int nPark;
	private int tipPark;
	private int kodS;
	private int kodSt;
	private String name;
	private List<Put> putList;
	
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

	public int getTipPark() {
		return tipPark;
	}

	public void setTipPark(int tipPark) {
		this.tipPark = tipPark;
	}

	public int getKodS() {
		return kodS;
	}

	public void setKodS(int kodS) {
		this.kodS = kodS;
	}

	public int getKodSt() {
		return kodSt;
	}

	public void setKodSt(int kodSt) {
		this.kodSt = kodSt;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public List<Put> getPutList() {
		return putList;
	}

	public void setPutList(List<Put> putList) {
		this.putList = putList;
	}
}
