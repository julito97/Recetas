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
import com.ipartek.modelo.dto.Estilo;

/**
 * Servlet implementation class ControladorEstilo
 */
@WebServlet("/ControladorEstilo")
public class ControladorEstilo extends HttpServlet implements DAO {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorEstilo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DB_Helper db = new DB_Helper();
		Connection con = db.connect();

		List<Estilo> listaEstilos = db.obtenerEstilos(con);
		db.disconnect(con);

		request.setAttribute("estilos", listaEstilos);
		request.getRequestDispatcher("get_estilos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
