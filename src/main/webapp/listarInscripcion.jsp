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

	<table>
		<thead>
		<tr>
		<th>Id inscripcion</th>
		<th>Nombre</th>
		<th>Telefono</th>
		<th>Id curso</th>
		<th>Id forma pago</th>
		</tr>
		</thead>
	<tbody>
		<c:forEach var="inscripciones" items="${requestScope.inscripciones}">
			<tr>
				<td><c:out value="${inscripciones.getIdInscripcion()}"/></td>
				<td><c:out value="${inscripciones.getNombre()}"/></td>
				<td><c:out value="${inscripciones.getTelefono()}"/></td>
				<td><c:out value="${inscripciones.getIdCurso()}"/></td>
				<td><c:out value="${inscripciones.getIdFormaPago()}"/></td>
			</tr>
			
		</c:forEach>
	</tbody>
	
	</table>


</body>
</html>