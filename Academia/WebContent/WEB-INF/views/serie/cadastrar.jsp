<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form commandName="serie" action="./cadastrarSerie">
		<table>
			<tr>
				<td><fieldset>
						<legend>Dia da semana:</legend>
						<form:errors path="semanas" cssClass="text-warning" element="div" />
						<form:checkboxes items="${semanas }" path="semanas" />
					</fieldset></td>
			</tr>
			<tr>
				<td height="20px;"></td>
			</tr>
			<tr>
				<td>
					<fieldset>
						<legend>Modalidade:</legend>
						<table>
							<tr>
								<td><form:label path="modalidade.nome">Nome:</form:label></td>
								<td><form:errors path="modalidade.nome"
										cssClass="text-warning" element="div" /> <form:input
										path="modalidade.nome" /></td>
							</tr>
							<tr>

								<td><form:label path="modalidade.intervaloPausa">Intervalo (minutos):</form:label></td>
								<td><form:errors path="modalidade.intervaloPausa"
										cssClass="text-warning" element="div" /> <form:input
										path="modalidade.intervaloPausa" /></td>
							</tr>
							<tr>
								<td><label for="tipoModalidade">Tipo modalidade:</label></td>
								<td><select id="tipoModalidade" name="tipoModalidade">
										<c:forEach items="${tipoModalidade }" var="modalidade">
											<option value="${modalidade.tipoModalidade }">${modalidade.tipoModalidade }</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="Cadastrar"
									class="btn btn-primary"></td>
							</tr>
						</table>
					</fieldset>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>