package ec.edu.ups.jpa;

import ec.edu.ups.dao.PedidoCabeceraDAO;
import ec.edu.ups.entidades.PedidoCabecera;

public class JPAPedidoCabeceraDAO extends JPAGenericDAO<PedidoCabecera, Integer> implements PedidoCabeceraDAO{
	public JPAPedidoCabeceraDAO() {
		super(PedidoCabecera.class);
	}
}
