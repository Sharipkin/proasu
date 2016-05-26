package kz.railways.workstation;

import java.util.List;

import javax.ejb.Local;

import kz.railways.entities.Poezd;

@Local
public interface PodhodBeanLocal {
	
	public List<Poezd> showPodhod(String napr, String kodst);
	public void add(Poezd poezd);

}
