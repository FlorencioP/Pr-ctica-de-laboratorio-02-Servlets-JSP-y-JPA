package ec.edu.ups.dao;

import java.util.List;

import ec.edu.ups.entidades.Usuario;

public interface UsuariosDAO extends GenericcDAO<Usuario, Integer>{
		public abstract Usuario validarU(String correo, String password);
		public abstract List<Usuario> findU(int id);
}
