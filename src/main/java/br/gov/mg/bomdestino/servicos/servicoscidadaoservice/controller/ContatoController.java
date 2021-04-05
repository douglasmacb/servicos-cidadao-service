package br.gov.mg.bomdestino.servicos.servicoscidadaoservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.controller.dto.ContatoDto;
import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.model.Contato;
import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.repository.ContatoRepository;

@RestController
@RequestMapping("/contatos")
@CrossOrigin
public class ContatoController {

	@Autowired
	private ContatoRepository contatoRepository;
	
	@GetMapping()
	public List<ContatoDto> buscar() {
		List<Contato> contatos = contatoRepository.findAll();
		return ContatoDto.converter(contatos);
	}
}
