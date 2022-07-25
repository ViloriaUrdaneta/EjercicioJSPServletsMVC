package com.edutecno.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.contantes.Constantes;
import com.edutecno.dto.CursoDTO;

public class CursoDAO {

	
	
	public List<CursoDTO> obtieneCursos() throws ClassNotFoundException, SQLException {
		
		//Saltar a base de datos
		//Acceso por Java Data Base Conectivity (JDBC)
		
		//String de conexion oracle
		List<CursoDTO> listaDeCursos = new ArrayList<CursoDTO>();
		Class.forName(Constantes.STRING_CONEXION_ORACLE);
		Connection conexion = null;
		String url= Constantes.URL_CONEXION_ORACLE;
		conexion = DriverManager.getConnection(url,Constantes.USUARIO_ORACLE,Constantes.PASSWORD_ORACLE);
		
		try(PreparedStatement sentencia = conexion.prepareStatement(Constantes.QUERY_OBTENER_CURSOS)){
			
			ResultSet resultado = sentencia.executeQuery();
			
			while(resultado.next()) {
				//crear curso y añadir a lista de cursos
				CursoDTO curso = new CursoDTO();
				curso.setIdCurso(resultado.getString("id_curso"));
				curso.setDescripcion(resultado.getString("descripcion"));
				curso.setPrecio(resultado.getDouble("precio"));
				
				listaDeCursos.add(curso);
			}	
		}catch(Exception ex) {	
		}
		
		return listaDeCursos;
	}

}
