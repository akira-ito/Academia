<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="editarAluno" commandName="aluno"  >
<table width="100%">
	<form:hidden path="id"/>
	<tr>
		<td><form:label path="nome" cssErrorClass="erro" >Nome:</form:label></td>
		<td><form:errors path="nome" cssClass="text-warning" element="div"/><form:input path="nome" cssErrorClass="erro" /></td>
	</tr>
	<tr>
		<td><form:label path="idade" cssErrorClass="erro" >Idade:</form:label></td>
		<td><form:errors path="idade" cssClass="text-warning" element="div" /><form:input path="idade" cssErrorClass="erro"/> </td>
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
		<td><form:errors path="login.usuario" cssClass="text-warning" element="div" /><form:input path="login.usuario" cssErrorClass="erro"/> </td>
	</tr>
	<tr>
		<td><form:label path="login.senha" cssErrorClass="erro">Senha:</form:label></td>
		<td><form:errors path="login.senha" cssClass="text-warning" element="div" /><form:password path="login.senha" cssErrorClass="erro"/></td>
	</tr>
	<tr>
		<td colspan="2"><center>
		<input type="submit" class="btn btn-primary" value="Editar">
		<input type="submit" class="btn btn-default" value="Cancelar">
		</center></td>
	</tr>
</table>
</form:form>