package br.gov.mg.bomdestino.servicos.servicoscidadaoservice.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.controller.dto.ServicoDto;
import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.controller.form.ServicoForm;
import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.model.Servico;
import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.repository.ServicoRepository;

@RestController
@RequestMapping("/servico")
public class ServicoController {
	
	@Autowired
	private ServicoRepository servicoRepository;

	@GetMapping
	@Cacheable(value = "AllServices")
	public List<ServicoDto> lista() {
		List<Servico> servicos = servicoRepository.findAll();
		return ServicoDto.converter(servicos);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ServicoDto> buscar(@PathVariable Long id) {
		Optional<Servico> servico = servicoRepository.findById(id);
		if(servico.isPresent()) {
			return ResponseEntity.ok().body(new ServicoDto(servico.get()));
		}
		return ResponseEntity.accepted().build();
	}
	
	@PostMapping
	public ResponseEntity<ServicoDto> cadastrar(@RequestBody @Valid ServicoForm form, UriComponentsBuilder uriBuilder) {
		Servico servico = form.converter();
		servicoRepository.save(servico);
		URI uri = uriBuilder.path("/servico/{id}").buildAndExpand(servico.getId()).toUri();
		return ResponseEntity.created(uri).body(new ServicoDto(servico));
	}
}
