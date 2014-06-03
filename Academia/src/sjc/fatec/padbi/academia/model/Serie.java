package sjc.fatec.padbi.academia.model;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Serie {
	@Id
	@GeneratedValue
	private Long id;
	@ElementCollection
	@Enumerated(STRING)
	@CollectionTable(name = "DiaSemana", joinColumns = @JoinColumn(name = "idSerie"))
	private List<Semana> semanas;
	@OneToOne
	@JoinColumn(name = "idModalidade")
	private Modalidade modalidade;
	@ManyToOne
	@JoinColumn(name = "idObjetivo")
	private Objetivo objetivo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Semana> getSemanas() {
		return semanas;
	}

	public void setSemanas(List<Semana> semanas) {
		this.semanas = semanas;
	}

	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

	public Objetivo getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(Objetivo objetivo) {
		this.objetivo = objetivo;
	}

}
