package sjc.fatec.padbi.ator.model;


public enum Sexo {
	MASCULINO("Masculino"), FEMININO("Feminino");
	
	private String nome;
	
	Sexo(String nome){
		this.nome=nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
}
