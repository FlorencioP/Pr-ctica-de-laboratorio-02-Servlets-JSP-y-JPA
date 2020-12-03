package ec.edu.ups.dao;

import java.util.List;

import ec.edu.ups.entidades.PedidoDetalle;

public interface PedidoDetalleDAO extends GenericcDAO<PedidoDetalle, Integer>{
	public abstract List<PedidoDetalle> listPed(int id);
	public abstract int ultimoID();
}
