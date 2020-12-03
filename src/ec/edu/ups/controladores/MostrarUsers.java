package ec.edu.ups.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.UsuariosDAO;
import ec.edu.ups.modelo.Usuario;

/**
 * Servlet implementation class MostrarUsers
 */
@WebServlet("/MostrarUsers")
public class MostrarUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuariosDAO usuDao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarUsers() {
    	usuDao= DAOFactory.getFactory().getUsuariosDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url=null;
		try {
			int idEmp=Integer.parseInt(request.getParameter("idEmp"));
				
				List<Usuario> list= usuDao.findU(idEmp);
				
				request.setAttribute("listaClis", list);

			url = "/HTMLs/Admin/usersEmpresa.jsp";
			
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
