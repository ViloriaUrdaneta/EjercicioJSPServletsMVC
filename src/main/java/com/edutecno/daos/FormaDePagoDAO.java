package com.edutecno.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.contantes.Constantes;
import com.edutecno.dto.FormaDePagoDTO;

public class FormaDePagoDAO {

	public List<FormaDePagoDTO> obtieneFormaPago() throws SQLException, ClassNotFoundException {

		List<FormaDePagoDTO> listaFormaPago = new ArrayList<FormaDePagoDTO>();
		Class.forName(Constantes.STRING_CONEXION_ORACLE);
		Connection conexion = null;
		String url = Constantes.URL_CONEXION_ORACLE;
		conexion = DriverManager.getConnection(url, Constantes.USUARIO_ORACLE, Constantes.PASSWORD_ORACLE);

		try (PreparedStatement sentencia = conexion.prepareStatement(Constantes.QUERY_OBTENER_FPAGO)) {

			ResultSet resultado = sentencia.executeQuery();

			while (resultado.next()) {
				// crear formaPago y añadir a lista de formaPago
				FormaDePagoDTO formaPago = new FormaDePagoDTO();
				formaPago.setIdFormaPago(resultado.getString("id_forma_pago"));
				formaPago.setDescripcion(resultado.getString("descripcion"));
				formaPago.setRecargo(resultado.getString("recargo"));

				listaFormaPago.add(formaPago);
			}
		} catch (Exception ex) {
		}

		return listaFormaPago;
	}

}
