package sjc.fatec.padbi.academia.model;

import static javax.persistence.TemporalType.TIME;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

import sjc.fatec.padbi.aluno.model.Aluno;

@Entity
public class Objetivo {
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	@Temporal(TIME)
	private Date inicio;
	@OneToMany(mappedBy = "objetivo")
	private List<Perfil> perfils;
	@ManyToOne
	@JoinColumn(name = "idAluno")
	private Aluno aluno;
	
	
}
