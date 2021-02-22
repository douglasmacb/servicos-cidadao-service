package br.gov.mg.bomdestino.servicos.servicoscidadaoservice.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.model.Solicitante;

public class SolicitanteDto {
	private Long id;
	private String nome;
	private String telefone;
	private String cpf;

	public SolicitanteDto(Solicitante solicitante) {
		super();
		this.id = solicitante.getId();
		this.nome = solicitante.getNome();
		this.telefone = solicitante.getTelefone();
		this.cpf = solicitante.getCpf();
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
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public static List<SolicitanteDto> converter(List<Solicitante> solicitantes) {
		return solicitantes.stream().map(SolicitanteDto::new).collect(Collectors.toList());
	}
}
