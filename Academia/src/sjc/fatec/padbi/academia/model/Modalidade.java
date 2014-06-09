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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;

@Entity
@Inheritance(strategy = TABLE_PER_CLASS)
public class Modalidade {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	@NotEmpty(message = "{NotEmpty.modalidade.nome}")
	private String nome;
	@Range(max = 20, min = 1, message = "{Range.modalidade.intervaloPausa}")
	@NotNull(message = "{NotNull.modalidade.intervaloPausa}")
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
	
	@Transient
	public String getTipoModalidade(){
		return "Modalidade";
	}
	
	@Transient
	public Modalidade clone(Modalidade modalidade){
		modalidade.setIntervaloPausa(this.intervaloPausa);
		modalidade.setNome(this.nome);
		modalidade.setId(this.id);
		modalidade.setSerie(this.serie);
		modalidade.setTrabalhos(this.trabalhos);
		return modalidade;
	}

	@Transient
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((intervaloPausa == null) ? 0 : intervaloPausa.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((serie == null) ? 0 : serie.hashCode());
		result = prime * result
				+ ((trabalhos == null) ? 0 : trabalhos.hashCode());
		return result;
	}

	@Transient
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Modalidade other = (Modalidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (intervaloPausa == null) {
			if (other.intervaloPausa != null)
				return false;
		} else if (!intervaloPausa.equals(other.intervaloPausa))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (serie == null) {
			if (other.serie != null)
				return false;
		} else if (!serie.equals(other.serie))
			return false;
		if (trabalhos == null) {
			if (other.trabalhos != null)
				return false;
		} else if (!trabalhos.equals(other.trabalhos))
			return false;
		return true;
	}

}
