package sjc.fatec.padbi.ator.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class Login {
	@NotNull(message = "{NotNull.login.usuario}") 
	@Size(min = 5, message = "{Size.login.usuario}")
	private String usuario;
	@NotNull(message = "{NotNull.login.senha}") 
	@Size(min = 5, message = "{Size.login.senha}")
	private String senha;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
