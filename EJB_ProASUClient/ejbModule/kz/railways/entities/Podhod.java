package kz.railways.entities;

import java.io.Serializable;
import java.util.List;
import java.sql.Timestamp;

public class Podhod implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String stPer;
	private String nPoezd;
	private String stForm;
	private String nSost;
	private String stNazn;
	private Timestamp dvOtpr;
	private int uslDl;
	private int kolVag;
	private int vesPoezd;
	private int negab;
	
	private int kodOp;
	private String indPoezd;
	private int prSpis;
	private String marsh;
	private int brutto;
	private int netto;
	private String nvagN;
	private String nvagK;
	private int prOhr;
	private Timestamp dvOper;
	private int prik;
	private int givn;	
	private String kodSt;
	private List<Vagon> vagonList;
	
	public List<Vagon> getVagonList() {
		return vagonList;
	}
	public void setVagonList(List<Vagon> vagonList) {
		this.vagonList = vagonList;
	}
	public String getKodSt() {
		return kodSt;
	}
	public void setKodSt(String kodSt) {
		this.kodSt = kodSt;
	}
	public int getGivn() {
		return givn;
	}
	public void setGivn(int givn) {
		this.givn = givn;
	}
	public int getPrik() {
		return prik;
	}
	public void setPrik(int prik) {
		this.prik = prik;
	}
	public int getKodOp() {
		return kodOp;
	}
	public void setKodOp(int kodOp) {
		this.kodOp = kodOp;
	}
	public String getIndPoezd() {
		return indPoezd;
	}
	public void setIndPoezd(String indPoezd) {
		this.indPoezd = indPoezd;
	}
	public int getPrSpis() {
		return prSpis;
	}
	public void setPrSpis(int prSpis) {
		this.prSpis = prSpis;
	}
	public String getMarsh() {
		return marsh;
	}
	public void setMarsh(String marsh) {
		this.marsh = marsh;
	}
	public int getBrutto() {
		return brutto;
	}
	public void setBrutto(int brutto) {
		this.brutto = brutto;
	}
	public int getNetto() {
		return netto;
	}
	public void setNetto(int netto) {
		this.netto = netto;
	}
	public String getNvagN() {
		return nvagN;
	}
	public void setNvagN(String nvagN) {
		this.nvagN = nvagN;
	}
	public String getNvagK() {
		return nvagK;
	}
	public void setNvagK(String nvagK) {
		this.nvagK = nvagK;
	}
	public int getPrOhr() {
		return prOhr;
	}
	public void setPrOhr(int prOhr) {
		this.prOhr = prOhr;
	}
	public Timestamp getDvOper() {
		return dvOper;
	}
	public void setDvOper(Timestamp dvOper) {
		this.dvOper = dvOper;
	}
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
	public Timestamp getDvOtpr() {
		return dvOtpr;
	}
	public void setDvOtpr(Timestamp dvOtpr) {
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
	public int getNegab() {
		return negab;
	}
	public void setNegab(int negab) {
		this.negab = negab;
	}

}
