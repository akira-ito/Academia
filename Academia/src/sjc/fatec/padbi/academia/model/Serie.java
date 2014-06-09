package sjc.fatec.padbi.academia.model;

import static javax.persistence.EnumType.STRING;
import static org.hibernate.annotations.FetchMode.SUBSELECT;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.Valid;

import org.hibernate.annotations.Fetch;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Serie {
	@Id
	@GeneratedValue
	private Long id;
	@ElementCollection(fetch = FetchType.EAGER)
	@Enumerated(STRING)
	@Fetch(SUBSELECT)
	@CollectionTable(name = "DiaSemana", joinColumns = @JoinColumn(name = "idSerie"))
	@NotEmpty(message = "{NotEmpty.serie.semanas}")
	private List<Semana> semanas;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idModalidade")
	@Valid
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
