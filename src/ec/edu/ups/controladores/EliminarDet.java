package ec.edu.ups.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.PedidoDetalleDAO;
import ec.edu.ups.entidades.PedidoDetalle;
/**
 * Servlet implementation class EliminarDet
 */
@WebServlet("/EliminarDet")
public class EliminarDet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PedidoDetalleDAO pedDetDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarDet() {
    	pedDetDAO=DAOFactory.getFactory().getpeDetalleDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="";
		try {
			
			int idCab= Integer.parseInt(request.getParameter("idCab"));
			int idDet= Integer.parseInt(request.getParameter("idDet"));
			
			//PedidoDetalle ste = new PedidoDetalle(idDet, 0, 0, 0, "", 0);Linea a revisar
			
			//Metodo para cambiar de estado
			pedDetDAO.delete(ste);
			
			
			
			//Actializacion By charly
			request.setAttribute("idCab", idCab);
			url="/ActualizarPedidosDetalle";
		}catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
	    getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
