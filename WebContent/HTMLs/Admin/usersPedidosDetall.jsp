<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="ec.edu.ups.modelo.Usuario"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="ec.edu.ups.modelo.Producto"%>
<%@page import="ec.edu.ups.modelo.PedidoDetalle"%>
<%@page import="java.util.List"%>
<%@page import="ec.edu.ups.modelo.PedidoCabecera"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<% List<PedidoDetalle> list = (List<PedidoDetalle>) request.getAttribute("listadetalles"); %>
	<% PrintWriter out2= response.getWriter();%>
	
	
	<!-- this.setId(id);
		this.setCantidad(cantidad);
		this.setFKPedCabID(FKPedCabID);
		this.setFKProdID(FKProdID); -->
		
	
	<table class='tg' style='width:95%'>
	    <tr>
	        <th class='tg-46ru'>Nombre del Producto: </th>
	        <th class='tg-46ru'>Cantidad: </th>
	        <th class='tg-46ru'>Presio por unidad: </th>
	        <th class='tg-46ru'>Total: </th>

	       
	    </tr>

	    <% for (int i=0;i<list.size();i++){
	    		PedidoDetalle prod=list.get(i);
	    		int id = prod.getId();
	    		
	    		out.println("<tr><form> <td class='tg-y698'><label name='nombre"+id+"'>"+prod.getNombre()+"</label></td>");	  
	    		out.println("<td class='tg-y698'><label name='cant"+id+"'>"+prod.getCantidad()+"</label></td>");	
	    		out.println("<td class='tg-y698'><label name='cant"+id+"'>"+prod.getD()+"</label></td>");
	    		out.println("<td class='tg-y698'><label name='cant"+id+"'>"+(prod.getCantidad()*prod.getD())+"</label></td>");
	    		out.println("</form></tr>");
	    						
	       	}
	    %>
	
	</table>
	
	
	
	
	
	