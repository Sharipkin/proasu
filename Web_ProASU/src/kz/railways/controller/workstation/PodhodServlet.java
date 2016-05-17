package kz.railways.controller.workstation;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kz.railaws.workstation.PodhodBeanLocal;
import kz.railways.model.Podhod;
import kz.railways.model.User;

@WebServlet("/podhod")
public class PodhodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	PodhodBeanLocal podhodBean;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User user = (User) request.getSession().getAttribute("user");
		
		List<Podhod> lp = podhodBean.showPodhod(user.getKodSt());
		
		/*for (Podhod p: lp)
		{
			response.getWriter().println(p.getStNazn()+ " " + p.getnPoezd() + " " + p.getStForm() + p.getDvOtpr() );
		}*/
		
		request.setAttribute("podhodList", lp);
	
		request.getRequestDispatcher("WEB-INF/pages/workstation/podhod/podhod-view.jsp").forward(request, response);
		
		

		//response.getWriter().println(podhodBean.showPodhod(user.getKodSt()));
	}

}
