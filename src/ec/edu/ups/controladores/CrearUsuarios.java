package ec.edu.ups.controladores;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.UsuariosDAO;
import ec.edu.ups.entidades.Empresa;
import ec.edu.ups.entidades.Usuario;

public class CrearUsuarios {
	public static void main(String[]args) {
		UsuariosDAO usuDao=DAOFactory.getFactory().getUsuariosDAO();
		Empresa emp1 = new Empresa(1, "Viñedo del Amanecer");
		Empresa emp2 = new Empresa(2, "Aeropostale");
		Empresa emp3 = new Empresa(3, "Supermercado 9cito");
    	
		//Usuario usu=new Usuario(0,"Florencio","Peralta","sebasale@hotmail.com","floris",'U',emp1);
    	//Usuario usu2=new Usuario(0,"Carlos","Peña","Carly@gmail.com","root",'A',emp1);
    	//Usuario usu3=new Usuario(0,"Esteban","Bermeno","Example@here.com","steve",'U',emp2);
    	Usuario usu4=new Usuario(0,"Alfred","Gerardo","Alfred@estigma.com","root",'A',emp2);
    	//Usuario usu5=new Usuario(0,"Manuel","Kiosko","man@gmail.com","mannn",'U',emp3);
    	//Usuario usu6=new Usuario(0,"Florenc","Peral","roo@gmail.com","root",'A',emp3);
    	
    	//usuDao.create(usu);
    	//usuDao.create(usu2);
    	//usuDao.create(usu3);
    	usuDao.create(usu4);
    	//usuDao.create(usu5);
    	//usuDao.create(usu6);
    }
}
