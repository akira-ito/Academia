package sjc.fatec.padbi.academia.model;

public enum Semana {
	SEGUNDA("Segunda"), TERCA("Ter�a"), QUARTA("Quarta"), QUINTA("Quinta"), SEXTA(
			"Sexta"), SABADO("S�bado");

	private String semana;

	Semana(String semana) {
		this.semana = semana;
	}

	public String getSemana() {
		return semana;
	}

	public void setSemana(String semana) {
		this.semana = semana;
	}

}
