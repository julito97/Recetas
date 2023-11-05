<%@page import="com.ipartek.modelo.dto.Receta"%>
<%@page import="com.ipartek.modelo.dto.Estilo"%>
<%@page import="com.ipartek.modelo.DAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.modelo.dto.Dificultad"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
List<Dificultad> listaDificultades = new ArrayList<Dificultad>();
if (request.getAttribute("dificultades") != null) {
	listaDificultades = (List<Dificultad>) request.getAttribute("dificultades");
}

List<Estilo> listaEstilos = new ArrayList<Estilo>();
if (request.getAttribute("estilos") != null) {
	listaEstilos = (List<Estilo>) request.getAttribute("estilos");
}

List<Receta> listaRecetasVista = new ArrayList<Receta>();
if (request.getAttribute("recetas") != null) {
	listaRecetasVista = (List<Receta>) request.getAttribute("recetas");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web de recetas</title>
</head>
<body>
	<h1>RECETAS INICIO</h1>
	<form method="Post" action="CrearReceta">

		<input type="text" name="nombre" placeholder="Nombre">
		<br> <select name="fk_dificultad">
			<%
			for (Dificultad elemento : listaDificultades) {
			%>
			<option value="<%=elemento.getId()%>"><%=elemento.getDificultad()%></option>
			<%
			}
			%>
		</select><br> <select name="fk_estilo">
			<%
			for (Estilo elemento : listaEstilos) {
			%>
			<option value="<%=elemento.getId()%>"><%=elemento.getEstilo()%></option>
			<%
			}
			%>
		</select><br> <input type="submit" value="Crear">
	</form>
	<nav>
		<ul>
			<li><a href="ControladorInicio">INICIO</a></li>
			<li><a href="ControladorDificultades">DIFICULTADES</a></li>
			<li><a href="ControladorEstilo">ESTILOS</a></li>
		</ul>
	</nav>

	<table border="1px solid black">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Estilo</th>
				<th>Dificultad</th>
			</tr>
		</thead>
		<tbody>
		<% for(Receta elemento:listaRecetasVista){%>
            <tr>
                <td><%=elemento.getId()%></td>
                <td><%=elemento.getNombre()%></td>
                <td><%=elemento.getFk_estilo()%></td>
                <td><%=elemento.getFk_dificultad()%></td>
            </tr>
         <%}%>  
		</tbody>
	</table>
</body>
</html>