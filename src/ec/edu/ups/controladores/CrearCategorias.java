package ec.edu.ups.controladores;

import ec.edu.ups.dao.CAtegoriaDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.entidades.Categoria;

public class CrearCategorias {
	public static void main(String[] args) {
		CAtegoriaDAO catDAO=DAOFactory.getFactory().getcCAtegoriaDAO();
		
		Categoria cat1=new Categoria(0,"Pan");
		Categoria cat2=new Categoria(0,"Vino");
		Categoria cat3=new Categoria(0,"Quesos");
		Categoria cat4=new Categoria(0,"Cereal");
		Categoria cat5=new Categoria(0,"Camisetas");
		Categoria cat6=new Categoria(0,"Pantalones");
		Categoria cat7=new Categoria(0,"Casacas");
		Categoria cat8=new Categoria(0,"Frutas");
		
		catDAO.create(cat1);
		catDAO.create(cat2);
		catDAO.create(cat3);
		catDAO.create(cat4);
		catDAO.create(cat5);
		catDAO.create(cat6);
		catDAO.create(cat7);
		catDAO.create(cat8);
	}
}
