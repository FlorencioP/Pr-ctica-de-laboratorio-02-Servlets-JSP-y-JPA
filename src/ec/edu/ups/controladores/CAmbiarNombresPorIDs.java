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
import ec.edu.ups.dao.PedidoCabeceraDAO;
import ec.edu.ups.dao.PedidoDetalleDAO;
import ec.edu.ups.dao.ProductosDao;
import ec.edu.ups.dao.UsuariosDAO;
import ec.edu.ups.entidades.PedidoCabecera;
import ec.edu.ups.entidades.PedidoDetalle;
import ec.edu.ups.entidades.Usuario;
import ec.edu.ups.entidades.Producto;

/**
 * Servlet implementation class CAmbiarNombresPorIDs
 */
@WebServlet("/CAmbiarNombresPorIDs")
public class CAmbiarNombresPorIDs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ProductosDao prodDAO;
	private PedidoDetalleDAO pedDetDAO;
	private PedidoCabeceraDAO pedCabDAO;
	private UsuariosDAO usuDAO;
	
    public CAmbiarNombresPorIDs() {
    	prodDAO= DAOFactory.getFactory().getProductosDao();
    	pedDetDAO= DAOFactory.getFactory().getpeDetalleDAO();
    	pedCabDAO= DAOFactory.getFactory().getpeCabeceraDAO();
    	usuDAO = DAOFactory.getFactory().getUsuariosDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		try{
			String list=request.getParameter("lisPedido");
			int usuID=Integer.parseInt(request.getParameter("usuID"));
			int fkEmp=Integer.parseInt(request.getParameter("fkEmp"));
			int idCab=pedCabDAO.ultimoID()+1;
			
			Usuario usu = usuDAO.read(usuID);
			
			PedidoCabecera pedCab=new PedidoCabecera(idCab, usu, 'T');
			
		
			pedCabDAO.create(pedCab);
			
			
			int idCab2=pedCabDAO.ultimoID();
			System.out.println("usuID: "+usuID);
			System.out.println("fkEmp: "+fkEmp);
			String[] parts = list.split(";");
			List<Integer> ejem= new ArrayList<Integer>();
			List<Integer> ejem2= new ArrayList<Integer>();
			for(int i=1;i<parts.length;i++) {
				String aux=parts[i];
				String[] parts2 = aux.split(",");
				Integer idProd=prodDAO.findID(parts2[0]);
				ejem.add(idProd);
				ejem2.add(Integer.parseInt(parts2[1]));
			}
			for(int i=0;i<ejem.size();i++) {
				int idDet=pedDetDAO.ultimoID()+1;
				
				
				Producto producto = prodDAO.read(ejem.get(i));
				
				
				PedidoDetalle pedDet  = new PedidoDetalle(idDet, ejem2.get(i), pedCab, producto);
				
				System.out.println(pedDet);
				
				pedDetDAO.create(pedDet);
			}
			url="/HTMLs/User/MensajeExito.jsp";
		}catch (Exception e) {
			System.out.println("Error: " +e);
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
