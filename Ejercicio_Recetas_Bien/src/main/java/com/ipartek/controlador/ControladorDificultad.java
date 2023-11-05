package com.ipartek.controlador;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.modelo.DAO;
import com.ipartek.modelo.DB_Helper;
import com.ipartek.modelo.dto.Dificultad;

/**
 * Servlet implementation class ControladorDificultad
 */
@WebServlet("/ControladorDificultad")
public class ControladorDificultad extends HttpServlet implements DAO {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorDificultad() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DB_Helper db = new DB_Helper();
		Connection con = db.connect();
		List<Dificultad> listaDificultades = db.obtenerDificultades(con);
		db.disconnect(con);
		request.setAttribute("dificultades", listaDificultades);
		request.getRequestDispatcher("get_dificultades.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
