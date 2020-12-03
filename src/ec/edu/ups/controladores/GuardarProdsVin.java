package ec.edu.ups.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.entidades.Categoria;
import ec.edu.ups.entidades.Empresa;
import ec.edu.ups.entidades.Producto;
import ec.edu.ups.dao.ProductosDao;
import ec.edu.ups.dao.CAtegoriaDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EmpresaDAO;


/**
 * Servlet implementation class GuardarProdsVin
 */
@WebServlet("/GuardarProdsVin")
public class GuardarProdsVin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductosDao proDao;  
	private CAtegoriaDAO catDao;
	private EmpresaDAO empDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuardarProdsVin() {
    	
    	proDao= DAOFactory.getFactory().getProductosDao();
    	catDao= DAOFactory.getFactory().getcCAtegoriaDAO();
    	empDao = DAOFactory.getFactory().getEmpresaDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url=null;
		
		try {
			//nom="+nom+"&pre="+pre+"&des"+des+"&img"+img+"&emp"+emp+"&sel"+sel
			
			String nom = request.getParameter("nom");
			Float pre = Float.parseFloat(request.getParameter("pre"));
			String des = request.getParameter("des");
			String img = request.getParameter("img");
			
		
			System.out.println(request.getParameter("empl"));
			
			int emp =Integer.parseInt(request.getParameter("empl"));
			int sel = Integer.parseInt(request.getParameter("sel"));
			
			
			int prodM= proDao.buscarUltId();
			
			System.out.println(nom +"|"+pre +"|"+des+"|"+img+"|"+emp+"|"+sel+"|");
			
			
			Empresa empresa = empDao.read(emp);
			Categoria categoria = catDao.read(sel);
			
			Producto prod = new Producto(prodM, nom, pre, des, empresa, categoria, 'A');
			
			
			System.out.println(prod);
			
			proDao.create(prod);
			
			//;
			
			
			
			request.setAttribute("idEmp", emp);
			
			
			//System.out.println(idEmp);
			//request.setAttribute("idEmp", idEmp);
			
			url = "/HTMLs/Admin/TablonCrear.jsp";
			
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
