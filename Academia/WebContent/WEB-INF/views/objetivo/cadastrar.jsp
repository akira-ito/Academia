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
${param }
<form:form action="./cadastrarObjetivo" commandName="objetivo" >
	<table width="100%">
		<tr>
			<td><form:label path="nome" cssErrorClass="erro" >Nome: </form:label></td>
			<td><form:errors path="nome" cssClass="text-warning" element="div" /><form:input cssErrorClass="erro" path="nome"/></td>
		</tr>
		<tr>
			<td><form:label path="descricao" cssErrorClass="erro" >Descrição: </form:label> </td>
			<td><form:errors path="descricao" cssClass="text-warning" element="div" /><form:textarea cssErrorClass="erro" path="descricao"/> </td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="Criar" class="btn btn-primary">&emsp;&emsp; <input type="button" value="Cancelar" class="btn"> </td>
		</tr>
	</table>
</form:form>
</body>
</html>