<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="sp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="./?pagina=cadastroObjetivo">Criar objetivo</a><br/>
	<table width="100%" class="table table-bordered table-hover">
		<thead>
			<tr>
				<th>Data inicio</th>
				<th>Nome</th>
				<th>Descrição</th>
				<th>Escolher</th>
			</tr>
		</thead>
		<tbody>
				<c:if test="${empty objetivos }">
				<tr>
					<td colspan="4"><center><sp:message code="objetivoNaoEncontrado" /></center> </td>
				</tr>
				</c:if>
				<c:forEach items="${objetivos }" var="objetivo">
				<tr>
					 <td><fmt:formatDate value="${objetivo.inicio }" pattern="dd/MM/yyyy"/> </td>
					<td>${objetivo.nome }</td>
					<td>${objetivo.descricao }</td>
					<td><a href="./?id=${objetivo.id }&pagina=avaliarAluno/2">Escolher</a></td>
				</tr>
				</c:forEach>
			</tr>
		</tbody>
	</table>
</body>
</html>