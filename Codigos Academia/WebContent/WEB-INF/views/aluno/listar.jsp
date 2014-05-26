<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table class="table table-bordered table-hover">
	<thead>
	<tr>
		<th>Nome</th>
		<th>Sexo</th>
		<th>Alterar</th>
		<th>Excluir</th>
	</tr></thead>
	<tbody><c:forEach items="${alunos }" var="aluno">
		<tr>
			<td>${aluno.nome }</td>
			<td>${aluno.sexo.nome }</td>
			<td><a href="?pagina=editaAluno&id=${aluno.id }">Editar</a> </td>
			<td><a  onclick="aaa(${aluno.id });" >Excluir</a></td>
		
		<tr>
	</c:forEach></tbody>
</table>
</body>
</html>
<script>
function aaa(id){
	alert("plll");	
	window.location="?pagina=editaAluno&id="id;
	return;
}
$(document).ready(function(){
// 	alert("KK");
});
</script>