package sjc.fatec.padbi.funcionario.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import sjc.fatec.padbi.ator.model.Ator;

@Entity
@DiscriminatorValue("Funcionario")
public class Funcionario extends Ator{
	
}
