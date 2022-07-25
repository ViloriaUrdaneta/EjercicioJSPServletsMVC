package com.edutecno.facade;

import java.sql.SQLException;
import java.util.List;

import com.edutecno.daos.CursoDAO;
import com.edutecno.daos.FormaDePagoDAO;
import com.edutecno.daos.InscripcionDAO;
import com.edutecno.daos.ObtenerInscripcionDAO;
import com.edutecno.dto.CursoDTO;
import com.edutecno.dto.FormaDePagoDTO;
import com.edutecno.dto.InscripcionDTO;

public class Facade {
	
	//devolver una lista de cursos
	public List<CursoDTO> obtenerCursos() throws ClassNotFoundException, SQLException{
		CursoDAO dao = new CursoDAO();
		return dao.obtieneCursos();
	}
	
	//metodo que devuelva lista de formas de pago
	public List<FormaDePagoDTO> obtenerFormapago() throws ClassNotFoundException, SQLException{
		FormaDePagoDAO dao = new FormaDePagoDAO();
		return dao.obtieneFormaPago();
	}
	
	public List<InscripcionDTO> obtenerInscripciones() throws ClassNotFoundException, SQLException{
		
		ObtenerInscripcionDAO dao = new ObtenerInscripcionDAO();
		return dao.obtieneInscripciones();
	}
	
	public int guardarInscripcion(InscripcionDTO inscripcion) throws ClassNotFoundException, SQLException {
		InscripcionDAO dao = new InscripcionDAO();
		return dao.insertarInscripcion(inscripcion);
	}

}
