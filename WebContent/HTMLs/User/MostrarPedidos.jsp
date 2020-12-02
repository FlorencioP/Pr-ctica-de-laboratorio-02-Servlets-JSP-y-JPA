<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="java.io.PrintWriter"%>
<%@page import="ec.edu.ups.modelo.PedidoCabecera"%>
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
	<c:set var="p" scope="request" value="${listPedCab}" />
	<% List<PedidoCabecera> list = (List<PedidoCabecera>) request.getAttribute("listPedCab"); %>
	<% PrintWriter out2= response.getWriter();%>
	<table class='tg' style='width:25%'>
	    <tr>
	        <th class='tg-46ru'>ID</th>
	        <th class='tg-46ru'>Estado</th>
	        <th class='tg-46ru'>Descripcion</th>
	    </tr>
	
	    <% for (int i=0;i<list.size();i++){
	    		PedidoCabecera pedCab=list.get(i);
	    		if(pedCab.getEstado()!='E'){
	    			String estado=" ";
		    		if(pedCab.getEstado()=='T'){
		    			estado="Tamite";
		    		}else if(pedCab.getEstado()=='R'){
		    			estado="Rechazado";
		    		}
		    		else if(pedCab.getEstado()=='A'){
		    			estado="Aprovado";
		    		}
		    		out.println("<tr><td class='tg-y698'>"+pedCab.getId()+"</td><td class='tg-y698'>"+estado+"</td><td" +
		    					" class='tg-y698'><input type='button' value='Ver' onclick='verPedidosUsu(this)'></td>");
	    		}
	       }
	    %>
	
	</table>
</body>
</html>