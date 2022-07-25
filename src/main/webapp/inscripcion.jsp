<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="recibe" method="POST">

		<label>Nombre</label>
		<input type="text" name="nombre" id="nombre"><br><br>
		<label>Telefono</label>
		<input type="text" name="telefono" id="telefono"><br><br>
		

		<select name="idCurso">
			<c:forEach var="cursos" items="${requestScope.cursos}">
				<option value="${cursos.getIdCurso()}">
					${cursos.getDescripcion()}</option>
			</c:forEach>
		</select> <select name="idFormaPago">
			<c:forEach var="pagos" items="${requestScope.pagos}">
				<option value="${pagos.getIdFormaPago()}">
					${pagos.getDescripcion()}</option>
			</c:forEach>
		</select> <input type="submit" value="enviar">
	</form>

</body>
</html>