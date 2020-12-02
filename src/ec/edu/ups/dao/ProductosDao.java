package ec.edu.ups.dao;

import java.util.List;

import ec.edu.ups.entidades.Producto;

public interface ProductosDao extends GenericcDAO<Producto, Integer> {
	public abstract List<Producto> findC(Integer id, Integer emp);
	public abstract List<Producto> findE(Integer id);
	public abstract int buscarUltId();
	//public abstract Producto buscarPRO(int id);
	public abstract List<Producto> findCnomb(int cat, int idEmp, String tex);
	public abstract Integer findID(String nombre);
}
