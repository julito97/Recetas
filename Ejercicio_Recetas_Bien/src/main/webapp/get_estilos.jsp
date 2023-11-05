<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.modelo.dto.Estilo"%>
<%@page import="java.util.List"%>
<%
List<Estilo> listaEstilos = new ArrayList<Estilo>();
if (request.getAttribute("estilos") != null) {
	listaEstilos = (List<Estilo>) request.getAttribute("estilos");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="estilos/styles.css" />
<title>Adición de estilos</title>
</head>
<body>
	<main>
		<form method="Post" action="CrearEstilo">
			<input type="text" name="estilo" placeholder="nombre del estilo">
			<br> <input type="submit" value="Crear">
		</form>
		
		<nav>
			<ul>
				<li><a href="ControladorInicio">INICIO</a></li>
				<li><a href="ControladorDificultad">DIFICULTADES</a></li>
				<li><a href="ControladorEstilo">ESTILOS</a></li>
			</ul>
		</nav>
		
		<table border="1px solid black">
			<thead>
				<tr>
					<th>ID</th>
					<th>Estilo</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (Estilo elemento : listaEstilos) {
				%>
				<tr>
					<td><%=elemento.getId()%></td>
					<td><%=elemento.getEstilo()%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
</body>
</html>