package sjc.fatec.padbi.aluno.dao;

import java.io.Serializable;
import java.util.List;

import sjc.fatec.padbi.aluno.model.Aluno;

public interface AlunoDao {
	public Serializable cadastrar(Aluno aluno);
	public List<Aluno> listar();
	public Aluno buscar(Long id);
	public Aluno editar(Aluno aluno);
}
