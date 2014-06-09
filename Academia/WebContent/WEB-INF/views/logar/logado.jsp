<%@page import="sjc.fatec.padbi.funcionario.model.Funcionario"%>
<table width="100%" class="table">
	<tr>
		<td>Bem vindo(a):&emsp;&emsp;&emsp;&emsp; <i
			class="text-align:right"><a href="sair">(sair)</a></i>
		<p>&emsp; ${atorLogado.nome}
			<table width="100%" class="table-hover">
				<%
					if (session.getAttribute("atorLogado") instanceof Funcionario) {
				%>
				<tr>
					<td><a href="./?pagina=cadastroAluno"><div>Cadastrar
								Aluno</div> </a></td>
				</tr>
				<tr>
					<td><a href="./?pagina=listarAluno"><div>Listar
								Alunos</div> </a></td>
				</tr>
				<tr>
					<td><a href="./?pagina=avaliarAluno/0"><div>Avaliar
								Aluno</div> </a></td>
				</tr>
				<%
					} else {
				%>
				<tr>
					<td><a href="./?pagina=listarPerfils&id=${atorLogado.id }">Perfils</a></td>
				</tr>
				<tr>
					<td><a href="#">Series</a></td>
				</tr>
				<%
					}
				%>
			</table></td>
	</tr>
</table>