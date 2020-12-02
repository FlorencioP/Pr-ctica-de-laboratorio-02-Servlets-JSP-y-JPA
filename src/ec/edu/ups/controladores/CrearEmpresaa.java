package ec.edu.ups.controladores;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EmpresaDAO;
import ec.edu.ups.entidades.Empresa;

public class CrearEmpresaa {
	
    public static void main(String[]args) {
    	EmpresaDAO empDAO;
    	empDAO= DAOFactory.getFactory().getEmpresaDAO();
        Empresa emp1 = new Empresa(0, "Viñedo del Amanecer");
		Empresa emp2 = new Empresa(0, "Aeropostale");
		Empresa emp3 = new Empresa(0, "Supermercado 9cito");
		
		empDAO.create(emp1);
		empDAO.create(emp2);
		empDAO.create(emp3);
    }
    
}
