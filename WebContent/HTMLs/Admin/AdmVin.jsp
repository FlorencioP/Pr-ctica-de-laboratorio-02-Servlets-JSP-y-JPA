<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="ec.edu.ups.entidades.Usuario"%>
<%@page import="ec.edu.ups.entidades.Empresa"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu de Admin</title>

    <c:set var="u" scope="request" value="${usu}" />
    <% Usuario u = (Usuario) request.getAttribute("usu"); %>
    
    <% 
    
    if (u.getEmpresa().getId() == 1){
    	out.println("<link rel='stylesheet' type='text/css' href='/Practica_de_laboratorio_02_Servlets_JSP_y_JPA/CSS/directorioVin.css' />");
    }else if (u.getEmpresa().getId() == 2){
    	out.println("<link rel='stylesheet' type='text/css' href='/Practica_de_laboratorio_02_Servlets_JSP_y_JPA/CSS/directorioAer.css' />");
    }else{
    	out.println("<link rel='stylesheet' type='text/css' href='/Practica_de_laboratorio_02_Servlets_JSP_y_JPA/CSS/directorio9ci.css' />");
    }
    %>
    
<script src='/Practica_de_laboratorio_02_Servlets_JSP_y_JPA/JavaScript/funcionesAdmin.js'></script>
</head>
<body>

	<% 
    
    if (u.getEmpresa().getId() == 1){
    	out.println("<p>Viñedo del Amanecer: Administracion de Pedidos</p>");
    }else if (u.getEmpresa().getId() == 2){
    	out.println("<p>Aeropostale: Administracion de Pedidos</p>");
    }else{
    	out.println("<p>Mercado 9cito: Administracion de Pedidos</p>");
    }
    %>
	    
	<div id = "OpsAdm">
	    <div id="volver">
	        <a href="/Practica_de_laboratorio_02_Servlets_JSP_y_JPA/Salir"><img src="/Practica_de_laboratorio_02_Servlets_JSP_y_JPA/Recursos/logout.png"></a>
	    </div>


	    <form id="regProd">
	        <input type="button" value="Registrar Producto" onclick="crearprods(${u.getEmpresa().getId()})" /><br>
	    </form>
	
	
	
	    <form id="editProd">
	        <input type="button" value="Modificar Productos" onclick="editarprods(${u.getEmpresa().getId()})" /><br>
	    </form>
	
		<form id="manPeds">
	        <input type="button" value="Manejar Pedidos" onclick="manejoPeds(${u.getEmpresa().getId()})" /><br>
	    </form>
	
		<!--  
		<h1>Persona encontrada</h1>		
	
		<p>Id: ${u.id}</p>
		<p>Nombre: ${u.nombre}</p>
		<p>Apellido: ${u.apellido}</p>
		<p>Correo: ${u.correo}</p>
		<p>Password: ${u.password}</p>
		<p>Rol: ${u.rol}</p>
		<p>EmpresaID: ${u.getEmpresa().getId()}</p>-->
		
		<INPUT type = "hidden" value = "${u.getEmpresa().getId()}" name="IDEmpre"/>
	
	</div>


	<div id = "PantallaAdm">
	
	
	
	
	</div>




</body>
</html>