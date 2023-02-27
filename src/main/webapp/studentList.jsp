<%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "javax.servlet.*,java.text.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="parts/head.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<body>

	<%@ include file="parts/header.jsp"%>
	<br>

	<div class="container">
		<h3 class="text-center">Lista degli Studenti</h3>
		<hr>
		<div class="container text-left">
			<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Aggiungi
				nuovo studente</a>
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
						<td><c:out value="${student.name}" /></td>
						<td><c:out value="${student.surname}" /></td>
						<td><c:out value="${student.address}" /></td>
						<td><c:out value="${student.studentId}" /></td>
						<td>
							<%
							Date dNow = new Date();
							SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
							out.print(ft.format(dNow));
							%>
						</td>
						<td><c:out value="${student.departmentName}" /></td>
						<td><a href="edit?id=<c:out value='${student.id}' />">Modifica</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="delete?id=<c:out value='${student.id}' />">Cancella</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>