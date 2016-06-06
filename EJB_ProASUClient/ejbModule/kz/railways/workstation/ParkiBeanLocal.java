package kz.railways.workstation;

import java.util.List;
import javax.ejb.Local;

import kz.railways.entities.Park;
import kz.railways.entities.Put;

@Local
public interface ParkiBeanLocal {
	public List<Park> getPOPark(String kodst, int s);
	public List<Put> getSortPark(String kodst);
}
