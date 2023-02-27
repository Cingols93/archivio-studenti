<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="parts/head.jsp"%>
</head>
<body>

	<%@ include file="parts/header.jsp"%>
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
            			Modifica Studente
            		</c:if>
						<c:if test="${student == null}">
            			Aggiungi nuovo Studente
            		</c:if>
					</h2>
				</caption>

				<c:if test="${student != null}">
					<input type="hidden" name="id"
						value="<c:out value='${student.id}' />" />
				</c:if>


				<fieldset class="form-group">
					<label>Nome</label><input type="text"
						value="<c:out value='${student.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Cognome</label><input type="text"
						value="<c:out value='${student.surname}' />" class="form-control"
						name="surname" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Indirizzo</label><input type="text"
						value="<c:out value='${student.address}' />" class="form-control"
						name="address" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Matricola</label><input type="text"
						value="<c:out value='${student.studentId}' />"
						class="form-control" maxlength="5" name="studentId" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Data di nascita</label><input type="date"
						value="<c:out value='${student.dateOfBirth}' />"
						class="form-control" name="dateOfBirth" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Dipartimento</label> 
					<select class="form-select"
						aria-label="seleziona un dipartimento" name="idDepartment" required="required">
						<c:forEach items="${listOfDepartment}" var="department">
							<option value="${department.id}">${department.name}</option>
							<br>
						</c:forEach>
					</select> 
				</fieldset>

				<button type="submit" class="btn btn-success mt-2">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>