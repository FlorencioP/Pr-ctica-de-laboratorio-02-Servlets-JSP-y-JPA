package ec.edu.ups.jpa;


import java.util.Iterator;
import java.util.List;

import ec.edu.ups.dao.CAtegoriaDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EmpresaDAO;
import ec.edu.ups.entidades.Categoria;
import ec.edu.ups.entidades.Empresa;

public class JPACategoriaDAO extends JPAGenericDAO<Categoria, Integer> implements CAtegoriaDAO{
	private EmpresaDAO empDAO;
	public JPACategoriaDAO() {
		super(Categoria.class);
		empDAO = DAOFactory.getFactory().getEmpresaDAO();
	}

	@Override
	public List<String> catEmp(int idEmp) {
		
		List<String> list=null;
		String consulta =("SELECT DISTINCT cat.nombre FROM Producto prod, Categoria cat WHERE prod.empresa =:idEmp ");
		
		Empresa sta = empDAO.read(idEmp);
		
		try {

			list = em.createQuery(consulta).setParameter("idEmp", sta).getResultList();
			
			for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
				String producto = (String) iterator.next();
				System.out.println(producto);
			}
		
		
		
		}catch(Exception e) {
			System.out.println(">>>WARNING (JDBCCategoriasDAO:catEmp): " + e.getMessage());
		}
		return list;
		
	}
	
}
