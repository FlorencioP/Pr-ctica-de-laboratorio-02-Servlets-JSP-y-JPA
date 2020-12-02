package ec.edu.ups.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Producto
 *
 */
@Entity

public class Producto implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String nombre;
	private float precio;
	private String descripcion;
	@ManyToOne
	private Empresa empresa;
	@ManyToOne
	private Categoria categoria;
	private char estado;
	
	public Producto() {
		super();
	}
	
	public Producto(int id, String nombre, float precio, String descripcion,Empresa empresa,Categoria categoria,char estado) {
		this.setId(id);
		this.setNombre(nombre);
		this.setPrecio(precio);
		this.setDescripcion(descripcion);
		this.setEmpresa(empresa);
		this.setCategoria(categoria);
		this.setEstado(estado);
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

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}
	
	
   
}
