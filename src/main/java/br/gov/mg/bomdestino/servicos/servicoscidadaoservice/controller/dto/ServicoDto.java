package br.gov.mg.bomdestino.servicos.servicoscidadaoservice.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.model.Servico;

public class ServicoDto {

	private Long id;
	private String nome;
	
	public ServicoDto(Servico servico) {
		this.setId(servico.getId());
		this.setNome(servico.getNome());
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

	public static List<ServicoDto> converter(List<Servico> servicos) {
		return servicos.stream().map(ServicoDto::new).collect(Collectors.toList());
	}

}
