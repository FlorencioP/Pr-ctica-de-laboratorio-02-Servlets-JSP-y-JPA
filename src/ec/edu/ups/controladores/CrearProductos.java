package ec.edu.ups.controladores;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductosDao;
import ec.edu.ups.entidades.Categoria;
import ec.edu.ups.entidades.Empresa;
import ec.edu.ups.entidades.Producto;

public class CrearProductos {
	
    public static void main(String[]args) {
    	ProductosDao proDAO;
    	proDAO= DAOFactory.getFactory().getProductosDao();
        
        Empresa emp1 = new Empresa(1, "Viñedo del Amanecer");
		Empresa emp2 = new Empresa(2, "Aeropostale");
		Empresa emp3 = new Empresa(3, "Supermercado 9cito");
    	
		Categoria cat1=new Categoria(1,"Pan");
		Categoria cat2=new Categoria(2,"Vino");
		Categoria cat3=new Categoria(3,"Quesos");
		Categoria cat4=new Categoria(4,"Cereal");
		Categoria cat5=new Categoria(5,"Camisetas");
		Categoria cat6=new Categoria(6,"Pantalones");
		Categoria cat7=new Categoria(7,"Casacas");
		Categoria cat8=new Categoria(8,"Frutas");
    	
		
    	//Producto pro1 = new Producto(1, "Rosca", (float)0.5 , "De chocolate", emp3, cat1, 'A');
    	//Producto pro2 = new Producto(2, "Vino de Diente de leon", (float)40, "Vino Especial de Monstald", emp1, cat2, 'A');
    	//Producto pro3 = new Producto(3, "Pan para vino", (float)0.7, "De Trigo", emp1, cat1, 'A');
    	//Producto pro4 = new Producto(4, "Vino B", (float)1, "Vino Barato", emp1, cat2, 'A');
    	//Producto pro5 = new Producto(5, "Vino C", (float)10000, "Vino Caro", emp1, cat2, 'A');
    	//Producto pro6 = new Producto(6, "Pan Bonito", (float)2, "Es un pan bonito", emp1, cat1, 'A');
    	//Producto pro7 = new Producto(7, "PAbloChingao", (float)10, "Depende", emp1, cat3, 'A');
    	//Producto pro8 = new Producto(8, "Ben 10", (float)10, "Original", emp2, cat5, 'A');
    	//Producto pro9 = new Producto(9, "pantalon", (float)10, "Original", emp2, cat6, 'A');
    	//Producto pro10 = new Producto(10,"Chompa", (float)10, "Original", emp2, cat7, 'A');
    	//Producto pro11 = new Producto(11,"Naranja", (float)1, "Original", emp3, cat8, 'A');
    	//Producto pro12 = new Producto(12,"Zucaritas", (float)1, "Original", emp3, cat4, 'A');
    	//Producto pro13 = new Producto(13,"PAN MAGICO", (float)1, "Original", emp3, cat1, 'A');
    	//Producto pro14 = new Producto(14,"Queos mistico", (float)11, "Queso que vuela", emp1, cat3, 'A');
    	//Producto pro15 = new Producto(15,"Misterio", (float)123, "33321", emp2, cat1, 'A');
    	
    	//proDAO.create(pro1);
    	//proDAO.create(pro2);
    	//proDAO.create(pro3);
    	//proDAO.create(pro4);
    	//proDAO.create(pro5);
    	//proDAO.create(pro6);
    	//proDAO.create(pro7);
    	//proDAO.create(pro8);
    	//proDAO.create(pro9);
    	//proDAO.create(pro10);
    	//proDAO.create(pro11);
    	//proDAO.create(pro12);
    	//proDAO.create(pro13);
    	//proDAO.create(pro14);
    	//proDAO.create(pro15);

    	
    	
    }
    
}

