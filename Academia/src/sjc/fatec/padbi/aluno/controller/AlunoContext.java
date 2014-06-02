package sjc.fatec.padbi.aluno.controller;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import sjc.fatec.padbi.aluno.model.Aluno;

@Scope("prototype")
@Component
public class AlunoContext {
	private List<Aluno> alunosBuscado;

	public List<Aluno> getAlunosBuscado() {
		return alunosBuscado;
	}

	public void setAlunosBuscado(List<Aluno> alunosBuscado) {
		this.alunosBuscado = alunosBuscado;
	}
	
}
