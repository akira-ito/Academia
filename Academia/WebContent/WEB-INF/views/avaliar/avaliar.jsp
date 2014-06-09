<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table width="100%">
		<tr>
			<td><a href="./?pagina=cadastroColeta">Coletar</a>
				<table class="table table-bordered table-hover">
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
								<td><fmt:formatDate value="${perfil.dataColeta }" pattern="dd/MM/yyyy"/></td>
								<td>${perfil.peso }</td>
								<td>${perfil.porcGordura }</td>
								<td>${perfil.massCorporal }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table></td>
		</tr>
		<tr>
			<td><c:if test="${addSerie}">
			<a href="./?pagina=cadastroSerie">Serie</a>
			</c:if>
				<table class="table table-bordered ">
					<thead>
						<tr>
							<th width="250px" valign="middle">Modalidade</th>
							<th width="55px" valign="middle">Pausa Intervalo</th>
							<th valign="middle">Tipo</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${series }" var="serie">
							<tr>
								<td colspan="3"><table width="100%" class="table table-condensed table-striped">

										<tr>
											<td width="248px">${serie.modalidade.nome}</td>
											<td width="68px">${serie.modalidade.intervaloPausa }</td>
											<td>${serie.modalidade.tipoModalidade }</td>
										</tr>
										<tr>
											<td colspan="3">&mdash; <c:forEach
													items="${serie.semanas}" var="semana">
									${semana.semana }
								</c:forEach>
											</td>
										</tr>
									</table></td>
							</tr>
						</c:forEach>
					</tbody>
				</table></td>
		</tr>
	</table>
</body>
</html>