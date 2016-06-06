package kz.railways.filters;

import java.io.IOException;
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
import kz.railways.entities.Park;
import kz.railways.entities.Put;
import kz.railways.entities.User;
import kz.railways.workstation.NaprBeanLocal;
import kz.railways.workstation.ParkiBeanLocal;


@WebFilter("/*")
public class UserFilter implements Filter {

	@EJB
    private UserServiceBeanLocal userService;
	@EJB
	private NaprBeanLocal naprBean;
	@EJB
	private ParkiBeanLocal parkiBean;
	
	
	public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		//response.setCharacterEncoding("utf-8");
		//response.setContentType("text/html; charset=UTF-8");
		
				
		HttpServletRequest request = (HttpServletRequest) req;
        String remoteUser = request.getRemoteUser();

        if (remoteUser != null) {
            HttpSession session = request.getSession();

            if (session.getAttribute("user") == null) {
                User user = userService.find(remoteUser);
                session.setAttribute("user", user);
                
                List<Napr> naprs = naprBean.getNapr(user.getStation().getKod());        
                session.setAttribute("naprs", naprs);    
                
                List<Park> parki1 = parkiBean.getPOPark(user.getStation().getKod(), 1);
                session.setAttribute("parki1", parki1);
                
                List<Park> parki2 = parkiBean.getPOPark(user.getStation().getKod(), 2);                
                session.setAttribute("parki2", parki2);
                
                List<Put> sortPark = parkiBean.getSortPark(user.getStation().getKod());
                session.setAttribute("sortPark", sortPark);

            }
        }
		chain.doFilter(req, response);
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
