package com.edutecno.mvc.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edutecno.dto.CursoDTO;
import com.edutecno.dto.FormaDePagoDTO;
import com.edutecno.facade.Facade;


@WebServlet("/cargacursos")
public class PreinscripcionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Facade facade = new Facade();
		
		List<CursoDTO> listaCursos = new ArrayList<CursoDTO>();
		List<FormaDePagoDTO> listaPagos = new ArrayList<FormaDePagoDTO>();
		
		try {
			listaCursos = facade.obtenerCursos();
			listaPagos = facade.obtenerFormapago();
			request.setAttribute("pagos", listaPagos);
			request.setAttribute("cursos", listaCursos);
			request.getRequestDispatcher("inscripcion.jsp").forward(request, response);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
