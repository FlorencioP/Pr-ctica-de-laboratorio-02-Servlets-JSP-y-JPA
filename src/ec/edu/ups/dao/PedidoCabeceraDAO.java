package ec.edu.ups.dao;

import java.util.List;

import ec.edu.ups.entidades.PedidoCabecera;

public interface PedidoCabeceraDAO extends GenericcDAO<PedidoCabecera, Integer> {
	public abstract void modEst(char est, int id);
	public abstract List<PedidoCabecera> findPedidos(int idUsu);
	public abstract int ultimoID();
	public abstract List<PedidoCabecera> findU(int id);
}
