package com.ipartek.modelo;

public interface DAO {
	
	final String DRIVER = "com.mysql.jdbc.Driver";
	final String DATABASE = "db_recetas";
	final String CONNECTION_URL = "jdbc:mysql://localhost:3306/" + DATABASE;
	final String USER = "root";
	final String PASS = "admin";
	//JSP
	final String JSP_INDEX = "crud.jsp";
	final String JSP_ESTILOSD = "get_estilos.jsp";
	final String JSP_DIFICULTADES = "get_dificultades.jsp";
	//TABLA DIFICULTADES
	String TABLA_DIFICULTADES = "dificultades";
	String DIFICULTADES_ID = "id";
	String DIFICULTADES_DIFICULTAD = "dificultad";
	//TABLA ESTILOS
	String TABLA_ESTILOS = "estilos";
	String ESTILOS_ID = "id";
	String ESTILOS_ESTILO = "estilo";
	//TABLA RECETAS
	String TABLA_RECETAS = "recetas";
	String RECETAS_ID = "id";
	String RECETAS_NOMBRE = "nombre";
	String RECETAS_FK_DIF = "fk_dificultad";
	String RECETAS_FK_EST = "fk_estilo";
	//PROCEDIMIENTOS ALMACENADOS
	String SP_INSERTAR_DIFICULTAD = "call sp_insertar_dificultades(?);";
	String SP_INSERTAR_ESTILO = "call sp_insertar_estilos(?);";
	String SP_INSERTAR_RECETA = "call sp_insertar_receta(?, ?, ?);";
	String SP_OBTENER_DIFICULTADES = "call sp_obtener_dificultades();";
	String SP_OBTENER_ESTILOS = "call sp_obtener_estilos();";
	String SP_OBTENER_RECETAS = "call sp_obtener_vista_todas_recetas();";
	//
}
