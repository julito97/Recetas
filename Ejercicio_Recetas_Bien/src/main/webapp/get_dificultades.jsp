<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.ipartek.modelo.dto.Dificultad"%>
<%
List<Dificultad> listaDificultades = new ArrayList<Dificultad>();
if (request.getAttribute("dificultades") != null) {
	listaDificultades = (List<Dificultad>) request.getAttribute("dificultades");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="estilos/styles.css"/>
<title>Adición de dificultades</title>
</head>
<body>
	<main>
		<form method="Post" action="CrearDificultad">
			<input type="text" name="dificultad"
				placeholder="nombre de la dificultad"> <br> <input
				type="submit" value="Crear">
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
					<th>Dificultad</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (Dificultad elemento : listaDificultades) {
				%>
				<tr>
					<td><%=elemento.getId()%></td>
					<td><%=elemento.getDificultad()%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</main>
</body>
</html>