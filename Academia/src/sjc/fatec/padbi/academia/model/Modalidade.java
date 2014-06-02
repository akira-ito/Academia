package sjc.fatec.padbi.academia.model;

import static javax.persistence.InheritanceType.TABLE_PER_CLASS;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = TABLE_PER_CLASS)
public class Modalidade {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	private String nome;
	private Integer intervaloPausa;
	@OneToOne(mappedBy = "modalidade")
	private Serie serie;
	@OneToMany(mappedBy = "modalidade")
	private List<TrabalhoModalidade> trabalhos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIntervaloPausa() {
		return intervaloPausa;
	}

	public void setIntervaloPausa(Integer intervaloPausa) {
		this.intervaloPausa = intervaloPausa;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public List<TrabalhoModalidade> getTrabalhos() {
		return trabalhos;
	}

	public void setTrabalhos(List<TrabalhoModalidade> trabalhos) {
		this.trabalhos = trabalhos;
	}

}
