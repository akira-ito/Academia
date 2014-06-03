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
	<form:form commandName="serie" action="./cadastrarSerie">
		<table>
			<tr>
				<td><fieldset>
						<legend>Dia da semana:</legend>
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
								<td><form:input path="modalidade.nome" /></td>
							</tr>
							<tr>

								<td><form:label path="modalidade.intervaloPausa">Intervalo:</form:label></td>
								<td><form:input path="modalidade.intervaloPausa" /></td>
							</tr>
							<tr>
								<td></td>
								<td><form:select path="modalidade">
									<form:options items="${tipoModalidade }" itemLabel="tipoModalidade" />
								</form:select> </td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="Cadastrar" class="btn btn-primary"></td>
							</tr>
						</table>
					</fieldset>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>