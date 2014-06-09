<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
