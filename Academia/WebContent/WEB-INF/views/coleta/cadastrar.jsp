<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="./cadastrarColeta" commandName="perfil">
	<table>
		<tr>
			<td><form:label path="peso" cssErrorClass="erro">Peso:</form:label> </td>
			<td><form:errors path="peso" cssClass="text-warning" element="div" /><form:input cssErrorClass="erro" path="peso"  /></td>
		</tr>
		<tr>
			<td><form:label path="porcGordura" cssErrorClass="erro">Gordura (%):</form:label> </td>
			<td><form:errors path="porcGordura" cssClass="text-warning" element="div" /><form:input cssErrorClass="erro" path="porcGordura"  /></td>
		</tr>
		<tr>
			<td><form:label path="massCorporal" cssErrorClass="erro">Massa corporal (%):</form:label> </td>
			<td><form:errors path="massCorporal" cssClass="text-warning" element="div" /><form:input cssErrorClass="erro" path="massCorporal"  /></td>
		</tr>
		<tr>
			<td colspan="1"><input type="submit" value="Cadastrar" class="btn btn-primary">&emsp;&emsp;<input type="button" class="btn" value="Cancelar"> </td>
		</tr>
	</table>

</form:form>
</body>
</html>