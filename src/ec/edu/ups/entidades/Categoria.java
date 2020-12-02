package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Categoria
 *
 */
@Entity

public class Categoria implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String nombre;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
	private List<Producto> productos = new ArrayList<Producto>();
	
	public Categoria(int id, String nombre) {
		this.id=id;
		this.nombre=nombre;
	}
	
	public Categoria() {
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

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + "]";
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void addProductos(Producto productos) {
		this.productos.add(productos);
	}
	
	
   
}
