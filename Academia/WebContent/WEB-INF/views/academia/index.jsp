<%@page import="sjc.fatec.padbi.ator.model.Login"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="sp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Musculação Impacto</title>

<link href="./academia/academia.css" rel="stylesheet" media="screen">
<script src="./academia/jquery-2.js"></script>


</head>
<body style="height: 100%">
	<table width="100%" height="100%">
		<tr class="trTopo">
			<td></td>
			<td width="240px" class="tdMenu"><div class="logo">
								<a href="./"><img alt="Logo" src="academia/imagem/logo.png" width="200px"
									height="200px"></a>
							</div>
			</td>
			<td width="600px" height="80px"><table width="100%">
					<tr>
						<td colspan="2" height="20px"><div class="mensagem"><sp:message code="${param.msg}" /> </div> </td>
					</tr>
					<tr>
						<td><div class="">
								<ul class="nav nav-pills ">
									<li><a href="#">Sobre Academia</a></li>
									<li><a href="#">Novidade</a></li>
									<li><a href="#">Localização & Contato</a></li>
								</ul>
							</div></td>
					</tr>
				</table></td>
			<td></td>
		</tr>
		<tr height="100%">
			<td></td>
			<td height="90px" class="tdMenu" valign="top">
				<table width="100%">
					<tr>
						<td height="95px;"></td>
					</tr>
					<tr>
						<td class="tdMenu">
							<% if(session.getAttribute("atorLogado") == null){ %>
								<% String login = new String("/login"); %>
								<jsp:include page="<%= login%>" />
							<%}else{ %>
								<% String logado = new String("/logado"); %>
								<jsp:include page="<%= logado%>" />
							<%} %>
						</td>
					</tr>
				</table>
			</td>
			<td valign="top">
				<table width="100%">
					<tr>
						<td width="20px" height="20px"></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<% String pagina = request.getParameter("pagina");
							if (pagina == null || pagina.isEmpty())
								pagina = "home.jsp";
							else
								pagina = "/"+pagina;
							%>
							<jsp:include page="<%=pagina %>"></jsp:include>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr class="trRodape">
			<td></td>
			<td colspan="2" height="50px"><center>Todos os direitos autorais: MegaSoft - 2014 </center></td>
			<td></td>
		</tr>
	</table>

</body>
</html>