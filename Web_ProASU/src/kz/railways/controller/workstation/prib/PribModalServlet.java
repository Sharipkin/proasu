package kz.railways.controller.workstation.prib;

import java.io.IOException;
import java.sql.Timestamp;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kz.railways.entities.Poezd;
import kz.railways.entities.User;
import kz.railways.workstation.PribBeanLocal;


@WebServlet("/pribmodal")
public class PribModalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	PribBeanLocal pribBean;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String indPoezd = request.getParameter("indPoezd");
				
		if (indPoezd == null)
		{	
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
		else
		{
		
			if (pribBean.checkPoezd(indPoezd.trim())>0)
			{
				Poezd poezd = pribBean.getPoezd();
				request.setAttribute("poezd", poezd);
				
				//request.getRequestDispatcher("WEB-INF/pages/workstation/prib/prib.jsp").forward(request, response);
				request.getRequestDispatcher("WEB-INF/pages/workstation/prib/pribmodal.jsp").forward(request, response);
			}
			else
			{
				//PrintWriter pw = response.getWriter();
				//pw.println(indPoezd);
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		Timestamp dvOper = Timestamp.valueOf(request.getParameter("dvOper"));
		
		String nPoezd = request.getParameter("nPoezd");
		
		String nPark = request.getParameter("nPark");
		String nPut = request.getParameter("nPut");
		
		User user = (User) request.getSession().getAttribute("user");
		
		if (pribBean.prib(nPoezd,user.getStation().getKod(),dvOper,nPark,nPut) > 0)
		{
			request.getSession().setAttribute("POPark", null);
			response.sendRedirect("park?park="+nPark+"&put="+nPut);
		}
		else
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
	}

}
