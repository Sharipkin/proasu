package kz.railaws.workstation;

import java.util.List;
import javax.ejb.Local;
import kz.railways.entities.Napr;

@Local
public interface NaprBeanLocal {
	
	public List<Napr> getNapr(String kodst);

}
