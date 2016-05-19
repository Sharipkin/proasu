package kz.railways.profile;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kz.railways.beans.UserServiceBeanLocal;

@WebServlet("/switchstation")
public class SwitchStationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@EJB
    private UserServiceBeanLocal userService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String kodSt = req.getParameter("userkodst");
		
		String remoteUser = req.getRemoteUser();

		userService.switchStation(remoteUser, kodSt);
		
		req.getSession().setAttribute("user", null);
	
		resp.sendRedirect("index");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String kodSt = request.getParameter("userkodst");
		
		String remoteUser = request.getRemoteUser();
		
		userService.switchStation(remoteUser, kodSt);
		
		request.getSession().setAttribute("user", null);
	
		response.sendRedirect("user");
	}
}
