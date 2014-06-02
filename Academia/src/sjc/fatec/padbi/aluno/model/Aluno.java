package sjc.fatec.padbi.aluno.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import sjc.fatec.padbi.academia.model.Objetivo;
import sjc.fatec.padbi.ator.model.Ator;

@Entity
@DiscriminatorValue("Aluno")
public class Aluno extends Ator{
	@OneToMany(mappedBy = "aluno")
	private List<Objetivo> objetivos;

}
