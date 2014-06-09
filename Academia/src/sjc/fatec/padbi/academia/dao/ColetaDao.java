package sjc.fatec.padbi.academia.dao;

import java.io.Serializable;
import java.util.List;

import sjc.fatec.padbi.academia.model.Perfil;

public interface ColetaDao {
	public Serializable cadastrar(Perfil perfil);
	public List<Perfil> listar(Long idAluno);
}
