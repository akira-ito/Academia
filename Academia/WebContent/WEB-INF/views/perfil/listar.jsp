<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form>
		<table class="table table-bordered table-hover" width="100%">
			<thead>
				<tr>
					<th>Data coleta</th>
					<th>Peso</th>
					<th>Gordura(%)</th>
					<th>Massa Corporal(%)</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${perfils }" var="perfil">
					<tr>
						<td><fmt:formatDate value="${perfil.dataColeta }"
								pattern="dd/MM/yyyy" /></td>
						<td>${perfil.peso }</td>
						<td>${perfil.porcGordura }</td>
						<td>${perfil.massCorporal }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form:form>
</body>
</html>