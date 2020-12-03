package ec.edu.ups.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductosDao;
import ec.edu.ups.modelo.Producto;

/**
 * Servlet implementation class EditarProds
 */
@WebServlet("/GuardarEditarProds")
public class GuardarEditarProds extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductosDao proDao;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuardarEditarProds() {
    	proDao= DAOFactory.getFactory().getProductosDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url=null;
		//id="+id+"&nom="+nom+"&pre="+pre+"&des="+des+"&img="+img,
		try {
			int idEmp=Integer.parseInt(request.getParameter("empre"));
			int id=Integer.parseInt(request.getParameter("id"));
			String nom = request.getParameter("nom");
			Float pre = Float.parseFloat(request.getParameter("pre"));
			String des = request.getParameter("des");
			String img = request.getParameter("img");
			int sel=Integer.parseInt(request.getParameter("sel"));
			
			
			
			Producto proD = new Producto(id, nom, pre, des, img, idEmp, sel,'A');
			
			System.out.println(proD);
			
			proDao.update(proD);
			
			List<Producto> list=proDao.findE(idEmp);
			
			request.setAttribute("listaProd", list);

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
