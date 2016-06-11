package kz.railways.workstation;

import java.util.List;
import javax.ejb.Local;

import kz.railways.entities.Park;
import kz.railways.entities.Put;

@Local
public interface ParkiBeanLocal {
	public List<Park> getPOPark(String kodst);
	public List<Put> getPuti(String kodst, int park);
	public List<Put> getSortPark(String kodst);
	public Boolean hasRecPTek(String indP);
	public Boolean hasRecPPOP(String park, String put, String kodst);
}
