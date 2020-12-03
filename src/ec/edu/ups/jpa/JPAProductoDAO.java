package ec.edu.ups.jpa;


import java.util.Iterator;
import java.util.List;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EmpresaDAO;
import ec.edu.ups.dao.CAtegoriaDAO;
import ec.edu.ups.dao.ProductosDao;
import ec.edu.ups.entidades.Categoria;
import ec.edu.ups.entidades.Empresa;
import ec.edu.ups.entidades.Producto;


public class JPAProductoDAO extends JPAGenericDAO<Producto, Integer> implements ProductosDao{

	private EmpresaDAO empDAO;
	private CAtegoriaDAO catDAO;
	public JPAProductoDAO() {
		super(Producto.class);
		empDAO = DAOFactory.getFactory().getEmpresaDAO();
		catDAO = DAOFactory.getFactory().getcCAtegoriaDAO();
	}

	
	
	
	
	public List<Producto> findC(Integer id, Integer emp) {
		
		List<Producto> list = null;
		Categoria catE = catDAO.read(id);
		Empresa sta = empDAO.read(emp);
		
		String consulta = "Select p From Producto p Where p.categoria =:id And p.estado = 'A' and p.empresa =:emp";
		try {
			
			list = em.createQuery(consulta).setParameter("id", catE).setParameter("emp", sta).getResultList();
			
			for (Iterator<Producto> iterator = list.iterator(); iterator.hasNext();) {
				Producto producto = iterator.next();
				System.out.println(producto);
			}
			
			
		}catch(Exception e) {
			System.out.println(">>>WARNING (JPAProductoDAO:find): " + e.getMessage());
		}
		return list;
	
	}

	
	
	
	
	
	public List<Producto> findE(Integer id) {
		Empresa sta= null;
		List<Producto> list = null;
		char A = 'A';
		String consulta ="Select p From Producto p Where p.empresa =:id And p.estado =:stes ";
		
		 sta = empDAO.read(id);
		
		try {
			
			list = em.createQuery(consulta).setParameter("id", sta).setParameter("stes", A).getResultList();
			
			for (Iterator<Producto> iterator = list.iterator(); iterator.hasNext();) {
				Producto producto = iterator.next();
				System.out.println(producto);
			}

			
		}catch(Exception e) {

			System.out.println(">>>WARNING (JDBCProductoDAO:findE): " + e.getMessage());

		}
		return list;
	
	}

	
	public int buscarUltId() {
		
		String consulta ="Select MAX(p.id) from Producto p ";	
		int numero = 0 ;
		try {
			
			numero = (Integer) em.createQuery(consulta).getSingleResult();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Problema con buscarUltId");
			e.printStackTrace();
		}
				
		
		System.out.println("Numero ID : " + (numero +1));
		return numero + 1;
	
	}

	
	public List<Producto> findCnomb(int cat, int idEmp, String tex) {
		
		List<Producto> list = null;
		
		Categoria catE = catDAO.read(cat);
		Empresa sta = empDAO.read(idEmp);
		String consulta ="Select p From Producto p Where p.categoria =:cat And p.estado = 'A' and p.empresa =:idEmp and p.nombre LIKE :tex ";
		
		try {
			
			list = em.createQuery(consulta).setParameter("cat", catE).setParameter("idEmp", sta).setParameter("tex", "%"+tex+"%").getResultList();
			
			for (Iterator<Producto> iterator = list.iterator(); iterator.hasNext();) {
				Producto producto = iterator.next();
				System.out.println(producto);
			}
			
		}catch(Exception e) {

			System.out.println(">>>WARNING (JDBCPersonaDAO:findC): " + e.getMessage());

		}
		return list;
		
	}

	
	public Integer findID(String nombre) {

		Integer id=0;
		String consulta ="Select p.id From Producto p Where p.nombre =:nombre ";
		
		
		
		try {

			id = (Integer) em.createQuery(consulta).setParameter("nombre", nombre).getSingleResult();
			
		}catch(Exception e) {

			System.out.println(">>>WARNING (JDBCProductoDAO:findID): " + e.getMessage());

		}
		System.out.println("ID : " + (id));
		return id;
	}





	@Override
	public void deleteEstado(Producto ste) {
		//String consulta =(" UPDATE Producto p set p.estado =:stad WHERE p.id =:ste  ");
		em.getTransaction().begin();
		ste.setEstado('E');
		try {
			
			em.merge(ste);
		    em.getTransaction().commit();
			
			//em.createQuery(consulta).setParameter("stad", 'E').setParameter("ste", ste.getId());
			
		}catch(Exception e) {

			System.out.println("Error en deleteEstado: " + e);
		    if (em.getTransaction().isActive())
			em.getTransaction().rollback();

		}
	}

}
