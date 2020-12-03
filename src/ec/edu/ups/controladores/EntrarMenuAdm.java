package ec.edu.ups.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.UsuariosDAO;

import ec.edu.ups.entidades.Usuario;

/**
 * Servlet implementation class EntrarMenuAdm
 */
@WebServlet("/EntrarMenuAdm")
public class EntrarMenuAdm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private UsuariosDAO usuDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EntrarMenuAdm() {
    	usuDao= DAOFactory.getFactory().getUsuariosDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * Esto hay que editar mas luego
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url=null;
		String url2="root";
		try {
			String idEmp=request.getParameter("idEmp");
			
			Usuario usu= usuDao.validarU(idEmp, url2);
			
			
			request.setAttribute("usu", usu);
			url = "/HTMLs/Admin/AdmVin.jsp";
		}catch(Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
