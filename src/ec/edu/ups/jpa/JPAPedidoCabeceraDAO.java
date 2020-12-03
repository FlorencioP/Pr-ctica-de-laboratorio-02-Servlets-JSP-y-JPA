package ec.edu.ups.jpa;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import ec.edu.ups.dao.PedidoCabeceraDAO;
import ec.edu.ups.entidades.PedidoCabecera;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
public class JPAPedidoCabeceraDAO extends JPAGenericDAO<PedidoCabecera, Integer> implements PedidoCabeceraDAO{
	private CriteriaBuilder cb = this.em.getCriteriaBuilder();
	private CriteriaQuery<PedidoCabecera> cq= cb.createQuery(PedidoCabecera.class);
	private CriteriaUpdate<PedidoCabecera>cu= cb.createCriteriaUpdate(PedidoCabecera.class);
	private Root<PedidoCabecera> root;	
	
	public JPAPedidoCabeceraDAO() {
		super(PedidoCabecera.class);
	}
	public List<PedidoCabecera> findU(int id){		
		List<PedidoCabecera> resultList= new ArrayList<PedidoCabecera>();
		root = cq.from(this.persistentClass);
		cq.select(root);		
		Predicate p1=cb.equal(root.get("usuario").get("id") ,id);
		cq.where(p1);
		Query query=em.createQuery(cq);		
		try {
				resultList = (List<PedidoCabecera>)query.getResultList();				
		}catch (Exception e) {
			System.out.println(">>>WARNING (JPAPedidoCabeceraDAO:findU): " + e.getMessage());
		}
		return resultList;
	}
	public void modEst(char est, int id) {
		root=cu.from(this.persistentClass);
		cu.set(root.get("estado"), est);
		Predicate p1=cb.equal(root.get("id"),id);
		Predicate p2=cb.notEqual(root.get("estado"),'E');
		Predicate predicado=cb.conjunction(); 
		predicado=cb.and(p1,p2);
		cu.where(predicado);
		try {
			this.em.createQuery(cu).executeUpdate();
		}catch (Exception e) {
			System.out.println(">>>WARNING (JPAPedidoCabeceraDAO:modEst): " + e.getMessage());
		}
		
	}
	public int ultimoID(){		
		int respuesta=0;
		root=cu.from(this.persistentClass);
		cq.orderBy(cb.desc(root.get("id")));
		TypedQuery<PedidoCabecera> tq=em.createQuery(cq);
		tq.setMaxResults(1);
		try{
			respuesta=tq.getFirstResult();			
		}catch (Exception e) {
			System.out.println(">>>WARNING (JPAPedidoCabeceraDAO:ultimoID): " + e.getMessage());
		}
		return respuesta;		
	}
	public List<PedidoCabecera> findPedidos(int idUsu) {		
		List<PedidoCabecera> resultList = new ArrayList<PedidoCabecera>();
		root=cu.from(this.persistentClass);
		Predicate p1=cb.equal(root.get("usuario").get("id"),idUsu);
		cq.where(p1);
		Query query=em.createQuery(cq);
		try {
			resultList = (List<PedidoCabecera>)query.getResultList();
		}catch (Exception e) {
			System.out.println(">>>WARNING (JPAPedidoCabeceraDAO:findPedidos): " + e.getMessage());
		}		
		return resultList;
	}
	
}
