package com.edutecno.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.edutecno.contantes.Constantes;

import com.edutecno.dto.InscripcionDTO;

public class InscripcionDAO {

	
	public int insertarInscripcion(InscripcionDTO inscripcion) throws ClassNotFoundException, SQLException {
	
	//para sacar valor id
	String queryObetenerIdInscripcion = "SELECT MAX(id_inscripcion)+1 FROM inscripcion";
	//para insertar inscripcion	
	String insterInscripcion = "INSERT INTO inscripcion (id_inscripcion,nombre,telefono,id_curso,id_forma_pago) VALUES (?,?,?,?,?)";
	//coneccion a BD
	Class.forName(Constantes.STRING_CONEXION_ORACLE);
	Connection conexion = null;
	String url= Constantes.URL_CONEXION_ORACLE;
	conexion = DriverManager.getConnection(url,Constantes.USUARIO_ORACLE,Constantes.PASSWORD_ORACLE);
	
	//preparamos las querys en sentencias por separado
	try(
			PreparedStatement stmt = conexion.prepareStatement(insterInscripcion);
			PreparedStatement stmtNextInt = conexion.prepareStatement(queryObetenerIdInscripcion);
		){
		//ejecutamos la query del id
		ResultSet resultado = stmtNextInt.executeQuery();
		
		if (resultado.next()) {
		//armamos el inser
		stmt.setInt(1, resultado.getInt(1));
		stmt.setString(2, inscripcion.getNombre());
		stmt.setInt(3, inscripcion.getTelefono());
		stmt.setString(4, inscripcion.getIdCurso());
		stmt.setString(5, inscripcion.getIdFormaPago());
		
		//ejecutamos el insert
		if(stmt.executeUpdate() != 1) {
			System.out.println("Error al insertar datos");
		}else {
			System.out.println("insert ok");
		}
		}
		
	}catch(Exception ex) {	
	}
	return 1 ;
	}
}
