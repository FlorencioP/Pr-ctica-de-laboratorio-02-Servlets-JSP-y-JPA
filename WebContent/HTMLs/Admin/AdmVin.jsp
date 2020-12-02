<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="ec.edu.ups.modelo.Usuario"%>
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
    
    if (u.getFKEmpID() == 1){
    	out.println("<link rel='stylesheet' type='text/css' href='/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/CSS/directorioVin.css' />");
    }else if (u.getFKEmpID() == 2){
    	out.println("<link rel='stylesheet' type='text/css' href='/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/CSS/directorioAer.css' />");
    }else{
    	out.println("<link rel='stylesheet' type='text/css' href='/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/CSS/directorio9ci.css' />");
    }
    %>
    
<script src='/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/JavaScript/funcionesAdmin.js'></script>
</head>
<body>

	<% 
    
    if (u.getFKEmpID() == 1){
    	out.println("<p>Viñedo del Amanecer: Administracion de Pedidos</p>");
    }else if (u.getFKEmpID() == 2){
    	out.println("<p>Aeropostale: Administracion de Pedidos</p>");
    }else{
    	out.println("<p>Mercado 9cito: Administracion de Pedidos</p>");
    }
    %>
	    
	<div id = "OpsAdm">
	    <div id="volver">
	        <a href="/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/Salir"><img src="/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/Recursos/logout.png"></a>
	    </div>


	    <form id="regProd">
	        <input type="button" value="Registrar Producto" onclick="crearprods(${u.FKEmpID})" /><br>
	    </form>
	
	
	
	    <form id="editProd">
	        <input type="button" value="Modificar Productos" onclick="editarprods(${u.FKEmpID})" /><br>
	    </form>
	
		<form id="manPeds">
	        <input type="button" value="Manejar Pedidos" onclick="manejoPeds(${u.FKEmpID})" /><br>
	    </form>
	
		<!--  
		<h1>Persona encontrada</h1>		
	
		<p>Id: ${u.id}</p>
		<p>Nombre: ${u.nombre}</p>
		<p>Apellido: ${u.apellido}</p>
		<p>Correo: ${u.correo}</p>
		<p>Password: ${u.password}</p>
		<p>Rol: ${u.rol}</p>
		<p>EmpresaID: ${u.FKEmpID}</p>-->
		
		<INPUT type = "hidden" value = "${u.FKEmpID}" name="IDEmpre"/>
	</div>


	<div id = "PantallaAdm">
	
	
	
	
	</div>




</body>
</html>