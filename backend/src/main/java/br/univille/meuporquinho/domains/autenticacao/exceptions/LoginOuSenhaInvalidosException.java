package br.univille.meuporquinho.domains.autenticacao.exceptions;

import br.univille.meuporquinho.exceptions.RegraDeNegocioException;
import org.springframework.http.HttpStatus;

public class LoginOuSenhaInvalidosException extends RegraDeNegocioException {

	public LoginOuSenhaInvalidosException() {
		super("Login, email ou senha inválidos", HttpStatus.UNAUTHORIZED);
	}

}
