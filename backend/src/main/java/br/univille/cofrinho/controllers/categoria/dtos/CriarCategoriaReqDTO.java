package br.univille.cofrinho.controllers.categoria.dtos;

import br.univille.cofrinho.domains.categoria.TipoCategoriaEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CriarCategoriaReqDTO(
	@NotNull(message = "titulo é obrigatório")
	@NotBlank(message = "titulo é obrigatório")
	String titulo,
	@NotNull(message = "tipo é obrigatório")
	@NotBlank(message = "tipo é obrigatório")
	TipoCategoriaEnum tipo
) {}
