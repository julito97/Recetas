package com.ipartek.controlador;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.modelo.DB_Helper;
import com.ipartek.modelo.dto.Dificultad;

/**
 * Servlet implementation class CrearDificultad
 */
@WebServlet("/CrearDificultad")
public class CrearDificultad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearDificultad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dificultad = "";
		if (request.getParameter(dificultad) != null) {
			dificultad = request.getParameter(dificultad);
		}
		Dificultad aux = new Dificultad(0, dificultad);
		DB_Helper db = new DB_Helper();
		Connection con = db.connect();

		db.nuevaDificultad(con, aux);
		List<Dificultad> listaDificultades = db.obtenerDificultades(con);
		request.setAttribute("dificultades", listaDificultades);
		request.getRequestDispatcher("dificultades").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
