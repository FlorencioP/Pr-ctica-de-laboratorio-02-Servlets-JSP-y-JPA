<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Persona Encontrada</title>
</head>
<body>
	<c:set var="u" scope="request" value="${usu}" />
	<h1>Persona encontrada</h1>		

	<p>Id: ${u.id}</p>
	<p>Nombre: ${u.nombre}</p>
	<p>Apellido: ${u.apellido}</p>
	<p>Correo: ${u.correo}</p>
	<p>Password: ${u.password}</p>
	<p>Rol: ${u.rol}</p>
	<p>EmpresaID: ${u.FKEmpID}</p>

	<a href="index.html">Regresar al index</a>

</body>
</html>