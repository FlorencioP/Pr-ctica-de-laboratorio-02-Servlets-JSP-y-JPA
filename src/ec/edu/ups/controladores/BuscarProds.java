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
import ec.edu.ups.entidades.Empresa;
import ec.edu.ups.entidades.Producto;
import ec.edu.ups.entidades.Usuario;

/**
 * Servlet implementation class BuscarProds
 */
@WebServlet("/BuscarProds")
public class BuscarProds extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductosDao proDao;   
	private EmpresaDAO empDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarProds() {
    	proDao= DAOFactory.getFactory().getProductosDao();
    	empDAO = DAOFactory.getFactory().getEmpresaDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url=null;
		try {
			
			int idEmp=Integer.parseInt(request.getParameter("idEmp"));
			int cat=Integer.parseInt(request.getParameter("cat"));
			String tex = request.getParameter("palb");
			
			
			
			List<Producto> list=null;
			
			if (tex.isEmpty()) {
				
				list=proDao.findC(cat,idEmp);
				
			}else{
				
				list=proDao.findCnomb(cat,idEmp,tex);
			
			}

			
			request.setAttribute("listaProd", list);
			
			
			
			Empresa Empr = empDAO.read(idEmp); 
			
			
			Usuario ste = new Usuario(0, "F", "F", "F", "F", 'F',  Empr);
			
			request.setAttribute("usu", ste);
			
			
			
			url = "/HTMLs/Admin/TablaEditarProds.jsp";
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
