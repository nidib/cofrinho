package br.univille.cofrinho.domains.usuario;

import br.univille.cofrinho.domains.categoria.CategoriaEntity;
import br.univille.cofrinho.domains.perfil.PerfilEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "usuario", schema = "main")
public class UsuarioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id")
	private UUID id;

	@Column(name = "login")
	private String login;

	@Column(name = "senha")
	private String senha;

	@Column(name = "email")
	private String email;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "perfil_id")
	private PerfilEntity perfil;

	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
	private List<CategoriaEntity> categorias;

	@CreationTimestamp
	@Column(name = "criado_em")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime criadoEm;

	@UpdateTimestamp
	@Column(name = "atualizado_em")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime atualizadoEm;

	public UsuarioEntity() {
	}

	public UsuarioEntity(UUID usuarioId) {
	}

	public UsuarioEntity(String login, String senha, String email, PerfilEntity perfil) {
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.perfil = perfil;
	}

	public UUID getId() {
		return this.id;
	}

	public String getLogin() {
		return this.login;
	}

	public String getEmail() {
		return this.email;
	}

	public String getSenha() {
		return this.senha;
	}

	public PerfilEntity getPerfil() {
		return this.perfil;
	}

	public List<CategoriaEntity> getCategorias() {
		return this.categorias;
	}

}
