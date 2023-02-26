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

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="http://google.com" class="navbar-brand">Student
					Management App</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-list">Students</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${student != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${student == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${student != null}">
            			Edit Student
            		</c:if>
						<c:if test="${student == null}">
            			Add New Student
            		</c:if>
					</h2>
				</caption>

				<c:if test="${student != null}">
					<input type="hidden" name="id"
						value="<c:out value='${student.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Nome</label><input type="text"
						value="<c:out value='${student.nome}' />" class="form-control"
						name="nome" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Cognome</label><input type="text"
						value="<c:out value='${student.cognome}' />" class="form-control"
						name="cognome" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Indirizzo</label><input type="text"
						value="<c:out value='${student.indirizzo}' />"
						class="form-control" name="indirizzo" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Matricola</label><input type="text"
						value="<c:out value='${student.matricola}' />"
						class="form-control" name="matricola" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Data di nascita</label><input type="text"
						value="<c:out value='${student.dataDiNascita}' />"
						class="form-control" name="dataDiNascita" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Dipartimento</label><input type="text"
						value="<c:out value='${student.idDipartimento}' />"
						class="form-control" name="idDipartimento" required="required">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>