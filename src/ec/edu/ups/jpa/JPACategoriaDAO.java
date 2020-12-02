package ec.edu.ups.jpa;

import java.util.List;

import ec.edu.ups.dao.CAtegoriaDAO;
import ec.edu.ups.entidades.Categoria;

public class JPACategoriaDAO extends JPAGenericDAO<Categoria, Integer> implements CAtegoriaDAO{
	
	public JPACategoriaDAO() {
		super(Categoria.class);
	}

	
}
