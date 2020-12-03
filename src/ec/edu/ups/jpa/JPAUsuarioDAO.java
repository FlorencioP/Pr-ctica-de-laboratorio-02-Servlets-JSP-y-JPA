package ec.edu.ups.jpa;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.UsuariosDAO;
import ec.edu.ups.entidades.Usuario;

public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, Integer> implements UsuariosDAO{
	public JPAUsuarioDAO() {
		super(Usuario.class);
	}
	
	
	
	public Usuario validarU(String correo, String password) {
		
		Usuario usuario=null;
		
		String consulta="SELECT u FROM Usuario u WHERE u.correo= :correo AND u.password= :password ";
		
		
		try {
			Usuario respuesta=(Usuario) em.createQuery(consulta).setParameter("correo", correo).setParameter("password", password).getSingleResult();	
			
			
			
			if(respuesta != null) {
				System.out.println("nombre: "+respuesta.getNombre());
				usuario =  new Usuario(respuesta.getId(), respuesta.getNombre(), respuesta.getApellido(), 
						respuesta.getCorreo(), respuesta.getPassword(), respuesta.getRol(), 
						respuesta.getEmpresa());
				}
			
			
			
			
			
			
		}catch(Exception e) {
			System.out.println(">>>WARNING (JPAUsuarioDAO:validarU): " + e.getMessage());
		}
		return usuario;
	}
	
	
	
	
	
	
	
	
	
	
	public List<Usuario> findU(int id) {
		List<Usuario> respuesta = new ArrayList<Usuario>();
		String consulta =("SELECT u FROM Usuario u WHERE u.Empresa_id =:id AND u.rol = 'U'");
		try {
				respuesta=(List<Usuario>)em.createQuery(consulta).setParameter("id", id).getResultList();				
		}catch(Exception e) {
			System.out.println(">>>WARNING (JDBCUsuarioDAO:findU): " + e.getMessage());
		}
		return respuesta;
	}
}
