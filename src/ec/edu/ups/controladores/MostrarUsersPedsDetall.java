package ec.edu.ups.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;

import ec.edu.ups.dao.PedidoDetalleDAO;


import ec.edu.ups.entidades.PedidoDetalle;

/**
 * Servlet implementation class MostrarUsers
 */
@WebServlet("/MostrarUsersPedsDetall")
public class MostrarUsersPedsDetall extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PedidoDetalleDAO detsDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarUsersPedsDetall() {
    	detsDao= DAOFactory.getFactory().getpeDetalleDAO();
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url=null;
		try {
			int idUsu=Integer.parseInt(request.getParameter("cabsID"));
				
				List<PedidoDetalle> list= detsDao.listPed(idUsu);
				
				request.setAttribute("listadetalles", list);

			url = "/HTMLs/Admin/usersPedidosDetall.jsp";
			
		}catch(Exception e) {
			System.out.println("Error : "+e) ;
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
