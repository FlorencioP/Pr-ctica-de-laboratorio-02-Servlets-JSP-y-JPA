package ec.edu.ups.jpa;

import ec.edu.ups.dao.CAtegoriaDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EmpresaDAO;
import ec.edu.ups.dao.PedidoCabeceraDAO;
import ec.edu.ups.dao.PedidoDetalleDAO;
import ec.edu.ups.dao.ProductosDao;
import ec.edu.ups.dao.UsuariosDAO;

public class JPADAOFactory extends DAOFactory{

	@Override
	public ProductosDao getProductosDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuariosDAO getUsuariosDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CAtegoriaDAO getcCAtegoriaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PedidoCabeceraDAO getpeCabeceraDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PedidoDetalleDAO getpeDetalleDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmpresaDAO getEmpresaDAO() {
		return new JPAEmpresaDAO();
	}

}
