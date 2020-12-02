<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="ec.edu.ups.modelo.Usuario"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="ec.edu.ups.modelo.Producto"%>
<%@page import="java.util.List"%>
<%@page import="ec.edu.ups.modelo.PedidoCabecera"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<% List<PedidoCabecera> list = (List<PedidoCabecera>) request.getAttribute("listapedidos"); %>
	<% PrintWriter out2= response.getWriter();%>
	
	
	<!-- this.setId(id);
		this.setFk_usu_id(fk_usu_id);
		this.setFk_emp_id(fk_emp_id);
		this.setEstado(estado); -->
		
	
	<table class='tg' style='width:95%'>
	    <tr>
	        <th class='tg-46ru'>Numero de Pedido: </th>
	        <th class='tg-46ru'>Estado Actual: </th>
	        <th class='tg-46ru'>Detalles: </th>
	        <th class='tg-46ru'></th>
	        <th class='tg-46ru'></th>
	       
	    </tr>

	    <% 

	    	for (int i=0;i<list.size();i++){
	    		PedidoCabecera prod=list.get(i);
	    		int id = prod.getId();
	    		out.println("<tr><form> <td class='tg-y698'><label name='nombre"+id+"'>Pedido N.-"+(i+1)+"</label></td>");
	    		char est = prod.getEstado();
	    		if (est =='T' ){
	    			out.println("<td class='tg-y698'><label > Tramite </label></td> <INPUT type = 'hidden' value = "+est+" name='estado"+id+"'/>");
	    		}else if(est =='A'){
	    			out.println("<td class='tg-y698'><label > Aprobado </label></td> <INPUT type = 'hidden' value = "+est+" name='estado"+id+"'/>");
	    		}else{
	    			out.println("<td class='tg-y698'><label > Rechazado </label></td> <INPUT type = 'hidden' value = "+est+" name='estado"+id+"'/>");
	    		}
	    		out.println("<td class='tg-y698'><BUTTON onclick='MostrarDetalles("+id+")'>Ver: </BUTTON></td>");
	    		
	    		
	    		
	    		
	    		
	    		//out.println("<td class='tg-y698'><BUTTON onclick='CambiarEstad("+prod.getFk_usu_id()+", "+EstaA+" ,"+id+")'>Aprobar pedido</BUTTON></td>");
	    		out.println("<td class=\"tg-y698\"><BUTTON onclick=\"CambiarEstad("+prod.getFk_usu_id()+", 'A' ,"+id+")\">Aprobar pedido</BUTTON></td>");
	    		
	    		
	    		//out.println("<td class='tg-y698'><BUTTON onclick='CambiarEstad("+prod.getFk_usu_id()+", "+EstaR+" ,"+id+")'>Rechazar pedido</BUTTON></td>");
	    		out.println("<td class=\"tg-y698\"><BUTTON onclick=\"CambiarEstad("+prod.getFk_usu_id()+", 'R' ,"+id+")\">Rechazar pedido</BUTTON></td>");
	    		
	    		
	    		
	    		
	       	}
	    %>
	
	</table>
	
	
	
	<div id = "aquiDetallesO">
	
	</div>
		
	
	
	
	
	