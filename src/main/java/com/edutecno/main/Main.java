package com.edutecno.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.dto.CursoDTO;
import com.edutecno.dto.FormaDePagoDTO;
import com.edutecno.dto.InscripcionDTO;
import com.edutecno.facade.Facade;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		obtenerListaCursos();
		obtenerFomaDePagos();
		insertarInscripcion();
		
	}

	private static void obtenerListaCursos() throws ClassNotFoundException, SQLException {
		List<CursoDTO> lista = new ArrayList<CursoDTO>();
		Facade facade = new Facade();
		lista = facade.obtenerCursos();
		
		for (CursoDTO curso : lista) {
			System.out.println(curso.getIdCurso());
			System.out.println(curso.getPrecio());
			System.out.println(curso.getDescripcion());
		}
	}
	
	private static void obtenerFomaDePagos() throws ClassNotFoundException, SQLException {
		List<FormaDePagoDTO> lista = new ArrayList<FormaDePagoDTO>();
		Facade facade = new Facade();
		lista = facade.obtenerFormapago();
		
		for (FormaDePagoDTO forma : lista) {
			System.out.println(forma.getIdFormaPago());
			System.out.println(forma.getRecargo());
			System.out.println(forma.getDescripcion());
		}
	}
	
	private static void insertarInscripcion() throws ClassNotFoundException, SQLException {
		
		Facade facade = new Facade();
		
		InscripcionDTO inscripcion = new InscripcionDTO();
		inscripcion.setIdCurso("1");
		inscripcion.setIdFormaPago("1");
		inscripcion.setNombre("Julio");
		inscripcion.setTelefono(1236);

		System.out.println(facade.guardarInscripcion(inscripcion));
		
	}

}
