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
import ec.edu.ups.dao.UsuariosDAO;

import ec.edu.ups.entidades.PedidoCabecera;


/**
 * Servlet implementation class MostrarUsers
 */
@WebServlet("/MostrarUsersPeds")
public class MostrarUsersPeds extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuariosDAO usuDao; 
	private PedidoCabeceraDAO pedDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarUsersPeds() {
    	usuDao= DAOFactory.getFactory().getUsuariosDAO();
    	pedDao= DAOFactory.getFactory().getpeCabeceraDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url=null;
		try {
			int idUsu=Integer.parseInt(request.getParameter("usuID"));
				
				List<PedidoCabecera> list= pedDao.findPedidos(idUsu);
				
				request.setAttribute("listapedidos", list);

			url = "/HTMLs/Admin/usersPedidos.jsp";
			
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
