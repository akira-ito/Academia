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
	<table width="100%">
		<tr>
			<td><a href="#">Coletar</a>
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
								<td>${perfil.dataColeta }</td>
								<td>${perfil.peso }</td>
								<td>${perfil.porcGordura }</td>
								<td>${perfil.massCorporal }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table></td>
		</tr>
		<tr>
			<td>
				<a href="./?pagina=cadastroSerie">Serie</a>
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>Modalidade</th>
							<th>Pausa Intervalo</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${series }" var="serie">
							<c:set var="modalidade" value="serie.modalidade" />
							<tr>
								<td>${modalidade.nome }</td>
								<td>${modalidade.intervaloPausa }</td>
							</tr>
							<tr>
								<td colspan="2">&mdash; <c:forEach items="${serie.semanas}"
										var="semana">
									${semana.semana }
								</c:forEach>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>