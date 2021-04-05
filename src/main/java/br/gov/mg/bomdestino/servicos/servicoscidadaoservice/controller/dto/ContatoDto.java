package br.gov.mg.bomdestino.servicos.servicoscidadaoservice.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.model.Contato;

public class ContatoDto {

	private String name;
	private String phone;
	
	public ContatoDto(Contato contato) {
		this.setName(contato.getName());
		this.setPhone(contato.getPhone());
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param set the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param set the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public static List<ContatoDto> converter(List<Contato> servicos) {
		return servicos.stream().map(ContatoDto::new).collect(Collectors.toList());
	}

}
