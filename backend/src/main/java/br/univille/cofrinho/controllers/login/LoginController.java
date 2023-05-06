package br.univille.cofrinho.controllers.login;

import br.univille.cofrinho.controllers.login.dtos.LoginResDTO;
import br.univille.cofrinho.domains.autenticacao.LoginService;
import br.univille.cofrinho.controllers.login.dtos.LoginReqDTO;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/login")
public class LoginController {

	private final LoginService loginService;

	@Autowired
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}

	@PostMapping
	@Operation(description = "Realiza login, devolvendo o JWT")
	public ResponseEntity<LoginResDTO> login(@Valid @RequestBody LoginReqDTO loginInfo) {
		final String token = this.loginService.obterTokenDaSessao(loginInfo.login(), loginInfo.senha());

		return new ResponseEntity<>(
			new LoginResDTO(token),
			HttpStatus.OK
		);
	}

}
