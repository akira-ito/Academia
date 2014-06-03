package sjc.fatec.padbi.academia.dao;

import java.io.Serializable;
import java.util.List;

import sjc.fatec.padbi.academia.model.Objetivo;

public interface ObjetivoDao {
	public List<Objetivo> buscarPorAluno(Long id);
	public Serializable cadastrar(Objetivo objetivo);
	public Objetivo buscar(Long id);
}
