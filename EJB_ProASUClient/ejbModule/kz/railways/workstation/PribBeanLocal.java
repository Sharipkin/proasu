package kz.railways.workstation;

import java.sql.Timestamp;

import javax.ejb.Local;

import kz.railways.entities.Poezd;

@Local
public interface PribBeanLocal {

	public Poezd getPoezd();
	public short checkPoezd(String indPoezd);
	public short prib(String nPoezd, String kodSt, Timestamp dvOper, String nPark, String nPut);
}
