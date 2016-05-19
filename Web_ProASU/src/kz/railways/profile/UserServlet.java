package kz.railways.profile;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kz.railways.beans.UserServiceBeanLocal;
import kz.railways.entities.Station;
import kz.railways.entities.User;


@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
    private UserServiceBeanLocal userService;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
				
		List<Station> lk = userService.getStations(request.getRemoteUser());
		
		User user = (User) request.getSession().getAttribute("user");
		
		request.setAttribute("listkodst", lk);
		request.setAttribute("activkodst", user.getStation().getKod());
		
		request.getRequestDispatcher("WEB-INF/pages/profile.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
