
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="java.io.PrintWriter"%>
<%@page import="ec.edu.ups.modelo.Producto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="p" scope="request" value="${listaProd}" />
	<% List<Producto> list = (List<Producto>) request.getAttribute("listaProd"); %>
	<% PrintWriter out2= response.getWriter();%>
	<table class='tg' style='width:95%'>
	    <tr>
	        <th class='tg-46ru'>Nombre</th>
	        <th class='tg-46ru'>Precio</th>
	        <th class='tg-46ru'>Descripcion</th>
	        <!--  <th class='tg-46ru'>Imagen</th>-->
	        <th class='tg-46ru'>Cantidad</th>
	        <th class='tg-46ru'>Agregar</th>
	    </tr>
	
	    <% for (int i=0;i<list.size();i++){
	    		Producto prod=list.get(i);
	    		out.println("<tr><td class='tg-y698'>"+prod.getNombre()+"</td><td class='tg-y698'>"+prod.getPrecio()+"</td><td" +
	    					" class='tg-y698'>"+prod.getDescripcion()+"</td>"+ //<td class='tg-y698'><img src='"+prod.getDirImagen()+"'></td>"
	    					"<td class='tg-y698'><input type='text' size='5'></td><td class='tg-y698'><input type='button' value='agregar' onclick='recogerDat(this)'></td>");
	       }
	    %>
	</table>
</body>

</html>