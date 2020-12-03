package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Empresa
 *
 */
@Entity

public class Empresa implements Serializable {

	
	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nombre=" + nombre + ", usuarios=" + usuarios + ", productos=" + productos + "]";
	}


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
	private List<Usuario> usuarios=new ArrayList<Usuario>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
	private List<Producto> productos=new ArrayList<Producto>();
	
	
	public Empresa() {
		super();
	}
	
	public Empresa (int id, String nombre) {
		this.setId(id);
		this.setNombre(nombre);
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

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void addUsuarios(Usuario usuarios) {
		this.usuarios.add(usuarios);
	}
	
	public void addProductos(Producto producto) {
		this.productos.add(producto);
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
   
}
