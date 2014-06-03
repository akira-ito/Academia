package sjc.fatec.padbi.academia.model;

import javax.persistence.Entity;

@Entity
public class Ombro extends Modalidade{

	@Override
	public String getTipoModalidade() {
		return "Ombro";
	}

}
