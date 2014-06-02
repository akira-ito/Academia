<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="./bootstrap/css/bootstrap.css" rel="stylesheet" media="screen">
<link href="./academia/academia.css" rel="stylesheet" media="screen">
</head>
<body>
<form:form action="cadastrarFuncionario" commandName="funcionario"  >
<table>
	<tr>
		<td><form:label path="nome" cssErrorClass="erro" >Nome:</form:label></td>
		<td><form:errors path="nome" cssClass="text-info" element="div"/><form:input path="nome" cssErrorClass="erro" /></td>
	</tr>
	<tr>
		<td><form:label path="idade" cssErrorClass="erro" >Idade:</form:label></td>
		<td><form:errors path="idade" cssClass="text-info" element="div" /><form:input path="idade" cssErrorClass="erro"/> </td>
	</tr>
	<tr>
		<td><form:label path="sexo" cssErrorClass="erro" >Sexo:</form:label></td>
		<td ><form:radiobuttons path="sexo" itemLabel="nome" cssErrorClass="erro" />
	</tr>
	<tr>
		<td colspan="2"><hr width="100%" /> </td>
	</tr>
	<tr>
		<td><form:label path="login.usuario" cssErrorClass="erro" >Usuario:</form:label></td>
		<td><form:errors path="login.usuario" cssClass="text-info" element="div" /><form:input path="login.usuario" cssErrorClass="erro"/> </td>
	</tr>
	<tr>
		<td><form:label path="login.senha" cssErrorClass="erro">Senha:</form:label></td>
		<td><form:errors path="login.senha" cssClass="text-info" element="div" /><form:password path="login.senha" cssErrorClass="erro"/></td>
	</tr>
	<tr>
		<td colspan="2"><center>
		<input type="submit" class="btn btn-primary" value="Cadastrar">
		<input type="submit" class="btn btn-default" value="Cancelar">
		</center></td>
	</tr>
</table>
</form:form>
</body>
</html>