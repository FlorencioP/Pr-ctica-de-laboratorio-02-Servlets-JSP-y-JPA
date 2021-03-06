package ec.edu.ups.jpa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.PedidoCabeceraDAO;
import ec.edu.ups.dao.PedidoDetalleDAO;
import ec.edu.ups.entidades.PedidoCabecera;
import ec.edu.ups.entidades.PedidoDetalle;

public class JPAPedidoDetalleDAO extends JPAGenericDAO<PedidoDetalle, Integer> implements PedidoDetalleDAO{
	private PedidoCabeceraDAO pedcabDAO;
	
	public JPAPedidoDetalleDAO() {
		super(PedidoDetalle.class);
		pedcabDAO = DAOFactory.getFactory().getpeCabeceraDAO();
	}

	
	public List<PedidoDetalle> listPed(int id) {
		
		List<PedidoDetalle> list= null;
		
		PedidoCabecera sta = pedcabDAO.read(id); 
		
		String consulta =("SELECT p From PedidoDetalle p Where p.pedidoCabecera =:id ");
		try {

			list = em.createQuery(consulta).setParameter("id", sta).getResultList();
			
			for (Iterator<PedidoDetalle> iterator = list.iterator(); iterator.hasNext();) {
				PedidoDetalle producto = (PedidoDetalle) iterator.next();
				System.out.println(producto);
			}
			
		}catch(Exception e) {
			System.out.println(">>>WARNING (JPAedidoDetalleDAO:listPed): " + e.getMessage());
		}
		return list;
	
	}

	
	public int ultimoID() {
		
		int id=0; 
		String consulta =("Select MAX(p.id) from PedidoDetalle p");
		try{

			id = (Integer) em.createQuery(consulta).getSingleResult();
			
		}catch (Exception e) {
			System.out.println(">>>WARNING (JPAPedidoDetalleDAO:ultimoID): " + e.getMessage());
		}
		System.out.println("numero: "+ id);
		return id;
	
	}
}
