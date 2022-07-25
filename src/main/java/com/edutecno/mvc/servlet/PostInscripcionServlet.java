package com.edutecno.mvc.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edutecno.dto.InscripcionDTO;
import com.edutecno.facade.Facade;


@WebServlet("/recibe")
public class PostInscripcionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Facade facade = new Facade();
		try {
			
			int resultado;
			InscripcionDTO inscripcion = new InscripcionDTO();
			inscripcion.setIdCurso(request.getParameter("idCurso"));
			inscripcion.setIdFormaPago(request.getParameter("idFormaPago"));
			inscripcion.setNombre(request.getParameter("nombre"));
			inscripcion.setTelefono(Integer.parseInt(request.getParameter("telefono")));
			resultado = facade.guardarInscripcion(inscripcion);
			//llamar a jsp donde se van datos cargados
			request.getRequestDispatcher("listar").forward(request, response);

			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
