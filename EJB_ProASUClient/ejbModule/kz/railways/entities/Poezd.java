package kz.railways.entities;

import java.io.Serializable;
import java.util.List;
import java.sql.Timestamp;

public class Poezd implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String stPer;
	private String nPoezd;
	private String indPoezd;
	private String stForm;
	private String nSost;
	private String stNazn;
	private String naimStPer;
	private int prSpis;
	private Timestamp dvOtpr;
	private int udl;
	private int brutto;
	private int prik;
	private String negab;
	private int givn;
	private String marsh;
	private int netto;
	private int kolVag;
	private String nvagN;
	private String nvagK;
	private int kolOs;
	private int kolRol;
	private int prOhr;
	private String harP;
	private int kodOp;
	private Timestamp dvOper;
	private int prDost;
	private String mnkdOp;
	private String sTgnl;
	private int rabLok;
	private String kodSt;
	private String nbe;
	private List<Vagon> vagonList;
	
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
	public String getIndPoezd() {
		return indPoezd;
	}
	public void setIndPoezd(String indPoezd) {
		this.indPoezd = indPoezd;
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
	public String getNaimStPer() {
		return naimStPer;
	}
	public void setNaimStPer(String naimStPer) {
		this.naimStPer = naimStPer;
	}
	public int getPrSpis() {
		return prSpis;
	}
	public void setPrSpis(int prSpis) {
		this.prSpis = prSpis;
	}
	public Timestamp getDvOtpr() {
		return dvOtpr;
	}
	public void setDvOtpr(Timestamp dvOtpr) {
		this.dvOtpr = dvOtpr;
	}
	public int getUdl() {
		return udl;
	}
	public void setUdl(int udl) {
		this.udl = udl;
	}
	public int getBrutto() {
		return brutto;
	}
	public void setBrutto(int brutto) {
		this.brutto = brutto;
	}
	public int getPrik() {
		return prik;
	}
	public void setPrik(int prik) {
		this.prik = prik;
	}
	public String getNegab() {
		return negab;
	}
	public void setNegab(String negab) {
		this.negab = negab;
	}
	public int getGivn() {
		return givn;
	}
	public void setGivn(int givn) {
		this.givn = givn;
	}
	public String getMarsh() {
		return marsh;
	}
	public void setMarsh(String marsh) {
		this.marsh = marsh;
	}
	public int getNetto() {
		return netto;
	}
	public void setNetto(int netto) {
		this.netto = netto;
	}
	public int getKolVag() {
		return kolVag;
	}
	public void setKolVag(int kolVag) {
		this.kolVag = kolVag;
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
	public int getKolOs() {
		return kolOs;
	}
	public void setKolOs(int kolOs) {
		this.kolOs = kolOs;
	}
	public int getKolRol() {
		return kolRol;
	}
	public void setKolRol(int kolRol) {
		this.kolRol = kolRol;
	}
	public int getPrOhr() {
		return prOhr;
	}
	public void setPrOhr(int prOhr) {
		this.prOhr = prOhr;
	}
	public String getHarP() {
		return harP;
	}
	public void setHarP(String harP) {
		this.harP = harP;
	}
	public int getKodOp() {
		return kodOp;
	}
	public void setKodOp(int kodOp) {
		this.kodOp = kodOp;
	}
	public Timestamp getDvOper() {
		return dvOper;
	}
	public void setDvOper(Timestamp dvOper) {
		this.dvOper = dvOper;
	}
	public int getPrDost() {
		return prDost;
	}
	public void setPrDost(int prDost) {
		this.prDost = prDost;
	}
	public String getMnkdOp() {
		return mnkdOp;
	}
	public void setMnkdOp(String mnkdOp) {
		this.mnkdOp = mnkdOp;
	}
	
	public String getsTgnl() {
		return sTgnl;
	}
	public void setsTgnl(String sTgnl) {
		this.sTgnl = sTgnl;
	}
	public int getRabLok() {
		return rabLok;
	}
	public void setRabLok(int rabLok) {
		this.rabLok = rabLok;
	}
	public String getKodSt() {
		return kodSt;
	}	
	public void setKodSt(String kodSt) {
		this.kodSt = kodSt;
	}
	public String getNbe() {
		return nbe;
	}
	public void setNbe(String nbe) {
		this.nbe = nbe;
	}
	public List<Vagon> getVagonList() {
		return vagonList;
	}
	public void setVagonList(List<Vagon> vagonList) {
		this.vagonList = vagonList;
	}
}
