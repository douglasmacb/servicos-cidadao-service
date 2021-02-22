package br.gov.mg.bomdestino.servicos.servicoscidadaoservice.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.model.Servico;

public class ServicoForm {

	@NotNull @NotEmpty
	private String nome;
	
	public Servico converter() {
		return new Servico(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
