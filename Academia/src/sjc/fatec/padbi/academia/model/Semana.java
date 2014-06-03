package sjc.fatec.padbi.academia.model;

public enum Semana {
	SEGUNDA("Segunda"), TERCA("Terça"), QUARTA("Quarta"), QUINTA("Quinta"), SEXTA(
			"Sexta"), SABADO("Sábado");

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
