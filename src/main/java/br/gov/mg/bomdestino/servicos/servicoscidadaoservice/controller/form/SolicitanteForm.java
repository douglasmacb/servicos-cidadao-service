package br.gov.mg.bomdestino.servicos.servicoscidadaoservice.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.model.Solicitante;

public class SolicitanteForm {

	@NotNull @NotEmpty
	private String nome;
	@NotNull @NotEmpty @Length(min = 10)
	private String telefone;
	@NotNull @NotEmpty @Length(min = 11)
	private String cpf;

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

	public Solicitante converter() {
		return new Solicitante(nome, telefone, cpf); 
	}
}
