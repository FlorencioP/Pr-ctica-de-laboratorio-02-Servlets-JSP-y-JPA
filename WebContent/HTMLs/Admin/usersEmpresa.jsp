<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="ec.edu.ups.modelo.Usuario"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="ec.edu.ups.modelo.Producto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

	<% List<Usuario> list = (List<Usuario>) request.getAttribute("listaClis"); %>
	<% PrintWriter out2= response.getWriter();%>
<!-- 

		this.setId(id);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setCorreo(correo);
		this.setPassword(password);
		this.setRol(rol);
		this.setFKEmpID(fKEmpID);

 -->



	<table class='tg' style='width:95%'>
	    <tr>
	        <th class='tg-46ru'>Nombre</th>
	        <th class='tg-46ru'>Apellido</th>
	        <th class='tg-46ru'>Correo</th>
	        <th class='tg-46ru'>Pedidos</th>
	       
	    </tr>

	    <% for (int i=0;i<list.size();i++){
    			Usuario prod=list.get(i);
	    		int id = prod.getId();
	    		out.println("<tr><form> <td class='tg-y698'><label name='nombre"+id+"'>"+prod.getNombre()+"</label></td>"+
	    		"<td class='tg-y698' ><label name='apellido"+id+"' >"+prod.getApellido()+"</label></td><td" +
	    					" class='tg-y698' ><label name='correo"+id+"'>"+prod.getCorreo()+"</label></td>" +
	    						"<td class='tg-y698'><BUTTON onclick='mostrarPeds("+id+")'>Ver pedidos</BUTTON></td><tr>");
	       	}
	    %>
	
	</table>
	
	
	
	<div id = "aquiPedidos">
	
	</div>