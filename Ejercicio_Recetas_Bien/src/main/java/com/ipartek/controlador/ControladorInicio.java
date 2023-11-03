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
 * Servlet implementation class ControladorInicio
 */
@WebServlet("/ControladorInicio")
public class ControladorInicio extends HttpServlet implements DAO {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorInicio() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DB_Helper db= new DB_Helper();
		Connection con = db.connect();
		List<Dificultad> listaDificultades= db.obtenerDificultades(con);
		List<Estilo> listaEstilos= db.obtenerEstilos(con);
		List<Receta> listaRecetas= db.obtenerRecetas(con);
		//Se mandan al jsp
		request.setAttribute("dificultades", listaDificultades);
		request.setAttribute("estilos", listaEstilos);
		request.setAttribute("recetas", listaRecetas);
		request.getRequestDispatcher(JSP_INDEX).forward(request, response);
		db.disconnect(con);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
