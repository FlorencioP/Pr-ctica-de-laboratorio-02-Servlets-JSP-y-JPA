package ec.edu.ups.jpa;

import ec.edu.ups.dao.PedidoDetalleDAO;
import ec.edu.ups.entidades.PedidoDetalle;

public class JPAPedidoDetalleDAO extends JPAGenericDAO<PedidoDetalle, Integer> implements PedidoDetalleDAO{
	public JPAPedidoDetalleDAO() {
		super(PedidoDetalle.class);
	}
}
