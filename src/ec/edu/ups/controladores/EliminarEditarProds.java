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
import ec.edu.ups.entidades.Producto;

/**
 * Servlet implementation class EditarProds
 */
@WebServlet("/EliminarEditarProds")
public class EliminarEditarProds extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductosDao proDao;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarEditarProds() {
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

			
			
			//Producto ste = new Producto(id, "",0 , "", "", 0, 0,'g');Linea a revisar
			
			proDao.delete(ste);;
			
			
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
