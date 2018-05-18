package laskuri.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import laskuri.model.dao.OpiskelijaDAO;
import laskuri.model1.Opiskelija;

/**
 * Servlet implementation class SyotaTiedot
 */
@WebServlet("/syota-tiedot")
public class SyotaTiedot extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Lähettää selaimelle tietojen lisayslomakkeen
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String jsp = "/view/palkkatietolomake.jsp";
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
		dispather.forward(request, response);
	}

	/**
	 * Vastaanottaa tietoa selaimelta:
	 * 
	 * Haetaan lomakkeella syötetyt palkka tiedot request (pyyntö)-olion
	 * parametritiedoista ja lisätään tietokantaan.
	 * 
	 * @param request
	 *            pyyntö
	 * @param response
	 *            vastaus
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			// Haetaan lomakkeella syötetyn opiskelijan tiedot request-oliolta
			String idStr = request.getParameter("id"); // Id
			int id = new Integer(idStr);

			String bruttoStr = request.getParameter("brutto"); // bruttotulot
			bruttoStr = bruttoStr.replace(",", ".");
			double brutto = new Double(bruttoStr);

			String nettoStr = request.getParameter("netto"); // netto
			nettoStr = nettoStr.replace(",", ".");
			double netto = new Double(nettoStr);

			String opintotukiStr = request.getParameter("opintotuki"); // opintotuen
																		// maara
			opintotukiStr = opintotukiStr.replace(",", ".");
			double opintotuki = new Double(opintotukiStr);

			// Luodaan uusi opiskelija edellisillä parametreillä
			Opiskelija opiskelija = new Opiskelija(id, brutto, netto, opintotuki);

			// Luodaan opiskelijadao
			OpiskelijaDAO opiskelijadao = new OpiskelijaDAO();
			// Lisätään opiskelijan tiedot tietokantaan
			opiskelijadao.addOpiskelija(opiskelija);
		} catch (SQLException e) {
			// Virheilmoitus vaarasta syotteesta
			System.out.println("Sovelluksessa tapahtui virhe " + e.getMessage());
		}

		// uudelleenohjataan selain palkkatiedot-sivulle
		response.sendRedirect("listaa-tiedot");
	}

}
