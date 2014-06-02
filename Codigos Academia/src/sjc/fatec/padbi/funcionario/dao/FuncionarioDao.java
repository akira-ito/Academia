package sjc.fatec.padbi.funcionario.dao;

import java.io.Serializable;

import sjc.fatec.padbi.funcionario.model.Funcionario;

public interface FuncionarioDao {
	public Serializable cadastrar(Funcionario funcionario);
}
