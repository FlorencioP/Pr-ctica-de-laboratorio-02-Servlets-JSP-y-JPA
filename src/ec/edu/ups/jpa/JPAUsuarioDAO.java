package ec.edu.ups.jpa;

import java.util.List;

import ec.edu.ups.dao.UsuariosDAO;
import ec.edu.ups.entidades.Usuario;

public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, Integer> implements UsuariosDAO{
	public JPAUsuarioDAO() {
		super(Usuario.class);
	}
}
