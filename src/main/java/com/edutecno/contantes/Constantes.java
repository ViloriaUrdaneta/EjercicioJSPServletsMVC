package com.edutecno.contantes;

public class Constantes {

	public static final String  STRING_CONEXION_ORACLE = "oracle.jdbc.driver.OracleDriver";
	public static final String  URL_CONEXION_ORACLE = "jdbc:oracle:thin:@//localhost:1521/xe";
	public static final String  USUARIO_ORACLE = "BDDCURSOS";
	public static final String  PASSWORD_ORACLE = "1234";
	
	public static final String  STRING_CONEXION_MYSQL = "com.mysql.cj.jdbc.Driver";
	public static final String  URL_CONEXION_MYSQL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String  USUARIO_MYSQL = "BDDCURSOS";
	public static final String  PASSWORD_MYSQL = "1234";
	
	public static final String QUERY_OBTENER_FPAGO = "select * from forma_pago";
	public static final String QUERY_OBTENER_CURSOS = "select * from curso";
	public static final String QUERY_OBTENER_INSCRIPCIONES = "select * from inscripcion";

}
