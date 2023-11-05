package com.ipartek.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ipartek.modelo.dto.Dificultad;
import com.ipartek.modelo.dto.Estilo;
import com.ipartek.modelo.dto.Receta;

public class DB_Helper implements DAO {

	public Connection connect() {
		Connection con = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(CONNECTION_URL, USER, PASS);
			//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_recetas", "root", "admin");
			con.setAutoCommit(false);
			System.out.println("Conexión realizada correctamente.");
		} 
		catch (SQLException | ClassNotFoundException e) {
			System.out.println("Error al conectar a la base de datos.");
			e.printStackTrace();
		}
		return con;
	}

	public void disconnect(Connection con) {

		try {
			con.close();
			System.out.println("Se ha cerrado la base de datos.");
		} catch (SQLException e) {
			System.out.println("Error al intentar desconectarse de la base de datos.");
			e.printStackTrace();
		}
	}

	public List<Dificultad> obtenerDificultades(Connection con) {
		List<Dificultad> dificultades = new ArrayList<Dificultad>();
		try {
			CallableStatement cStmt = con.prepareCall(SP_OBTENER_DIFICULTADES);

			cStmt.execute();

			ResultSet rs = cStmt.getResultSet();

			while (rs.next()) {
				Dificultad dificultad = new Dificultad();

				dificultad.setId(rs.getInt(DIFICULTADES_ID));
				dificultad.setDificultad(rs.getString(DIFICULTADES_DIFICULTAD));

				dificultades.add(dificultad);
			}
			System.out.println("LISTA DE DIFICULTADES OBTENIDA");
		} catch (SQLException e) {
			System.out.println("NO SE PUDO OBTENER LA LISTA DE DIFICULTADES");
			e.printStackTrace();
		}
		return dificultades;
	}

	public List<Estilo> obtenerEstilos(Connection con) {
		List<Estilo> estilos = new ArrayList<Estilo>();

		try {
			CallableStatement cStmt = con.prepareCall(SP_OBTENER_ESTILOS);

			cStmt.execute();

			ResultSet rs = cStmt.getResultSet();

			while (rs.next()) {
				Estilo estilo = new Estilo();

				estilo.setId(rs.getInt(ESTILOS_ID));
				estilo.setEstilo(rs.getString(ESTILOS_ESTILO));

				estilos.add(estilo);
			}
			System.out.println("LISTA DE ESTILOS OBTENIDA");
		} catch (SQLException e) {
			System.out.println("NO SE PUDO OBTENER LA LISTA DE ESTILOS");
			e.printStackTrace();
		}
		return estilos;

	}

	public List<Receta> obtenerRecetas(Connection con) {
		List<Receta> recetas = new ArrayList<Receta>();

		try {
			CallableStatement cStmt = con.prepareCall("SELECT * FROM recetas");

			cStmt.execute();

			ResultSet rs = cStmt.getResultSet();

			while (rs.next()) {
				Receta aux = new Receta();
				aux.setId(rs.getInt(1));
				aux.setNombre(rs.getString(2));
				aux.setFk_dificultad(rs.getInt(3));
				aux.setFk_estilo(rs.getInt(4));
				recetas.add(aux);
			}
		} catch (SQLException e) {
			System.out.println("Se produjo un error: " + e.getLocalizedMessage());
		}
		return recetas;
	}
	
	public void nuevaDificultad(Connection con, Dificultad dificultad) {
		try {
			CallableStatement cStmt = con.prepareCall(SP_INSERTAR_DIFICULTAD);
			cStmt.setString(1, dificultad.getDificultad());
			cStmt.execute();
			System.out.println("SE INSERTÓ EL ESTILO: " + dificultad);
		} catch (SQLException e) {
			System.out.println("NO SE INSERTÓ EL ESTILO: " + e.getLocalizedMessage());
		}
	}
	
	public void nuevaReceta(Connection con, Receta rece) {

		try {
			CallableStatement cStmt = con.prepareCall(SP_INSERTAR_RECETA);
			cStmt.setString(1, rece.getNombre());
			cStmt.setInt(2, rece.getFk_dificultad());
			cStmt.setInt(3, rece.getFk_estilo());
			cStmt.execute();
			System.out.println("SE INSERTO LA RECETA: " + rece);
		} catch (SQLException e) {
			System.out.println("NO SE INSERTO LA RECETA:");
			e.printStackTrace();
		}
	}

	public void nuevoEstilo(Connection con, Estilo esti) {
		try {
			CallableStatement cStmt = con.prepareCall(SP_INSERTAR_ESTILO);
			cStmt.setString(1, esti.getEstilo());
			cStmt.execute();
			System.out.println("SE INSERTO EL ESTILO: " + esti);
		} catch (SQLException e) {
			System.out.println("NO SE INSERTO EL ESTILO:");
			e.printStackTrace();
		}
	}
}
