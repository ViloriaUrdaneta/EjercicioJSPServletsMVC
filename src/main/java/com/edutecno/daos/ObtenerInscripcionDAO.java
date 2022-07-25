package com.edutecno.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.contantes.Constantes;
import com.edutecno.dto.InscripcionDTO;

public class ObtenerInscripcionDAO {

	public List<InscripcionDTO> obtieneInscripciones () throws ClassNotFoundException, SQLException{
		
		List<InscripcionDTO> listaInscripciones = new ArrayList<InscripcionDTO>();
		Class.forName(Constantes.STRING_CONEXION_ORACLE);
		Connection conexion = null;
		String url= Constantes.URL_CONEXION_ORACLE;
		conexion = DriverManager.getConnection(url,Constantes.USUARIO_ORACLE,Constantes.PASSWORD_ORACLE);
		
		try(PreparedStatement sentencia = conexion.prepareStatement(Constantes.QUERY_OBTENER_INSCRIPCIONES)){
			
			ResultSet resultado = sentencia.executeQuery();
			
			while(resultado.next()) {
				//crear curso y añadir a lista de cursos
				InscripcionDTO inscripcion = new InscripcionDTO();
				inscripcion.setIdCurso(resultado.getString("id_curso"));
				inscripcion.setIdFormaPago(resultado.getString("id_forma_pago"));
				inscripcion.setIdInscripcion(resultado.getInt("id_inscripcion"));
				inscripcion.setNombre(resultado.getString("nombre"));
				inscripcion.setTelefono(resultado.getInt("telefono"));
				
				listaInscripciones.add(inscripcion);
			}	
		}catch(Exception ex) {	
		}
		return listaInscripciones;
		
	}
	
}
