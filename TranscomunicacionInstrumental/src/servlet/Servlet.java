package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Util;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		try (PrintWriter out = response.getWriter()) {
			
			if (request.getParameter("opcion").equals("letras")) {
				int lineas = 100;
				if (request.getParameter("lineas") == null) {
					out.print("automatico");
				} else {
					lineas = Integer.parseInt(request.getParameter("lineas"));
				}
				
				int frecuencia = Integer.parseInt(request.getParameter("frecuencia"));
				String ruta = request.getParameter("ruta1");
				
				String rutaFinal = Util.generaPortadora(lineas, frecuencia, ruta);
				String rutaDiccionario = request.getParameter("ruta2");
				
				if (rutaFinal.equals("error")) {
					out.print("error");
				} else {
					out.print("ok");
				}
				
				request.getSession().setAttribute("ruta1", rutaFinal);
				request.getSession().setAttribute("ruta2", rutaDiccionario);
				
			} else if (request.getParameter("opcion").equals("letrasNumeros")) {
				int lineas = 100;
				if (request.getParameter("lineas") == null) {
					out.print("automatico");
				} else {
					lineas = Integer.parseInt(request.getParameter("lineas"));
				}
				
				int frecuencia = Integer.parseInt(request.getParameter("frecuencia"));
				String ruta = request.getParameter("ruta1");
				
				String rutaFinal = Util.generaPortadoraLn(lineas, frecuencia, ruta);
				String rutaDiccionario = request.getParameter("ruta2");
				
				if (rutaFinal.equals("error")) {
					out.print("error");
				} else {
					out.print("ok");
				}
				
				request.getSession().setAttribute("ruta1", rutaFinal); 
				request.getSession().setAttribute("ruta2", rutaDiccionario);
			}
		}
		
	}

}
