package ec.edu.ups.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: PedidoDetalle
 *
 */
@Entity

public class PedidoDetalle implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int cantidad;
	@ManyToOne
	@JoinColumn
	private PedidoCabecera pedidoCabecera;
	@OneToOne
	@JoinColumn
	private Producto producto;
	
	public PedidoDetalle() {
		super();
	}
	
	public PedidoDetalle(int id, PedidoCabecera pedidoCabecera, Producto producto) {
		this.setId(id);
		this.setPedidoCabecera(pedidoCabecera);;
		this.setProducto(producto);;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public PedidoCabecera getPedidoCabecera() {
		return pedidoCabecera;
	}

	public void setPedidoCabecera(PedidoCabecera pedidoCabecera) {
		this.pedidoCabecera = pedidoCabecera;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
}
