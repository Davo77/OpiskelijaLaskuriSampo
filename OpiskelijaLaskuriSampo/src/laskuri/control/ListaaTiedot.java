package laskuri.control;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import laskuri.model.dao.OpiskelijaDAO;





/**
 * Servlet implementation class ListaaTiedot
 */
@WebServlet("/listaa-tiedot")
public class ListaaTiedot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// Luodaan opiskelijaDAO ja k�sket��n hakemaan kaikki tiedot tietokannasta
		OpiskelijaDAO kutsu = new OpiskelijaDAO();
		System.out.println(kutsu.findAll());
		
		// Talletetaan request-olion alle opiskelijalista, jotta tiedot ovat k�yt�ss� jsp:ll�
		request.setAttribute("opiskelijat", kutsu.findAll());
		
		// Talletetaan request-olion alle yhteenlasketut bruttopalkat
		request.setAttribute("totalbrutto", kutsu.getTotalBrutto());
		
		// Talletetaan request-olion alle yhteenlasketut nettopalkat
		request.setAttribute("totalnetto", kutsu.getTotalNetto());
		
		// Talletetaan request-olion alle opintotukikuukausien m��r�
		request.setAttribute("totalopintotuki", kutsu.getTotalOpintotuki());
		
		// l�het� selaimelta tullut pyynt� servletilt� edelleen  jsp:lle
		String jsp = "/view/palkkatiedot.jsp"; 
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
		dispather.forward(request, response);
	
	}

}
