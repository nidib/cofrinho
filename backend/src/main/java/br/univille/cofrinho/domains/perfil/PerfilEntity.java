package br.univille.cofrinho.domains.perfil;

import br.univille.cofrinho.domains.usuario.UsuarioEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "perfil", schema = "main")
public class PerfilEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id")
	private UUID id;

	@Column(name = "nome_completo")
	private String nomeCompleto;

	@Column(name = "data_de_nascimento")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataDeNascimento;

	@Column(name = "apelido")
	private String apelido;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
	private UsuarioEntity usuario;

	@CreationTimestamp
	@Column(name = "criado_em")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime criadoEm;

	@UpdateTimestamp
	@Column(name = "atualizado_em")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime atualizadoEm;

	public UUID getId() {
		return id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public String getApelido() {
		return apelido;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

}
