package br.univille.cofrinho.domains.priority;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "prioridade", schema = "main")
public class PrioridadeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id")
	protected UUID id;

	@Column(name = "nome")
	protected String nome;

	@Column(name = "grandeza")
	protected int grandeza;

	@Column(name = "criado_em")
	@CreationTimestamp
	private Date criadoEm;

	@Column(name = "atualizado_em")
	@UpdateTimestamp
	private Date atualizadoEm;

}
