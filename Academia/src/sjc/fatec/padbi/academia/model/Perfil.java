package sjc.fatec.padbi.academia.model;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

@Entity
public class Perfil{
	@Id
	@GeneratedValue
	private Long id;
	@Temporal(TIMESTAMP)
	private Date dataColeta;
	@Column(precision = 2, scale = 3)
	@NotNull(message="{NotNull.perfil.peso}")
	private Double peso;
	@NotNull(message="{NotNull.perfil.porcGordura}")
	@Range(max = 100, min = 0, message = "{Range.perfil.porcGordura}")
	private Double porcGordura;
	@NotNull(message="{NotNull.perfil.massCorporal}")
	@Range(max = 100, min = 0, message = "{Range.perfil.massCorporal}")
	private Double massCorporal;
	@ManyToOne
	@JoinColumn(name = "idObjetivo")
	private Objetivo objetivo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataColeta() {
		return dataColeta;
	}

	public void setDataColeta(Date dataColeta) {
		this.dataColeta = dataColeta;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getPorcGordura() {
		return porcGordura;
	}

	public void setPorcGordura(Double porcGordura) {
		this.porcGordura = porcGordura;
	}

	public Double getMassCorporal() {
		return massCorporal;
	}

	public void setMassCorporal(Double massCorporal) {
		this.massCorporal = massCorporal;
	}

	public Objetivo getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(Objetivo objetivo) {
		this.objetivo = objetivo;
	}

}
