<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="parts/head.jsp"%>
<body>

	<%@ include file="parts/header.jsp"%>
	<br>
	
	<div class="container">
		<h3 class="text-center">Lista dei Dipartimenti</h3>
		<hr>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Indirizzo</th>
					<th>CAP</th>
			</thead>
			<tbody>
				<c:forEach var="department" items="${listDepartment}">
					<tr>
						<td><c:out value="${department.id}" /></td>
						<td><c:out value="${department.name}" /></td>
						<td><c:out value="${department.address}" /></td>
						<td><c:out value="${department.postalCode}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>