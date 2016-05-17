package kz.railaws.workstation;

import java.util.List;

import javax.ejb.Local;

import kz.railways.model.Podhod;

@Local
public interface PodhodBeanLocal {
	
	public List<Podhod> showPodhod(String kodst);

}
