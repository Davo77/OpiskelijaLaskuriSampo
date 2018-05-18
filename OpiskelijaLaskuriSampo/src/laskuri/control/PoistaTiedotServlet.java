package laskuri.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import laskuri.model.dao.OpiskelijaDAO;


@WebServlet("/poista-tiedot")
public class PoistaTiedotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PoistaTiedotServlet() {
        super();
    }
    //Poistetaan palkkatieto kenttä ID:n perusteella
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String idStr = request.getParameter("opiskelijaId");
			int opiskelijaId = new Integer(idStr);
			OpiskelijaDAO opiskelijadao = new OpiskelijaDAO();
			opiskelijadao.removeTiedot(opiskelijaId);
		} catch (SQLException e) {
			
			System.out.println("Sovelluksessa tapahtui virhe " + e.getMessage());
		}

		// uudelleenohjataan selain Palkkatieto-sivulle
		response.sendRedirect("listaa-tiedot");
	}


}
