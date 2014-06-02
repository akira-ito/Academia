<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table width="100%">
		<tr>
			<td valign="middle" align="center"><form action="buscarAluno">
					<table>
						<tr>
							<td valign="bottom"><input type="text" name="nome" autofocus="autofocus"></td>
							<td valign="top"><input type="submit" value="Buscar"
								class="btn btn-primary"></td>
						</tr>
					</table>
				</form></td>
		</tr>
		<tr>
			<td><table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>Nome</th>
							<th>Sexo</th>
							<th>Alterar</th>
							<th>Excluir</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${alunos }" var="aluno">
							<tr>
								<td>${aluno.nome }</td>
								<td>${aluno.sexo.nome }</td>
								<td><a href="?pagina=editaAluno&id=${aluno.id }">Editar</a>
								</td>
								<td><a href="#"
									onclick="confirm('Deseja realmente excluir?')?location='./excluirAluno?id=${aluno.id}':''">Excluir</a></td>
							<tr>
						</c:forEach>
					</tbody>
				</table></td>
		</tr>
	</table>

</body>
</html>