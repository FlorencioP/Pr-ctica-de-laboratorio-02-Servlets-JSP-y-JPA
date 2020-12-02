package ec.edu.ups.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EmpresaDAO;
import ec.edu.ups.entidades.Empresa;

/**
 * Servlet implementation class CrearEmpresa
 */
@WebServlet("/CrearEmpresa")
public class CrearEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private EmpresaDAO empDAO;
    public CrearEmpresa() {
        empDAO= DAOFactory.getFactory().getEmpresaDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Empresa emp1 = new Empresa(0, "Viñedo del Amanecer");
		Empresa emp2 = new Empresa(0, "Aeropostale");
		Empresa emp3 = new Empresa(0, "Supermercado 9cito");
		
		empDAO.create(emp1);
		empDAO.create(emp2);
		empDAO.create(emp3);
	}

}
