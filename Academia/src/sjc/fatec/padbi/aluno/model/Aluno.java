package sjc.fatec.padbi.aluno.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import sjc.fatec.padbi.ator.model.Ator;

@Entity
@DiscriminatorValue("Aluno")
public class Aluno extends Ator{

}
