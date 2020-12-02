package ec.edu.ups.jpa;
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
	private Root<PedidoCabecera> rootU;
	
	public JPAPedidoCabeceraDAO() {
		super(PedidoCabecera.class);
	}
	public List<PedidoCabecera> findU(int id){		
		root = cq.from(this.persistentClass);
		cq.select(root);		
		Predicate p1=cb.equal(root.get("usuario").get("id") ,id);
		cq.where(p1);
		Query query=em.createQuery(cq);
		List<PedidoCabecera> resultList = query.getResultList();
		return resultList;
	}
	public void modEst(char est, int id) {
		rootU=cu.from(this.persistentClass);
		cu.set(rootU.get("estado"), est);
		Predicate p1=cb.equal(rootU.get("id"),id);
		Predicate p2=cb.notEqual(rootU.get("estado"),'E');
		Predicate predicado=cb.conjunction(); 
		predicado=cb.and(p1,p2);
		cu.where(predicado);
		this.em.createQuery(cu).executeUpdate();
	}
	public int ultimoID(){		
		root=cu.from(this.persistentClass);
		cq.orderBy(cb.desc(root.get("id")));
		TypedQuery<PedidoCabecera> tq=em.createQuery(cq);
		tq.setMaxResults(1);
		return tq.getFirstResult();		
	}
	public List<PedidoCabecera> findPedidos(int idUsu) {		
		root=cu.from(this.persistentClass);
		Predicate p1=cb.equal(rootU.get("usuario").get("id"),idUsu);
		cq.where(p1);
		Query query=em.createQuery(cq);
		List<PedidoCabecera> resultList = query.getResultList();
		return resultList;
	}
	
}
