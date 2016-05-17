package kz.railways.test;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class TestBean
 */
@Stateless
@LocalBean
public class TestBean implements TestBeanLocal {

	@Override
	public String sayHello() {
		return "Hello";
	}

}
