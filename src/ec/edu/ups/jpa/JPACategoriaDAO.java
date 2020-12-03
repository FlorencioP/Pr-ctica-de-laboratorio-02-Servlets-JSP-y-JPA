package ec.edu.ups.jpa;


import java.util.Iterator;
import java.util.List;

import ec.edu.ups.dao.CAtegoriaDAO;
import ec.edu.ups.entidades.Categoria;

public class JPACategoriaDAO extends JPAGenericDAO<Categoria, Integer> implements CAtegoriaDAO{
	
	public JPACategoriaDAO() {
		super(Categoria.class);
	}

	@Override
	public List<String> catEmp(int idEmp) {
		
		List<String> list=null;
		String consulta =("SELECT DISTINCT cat.cat_nombre FROM Producto prod, Categoria cat WHERE prod.Empresas_emp_id =:idEmp ");
		
		
		
		try {

			list = em.createQuery(consulta).setParameter("idEmp", idEmp).getResultList();
			
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
