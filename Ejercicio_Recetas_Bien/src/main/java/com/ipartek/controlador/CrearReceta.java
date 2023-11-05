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
import com.ipartek.modelo.dto.Estilo;
import com.ipartek.modelo.dto.Receta;

/**
 * Servlet implementation class CrearReceta
 */
@WebServlet("/CrearReceta")
public class CrearReceta extends HttpServlet implements DAO {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearReceta() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = "";
		if (request.getParameter("nombre")!= null) {
			nombre=request.getParameter("nombre");
		}

		int fk_dificultad = 0;
		if (request.getParameter("fk_dificultad")!= null) {
			fk_dificultad=Integer.parseInt(request.getParameter("fk_dificultad"));
		}

		int fk_estilo = 0;
		if (request.getParameter("fk_estilo")!= null) {
			fk_estilo=Integer.parseInt(request.getParameter("fk_estilo"));
		}
		
		Receta rece = new Receta(0, nombre, fk_dificultad, fk_estilo); 
		DB_Helper db = new DB_Helper();
		Connection con = db.connect();
		
		db.nuevaReceta(con, rece);
		
		List<Dificultad> listaDificultades= db.obtenerDificultades(con);
		List<Estilo> listaEstilos= db.obtenerEstilos(con);
		List<Receta> listaRecetas= db.obtenerRecetas(con);
		db.disconnect(con);
		request.setAttribute("dificultades", listaDificultades);
		request.setAttribute("estilos", listaEstilos);
		request.setAttribute("recetas", listaRecetas);
		request.getRequestDispatcher(JSP_INDEX).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
