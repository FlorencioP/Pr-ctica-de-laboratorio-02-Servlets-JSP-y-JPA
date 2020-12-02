<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="java.io.PrintWriter"%>
<%@page import="ec.edu.ups.modelo.PedidoDetalle"%>
<%@page import="ec.edu.ups.modelo.Producto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set var="p" scope="request" value="${listDetalles}" />
	<% List<PedidoDetalle> list = (List<PedidoDetalle>) request.getAttribute("listDetalles"); %>
	<% List<Producto> list2 = (List<Producto>) request.getAttribute("listProducto"); %>
	<% PrintWriter out2= response.getWriter();%>
	<table class='tg' style='width:95%'>
	    <tr>
	        <th class='tg-46ru'>Nombre</th>
	        <th class='tg-46ru'>Descripcion</th>
	        <th class='tg-46ru'>Cantidad</th>
	        <th class='tg-46ru'>Precio Unitario</th>
	        <th class='tg-46ru'>Total</th>
	        <th class='tg-46ru'></th>
	        <th class='tg-46ru'></th>
	    </tr>
	
	    <% for (int i=0;i<list.size();i++){
	    		Producto prod=list2.get(i);
	    		PedidoDetalle pedDet=list.get(i);
	    		Float total=(prod.getPrecio())*(pedDet.getCantidad());
	    		out.println("<tr><td class='tg-y698'>"+prod.getNombre()+"</td><td class='tg-y698'>"+prod.getDescripcion()+"</td><td" +
	    					" class='tg-y698'>"+pedDet.getCantidad()+"</td><td class='tg-y698'>"+prod.getPrecio()+
	    					"</td><td class='tg-y698'>"+total+"</td><td class='tg-y698'><input type='button'"+
	    					" value='Modificar' onclick='modificarPed(this,"+pedDet.getFKPedCabID()+","+pedDet.getId()+","+prod.getId()+")'></td>"+
	    					"<td class='tg-y698'><input type='button' value='Eliminar' onclick='recogerDat(this)'></td>");
	       }
	    %>
	
	</table>
</body>
</html>