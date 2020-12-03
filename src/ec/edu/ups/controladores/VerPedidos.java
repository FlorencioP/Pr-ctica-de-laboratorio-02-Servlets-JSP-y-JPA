package ec.edu.ups.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.PedidoCabeceraDAO;
import ec.edu.ups.entidades.PedidoCabecera;

@WebServlet("/VerPedidos")
public class VerPedidos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private PedidoCabeceraDAO pedCabDAO;
    public VerPedidos() {
    	pedCabDAO=DAOFactory.getFactory().getpeCabeceraDAO(); 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="";
		try {
			int id= Integer.parseInt(request.getParameter("usuID"));
			List<PedidoCabecera> list=pedCabDAO.findU(id);
			request.setAttribute("listPedCab", list);
			
			
			url="/HTMLs/User/MostrarPedidos.jsp";
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
