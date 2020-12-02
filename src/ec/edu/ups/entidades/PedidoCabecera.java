package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: PedidoCabecera
 *
 */
@Entity

public class PedidoCabecera implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	@ManyToOne
	@JoinColumn
	private Usuario usuario;
	private char estado;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidoCabecera")
	private List<PedidoDetalle> pedidosDetalle = new ArrayList<PedidoDetalle>();
	
	public PedidoCabecera() {
		super();
	}
	
	public PedidoCabecera(int id, Usuario usuario, char estado ) {
		this.setId(id);
		this.setUsuario(usuario);
		this.setEstado(estado);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}

	public List<PedidoDetalle> getPedidosDetalle() {
		return pedidosDetalle;
	}

	public void setPedidosDetalle(List<PedidoDetalle> pedidosDetalle) {
		this.pedidosDetalle = pedidosDetalle;
	}
	
	public void addPedidosDetalle(PedidoDetalle pedidosDetalle) {
		this.pedidosDetalle.add(pedidosDetalle);
	}
   
}
