package ec.edu.ups.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.UsuariosDAO;
import ec.edu.ups.entidades.Usuario;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UsuariosDAO usuDAO;
    private Usuario usu;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        usuDAO= DAOFactory.getFactory().getUsuariosDAO();
        usu = new Usuario();
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
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		try {
			String correo = request.getParameter("correo");
			String password = request.getParameter("password");
			
			
			usu = usuDAO.validarU(correo, password);
			
			if (usu == null) {
			
			url = "/JSPs/nousuario.jsp";
			}else if (usu.getRol() == 'U'){
				
				
				request.setAttribute("usu", usu);
				HttpSession session = request.getSession(true);
				session.setAttribute("accesos", 1);
				url = "/HTMLs/User/usrVin.jsp";
				
				
			}else if (usu.getRol() == 'A'){
				
				
				request.setAttribute("usu", usu);
				HttpSession session = request.getSession(true);
				session.setAttribute("accesos", 1);
				url = "/HTMLs/Admin/AdmVin.jsp";
			
			}
			
		
		
		} catch (Exception e) {
			url = "/JSPs/nousuario.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}


}