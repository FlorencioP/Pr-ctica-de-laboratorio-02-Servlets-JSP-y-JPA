package ec.edu.ups.jpa;

import ec.edu.ups.dao.ProductosDao;
import ec.edu.ups.entidades.Producto;
import ec.edu.ups.entidades.Usuario;

public class JPAProductoDAO extends JPAGenericDAO<Producto, Integer> implements ProductosDao{

	public JPAProductoDAO() {
		super(Producto.class);
	}

}
