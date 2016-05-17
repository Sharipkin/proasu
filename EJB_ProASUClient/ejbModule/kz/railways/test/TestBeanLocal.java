package kz.railways.test;

import javax.ejb.Local;

@Local
public interface TestBeanLocal {
	
	public String sayHello();

}
