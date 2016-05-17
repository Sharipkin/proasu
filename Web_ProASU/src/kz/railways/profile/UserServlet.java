package kz.railways.profile;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kz.railways.model.User;
import kz.railways.model.UserServiceBeanLocal;


@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
    private UserServiceBeanLocal userService;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
				
		List<String> lk = userService.getStations(request.getRemoteUser());
		
		User user = (User) request.getSession().getAttribute("user");
		
		request.setAttribute("listkodst", lk);
		request.setAttribute("activkodst", user.getKodSt());
		
		request.getRequestDispatcher("WEB-INF/pages/profile.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
