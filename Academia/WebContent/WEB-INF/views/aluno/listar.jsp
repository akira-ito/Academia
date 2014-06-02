<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="sp"%>
<table width="100%">
	<tr>
		<td valign="middle" align="center"><form action="buscarAluno">
				<input type="hidden" name="pagina" value="${param.pagina }">
				<table>
					<tr>
						<td>Nome:</td>
						<td valign="bottom"><input type="text" name="nome"
							autofocus="autofocus"></td>
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
						<c:choose>
							<c:when test="${not avaliar }">
								<th>Alterar</th>
								<th>Excluir</th>
							</c:when>
							<c:otherwise>
								<th>Avaliar</th>
							</c:otherwise>
						</c:choose>

					</tr>
				</thead>
				<tbody>
					<c:if test="${empty alunos }">
						<tr>
							<td colspan="4" align="center"><i style="text-align: center"><sp:message
										code="alunoNaoEncontrado" /> </i></td>
						</tr>
					</c:if>
					<c:forEach items="${alunos }" var="aluno">
						<tr>
							<td>${aluno.nome }</td>
							<td>${aluno.sexo.nome }</td>

							<c:choose>
								<c:when test="${not avaliar }">
									<td><a href="?pagina=editaAluno&id=${aluno.id }">Editar</a>
									</td>
									<td><a href="#"
										onclick="confirm('Deseja realmente excluir?')?location='./excluirAluno?id=${aluno.id}':''">Excluir</a></td>
								</c:when>
								<c:otherwise>
									<td><a href="./?id=${aluno.id }&pagina=avaliarAluno/1">Avaliar</a></td>
								</c:otherwise>
							</c:choose>
						<tr>
					</c:forEach>
				</tbody>
			</table></td>
	</tr>
</table>