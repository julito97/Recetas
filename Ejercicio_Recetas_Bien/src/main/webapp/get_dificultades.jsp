<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.ipartek.modelo.dto.Dificultad"%>
    <%

List<Dificultad> listaDificultades= new ArrayList<Dificultad>();
if(request.getAttribute("dificultades")!=null){
	listaDificultades= (List<Dificultad>)request.getAttribute("dificultades");
}
 

%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adición de dificultades</title>
</head>
<body>

</body>
</html>