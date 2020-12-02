package ec.edu.ups.dao;

import ec.edu.ups.jpa.JPADAOFactory;

public abstract class DAOFactory {
	
	protected static DAOFactory factory = new JPADAOFactory();

	public static DAOFactory getFactory() {
		return factory;
	}
	
	public abstract ProductosDao getProductosDao();
	
	public abstract UsuariosDAO getUsuariosDAO();
	
	public abstract CAtegoriaDAO getcCAtegoriaDAO();
	
	public abstract PedidoCabeceraDAO getpeCabeceraDAO();
	
	public abstract PedidoDetalleDAO getpeDetalleDAO();
	
	public abstract EmpresaDAO getEmpresaDAO();
	
}
