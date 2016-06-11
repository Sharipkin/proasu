package kz.railways.controller.workstation;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kz.railways.entities.Park;
import kz.railways.entities.Poezd;
import kz.railways.entities.Put;
import kz.railways.workstation.ParkiBeanLocal;



/**
 * Servlet implementation class ParkServlet
 */
@WebServlet("/park")
public class ParkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@EJB
	ParkiBeanLocal parkiBean;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String npark = request.getParameter("park");
		String nput = request.getParameter("put");

		List<Park> POPark = (List<Park>) request.getSession().getAttribute("POPark");
		
		for(Park park : POPark){
			if(park.getnPark() == Integer.parseInt(npark)){
				for(Put put : park.getPutList()){
					if(put.getnPut() == Integer.parseInt(nput)){
						Poezd poezd = put.getPoezd();
						request.setAttribute("poezd", poezd);
					}
				}
			}
		}
		
		request.getRequestDispatcher("WEB-INF/pages/workstation/park/park-view.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
