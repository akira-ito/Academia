package sjc.fatec.padbi.academia.model;

import javax.persistence.Entity;

@Entity
public class Peito extends Modalidade{

	@Override
	public String getTipoModalidade() {
		return "Peito";
	}

}
