package ec.edu.ups.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EmpresaDAO;
import ec.edu.ups.dao.ProductosDao;
import ec.edu.ups.dao.UsuariosDAO;
import ec.edu.ups.entidades.Empresa;
import ec.edu.ups.entidades.Producto;
import ec.edu.ups.entidades.Usuario;

/**
 * Servlet implementation class VisualizacionProductosIntitado
 */
@WebServlet("/VisualizacionProductosInvitado")
public class VisualizacionProductosInvitado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private ProductosDao prodDAO;
	private UsuariosDAO usudao;
	private EmpresaDAO empDAO;
    
    
    public VisualizacionProductosInvitado() {
        prodDAO= DAOFactory.getFactory().getProductosDao();
        usudao= DAOFactory.getFactory().getUsuariosDAO();
        empDAO = DAOFactory.getFactory().getEmpresaDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url=null;
		String url2=null;
		try {
			int idEmp=Integer.parseInt(request.getParameter("idEmp"));
			List<Producto> list= prodDAO.findE(idEmp);
			
			Empresa emps = empDAO.read(idEmp);
			
			
			Usuario ste = new Usuario(0, "", "", "", "", 'a', emps);
			
			request.setAttribute("listaProd", list);
			
			
			request.setAttribute("idEmp", ste);
			
			
			
			url = "/HTMLs/Invitado/invVin.jsp";
		}catch(Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);

	}

}
