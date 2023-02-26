<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Management Application</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<body>

	<%@ include file="parts/header.jsp"%>
	<br>
	
	<div class="container">
		<h3 class="text-center">List of Students</h3>
		<hr>
		<div class="container text-left">
			<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
				new student</a>
		</div>
		<br>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Cognome</th>
					<th>Indirizzo</th>
					<th>Matricola</th>
					<th>Data di nascita</th>
					<th>Dipartimento</th>
					<th>Azioni</th>
			</thead>
			<tbody>
				<c:forEach var="student" items="${listStudent}">
					<tr>
						<td><c:out value="${student.id}" /></td>
						<td><c:out value="${student.nome}" /></td>
						<td><c:out value="${student.cognome}" /></td>
						<td><c:out value="${student.indirizzo}" /></td>
						<td><c:out value="${student.matricola}" /></td>
						<td><c:out value="${student.dataDiNascita}" /></td>
						<td><c:out value="${student.idDipartimento}" /></td>
						<td><a href="edit?id=<c:out value='${student.id}' />">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="delete?id=<c:out value='${student.id}' />">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>