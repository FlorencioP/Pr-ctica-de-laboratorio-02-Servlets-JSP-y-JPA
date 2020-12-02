package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity

public class Usuario implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String nombre;
	private String apellido;
	private String correo;
	private String password;
	private char rol;
	@ManyToOne
	@JoinColumn
	private Empresa empresa;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	private List<PedidoCabecera> pedidosCabecera = new ArrayList<PedidoCabecera>();
	
	public Usuario (int id, String nombre, String apellido, String correo, String password, char rol, Empresa empresa) {
		this.setId(id);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setCorreo(correo);
		this.setPassword(password);
		this.setRol(rol);
		this.setEmpresa(empresa);
	}
	
	
	public Usuario() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public char getRol() {
		return rol;
	}


	public void setRol(char rol) {
		this.rol = rol;
	}


	public Empresa getEmpresa() {
		return empresa;
	}


	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


	public List<PedidoCabecera> getPedidosCabecera() {
		return pedidosCabecera;
	}


	public void setPedidosCabecera(List<PedidoCabecera> pedidosCabecera) {
		this.pedidosCabecera = pedidosCabecera;
	}
	
	public void addPedidosCabecera(PedidoCabecera pedidosCabecera) {
		this.pedidosCabecera.add(pedidosCabecera);
	}
	
	
   
}
