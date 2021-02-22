package br.gov.mg.bomdestino.servicos.servicoscidadaoservice.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Solicitacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private LocalDate data = LocalDate.now();
	
	@ManyToOne
	private Status status;
	
	@ManyToOne
	private Solicitante solicitante;
	
	@ManyToOne
	private Endereco endereco;
	
	@ManyToOne
	private Servico servico;
	
	public Solicitacao() {}

	public Solicitacao(String descricao, Status status, Servico servico, Endereco endereco, Solicitante solicitante) {
		this.descricao = descricao;
		this.solicitante = solicitante;
		this.servico = servico;
		this.setStatus(status);
		this.endereco = endereco;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the data
	 */
	public LocalDate getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(LocalDate data) {
		this.data = data;
	}


	/**
	 * @return the solicitante
	 */
	public Solicitante getSolicitante() {
		return solicitante;
	}

	/**
	 * @param solicitante the solicitante to set
	 */
	public void setSolicitante(Solicitante solicitante) {
		this.solicitante = solicitante;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
