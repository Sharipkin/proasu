package kz.railaws.workstation;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import kz.railways.entities.Napr;

@Stateless
@LocalBean
public class NaprBean implements NaprBeanLocal {

	@Override
	public List<Napr> getNapr(String kodst) {
		
		List<Napr> naprs = new ArrayList<Napr>();
		Napr napr = new Napr();
        napr.setKod(1);
        napr.setNaim("¿ “Œ¡≈-1");
        Napr napr2 = new Napr();
        napr2.setKod(2);
        napr2.setNaim("Õ» ≈À‹-“¿”");
        Napr napr3 = new Napr();
        napr3.setKod(3);
        napr3.setNaim("ÿ”¡¿–- ”ƒ” ");
        Napr napr4 = new Napr();
        napr4.setKod(4);
        napr4.setNaim("¿À√¿");
        
		return naprs;
	}

}
