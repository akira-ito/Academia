package sjc.fatec.padbi.academia.model;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.TemporalType.DATE;
import static org.hibernate.annotations.FetchMode.SUBSELECT;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import sjc.fatec.padbi.aluno.model.Aluno;

@Entity
public class Objetivo {
	@Id
	@GeneratedValue
	private Long id;
	@NotEmpty(message = "{NotEmpty.objetivo.nome}")
	private String nome;
	@Temporal(DATE)
	private Date inicio;
	@NotEmpty(message = "{NotEmpty.objetivo.descricao}")
	@Length(min = 10, message = "{Min.objetivo.descricao}")
	@Lob
	private String descricao;
	@OneToMany(mappedBy = "objetivo", fetch = EAGER)
	@Fetch(SUBSELECT)
	private List<Perfil> perfils;
	@ManyToOne
	@JoinColumn(name = "idAluno")
	private Aluno aluno;
	@OneToMany(mappedBy = "objetivo", fetch = EAGER)
	@Fetch(SUBSELECT)
	private List<Serie> series;

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

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public List<Perfil> getPerfils() {
		return perfils;
	}

	public void setPerfils(List<Perfil> perfils) {
		this.perfils = perfils;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Serie> getSeries() {
		return series;
	}

	public void setSeries(List<Serie> series) {
		this.series = series;
	}

}
