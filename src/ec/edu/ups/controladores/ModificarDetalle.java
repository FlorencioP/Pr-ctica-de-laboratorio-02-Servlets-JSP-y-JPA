package ec.edu.ups.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.PedidoCabeceraDAO;
import ec.edu.ups.dao.PedidoDetalleDAO;
import ec.edu.ups.dao.ProductosDao;
import ec.edu.ups.entidades.PedidoCabecera;
import ec.edu.ups.entidades.PedidoDetalle;
import ec.edu.ups.entidades.Producto;


/**
 * Servlet implementation class ModificarDetalle
 */
@WebServlet("/ModificarDetalle")
public class ModificarDetalle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private PedidoDetalleDAO pedDetDAO;
    private PedidoCabeceraDAO pedCabDAO;
    private ProductosDao proDAO;
    
    public ModificarDetalle() {
        pedDetDAO=DAOFactory.getFactory().getpeDetalleDAO();
        pedCabDAO = DAOFactory.getFactory().getpeCabeceraDAO();
        proDAO = DAOFactory.getFactory().getProductosDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="";
		try {
			int idCab= Integer.parseInt(request.getParameter("idCab"));
			int idDet= Integer.parseInt(request.getParameter("idDet"));
			int prodID= Integer.parseInt(request.getParameter("prodID"));
			int cantidad= Integer.parseInt(request.getParameter("cantidad"));
			
			
			
			PedidoCabecera pedidoCabecera = pedCabDAO.read(idCab);
			Producto producto = proDAO.read(prodID);
			
			PedidoDetalle pedDet = new PedidoDetalle(idDet, cantidad, pedidoCabecera, producto);
			
			
			pedDetDAO.update(pedDet);
			
			request.setAttribute("idCab", idCab);
			url="/ActualizarPedidosDetalle";
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
