package ec.edu.ups.jpa;


import java.util.Iterator;
import java.util.List;

import ec.edu.ups.dao.ProductosDao;
import ec.edu.ups.entidades.Empresa;
import ec.edu.ups.entidades.Producto;


public class JPAProductoDAO extends JPAGenericDAO<Producto, Integer> implements ProductosDao{

	public JPAProductoDAO() {
		super(Producto.class);
	}

	
	
	
	
	public List<Producto> findC(Integer id, Integer emp) {
		
		List<Producto> list = null;
		String consulta = "Select p From Producto p where p.estado = 'A'";
		try {
			
			list = em.createQuery(consulta).getResultList();
			
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
		
		List<Producto> list = null;
		char A = 'A';
		String consulta ="Select p From Producto p Where p.empresa =:id And p.estado =:stes ";
		
		Empresa sta = new Empresa(1,"wqe");
		
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
		
		String consulta ="Select MAX(p.id) from Productos p ;";	
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
		String consulta ="Select p From Producto p Where p.Categoria_id =:cat And p.estado = 'A' and p.Empresa_id =:idEmp and p.nombre rlike :tex";
		
		try {
			
			list = em.createQuery(consulta).setParameter("cat", cat).setParameter("idEmp", idEmp).setParameter("tex", tex).getResultList();
			
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
		String consulta =(" UPDATE Producto p set p.estado = 'E' WHERE p.id =:ste  ");
		
		try {

			em.createQuery(consulta).setParameter("ste", ste.getId()).getSingleResult();
			
		}catch(Exception e) {

			System.out.println(">>>WARNING (JDBCProductoDAO:findID): " + e.getMessage());

		}
	}

}
