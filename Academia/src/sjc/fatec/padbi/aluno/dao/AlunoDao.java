package sjc.fatec.padbi.aluno.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.MatchMode;

import sjc.fatec.padbi.aluno.model.Aluno;

public interface AlunoDao {
	public Serializable cadastrar(Aluno aluno);
	public List<Aluno> listar();
	public Aluno buscar(Long id);
	public Aluno editar(Aluno aluno);
	public void excluir(Long id);
	public List<Aluno> buscarPorNome(String nome, MatchMode mode);
}
