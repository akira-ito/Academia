<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="sp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form:form commandName="login" method="post" action="logar" >
	<table class="table">
		<c:if test="${loginInvalido}">
			<tr>
				<td colspan="2">
	 				<span class="erro"><sp:message code="loginSenhaInvalido" /></span>
				</td>
			</tr>
	 	</c:if>
		<tr>
			<td><form:label path="usuario" cssErrorClass="erro">Ususario:</form:label><form:input path="usuario" cssErrorClass="erro"/><form:errors path="usuario" cssClass="text-warning" element="div"/></td>
		</tr>
		<tr>
			<td><form:label path="senha" cssErrorClass="erro">Senha:</form:label><form:password path="senha" cssErrorClass="erro"/><form:errors path="senha" cssClass="text-warning" element="div"/></td>
		</tr>
		<tr>
			<td colspan="2" ><center>
			<input type="submit" class="btn btn-primary" value="Logar">
			</center></td>
		</tr>
	</table>
</form:form>