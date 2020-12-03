package ec.edu.ups.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.PedidoDetalleDAO;
import ec.edu.ups.dao.ProductosDao;
import ec.edu.ups.modelo.PedidoDetalle;
import ec.edu.ups.modelo.Producto;

/**
 * Servlet implementation class VerPedidosDetalle
 */
@WebServlet("/VerPedidosDetalle")
public class VerPedidosDetalle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PedidoDetalleDAO pedidoDetDAO;
	private ProductosDao productoDao;
	
    public VerPedidosDetalle() {
    	pedidoDetDAO=DAOFactory.getFactory().getpeDetalleDAO();
    	productoDao=DAOFactory.getFactory().getProductosDao();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="";
		try {
			int id= Integer.parseInt(request.getParameter("cabeceraID"));
			
			
			List<PedidoDetalle> list=pedidoDetDAO.listPed(id);
			
			
			List<Producto> listPro = new ArrayList<Producto>();
			
			
			
			for(PedidoDetalle pD:list) {
				System.out.println("pedido detalle: "+pD.getId());
				
				Producto ste = productoDao.read(pD.getFKProdID());
				
				if (ste != null) {
					listPro.add(ste);
				} 

			}
			
			System.out.println(listPro);
			
			
			request.setAttribute("listDetalles", list);
			request.setAttribute("listProducto", listPro);
			
			url="/HTMLs/User/MostrarDetalles.jsp";
		}catch (Exception e) {
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
