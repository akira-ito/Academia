package sjc.fatec.padbi.academia.model;

import javax.persistence.Entity;

@Entity
public class Perna extends Modalidade{

	@Override
	public String getTipoModalidade() {
		return "Perna";
	}

}
