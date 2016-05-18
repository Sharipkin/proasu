package kz.raiways.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kz.railways.beans.UserServiceBeanLocal;
import kz.railways.entities.Napr;
import kz.railways.entities.User;


@WebFilter("/*")
public class UserFilter implements Filter {

	@EJB
    private UserServiceBeanLocal userService;
	
	public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
				
		HttpServletRequest request = (HttpServletRequest) req;
        String remoteUser = request.getRemoteUser();

        if (remoteUser != null) {
            HttpSession session = request.getSession();

            if (session.getAttribute("user") == null) {
                User user = userService.find(remoteUser);
                session.setAttribute("user", user);
                
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
                naprs.add(napr);
                naprs.add(napr2);
                naprs.add(napr3);
                naprs.add(napr4);
                session.setAttribute("naprs", naprs);    
                session.setAttribute("napr", napr); 
            }
        }
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
