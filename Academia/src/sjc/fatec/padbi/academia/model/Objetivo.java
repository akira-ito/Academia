package sjc.fatec.padbi.academia.model;

import static javax.persistence.TemporalType.TIME;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

import org.hibernate.validator.constraints.NotEmpty;

import sjc.fatec.padbi.aluno.model.Aluno;

@Entity
public class Objetivo {
	@Id
	@GeneratedValue
	private Long id;
	@NotEmpty(message="{NotEmpty.objetivo.nome}")
	private String nome;
	@Temporal(TIME)
	private Date inicio;
	@NotEmpty(message = "{NotEmpty.objetivo.descricao}")
	@Lob
	private String descricao;
	@OneToMany(mappedBy = "objetivo")
	private List<Perfil> perfils;
	@ManyToOne
	@JoinColumn(name = "idAluno")
	private Aluno aluno;

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

}
