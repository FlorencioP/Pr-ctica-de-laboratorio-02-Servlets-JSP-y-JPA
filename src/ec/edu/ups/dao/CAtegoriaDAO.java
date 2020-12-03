package ec.edu.ups.dao;

import java.util.List;

import ec.edu.ups.entidades.Categoria;

public interface CAtegoriaDAO extends GenericcDAO<Categoria, Integer>  {
	public abstract List<String> catEmp(int idEmp);
}
