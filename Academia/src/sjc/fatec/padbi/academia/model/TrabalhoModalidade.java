package sjc.fatec.padbi.academia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class TrabalhoModalidade {
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	@ManyToOne
	@JoinColumn(name = "idModalidade")
	private Modalidade modalidade;
}
