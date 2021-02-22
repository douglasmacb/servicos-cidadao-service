package br.gov.mg.bomdestino.servicos.servicoscidadaoservice.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.controller.dto.SolicitanteDto;
import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.controller.form.SolicitanteForm;
import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.model.Solicitante;
import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.repository.SolicitanteRepository;

@RestController
@RequestMapping("/solicitante")
public class SolicitanteController {
	
	@Autowired
	private SolicitanteRepository solicitanteRepository;

	@GetMapping
	public List<SolicitanteDto> lista() {
		List<Solicitante> solicitantes = solicitanteRepository.findAll();
		return SolicitanteDto.converter(solicitantes);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<SolicitanteDto> buscar(@PathVariable Long id) {
		Optional<Solicitante> solicitante = solicitanteRepository.findById(id);
		if(solicitante.isPresent()) {
			return ResponseEntity.ok().body(new SolicitanteDto(solicitante.get()));
		}
		return ResponseEntity.accepted().build();
	}
	
	@PostMapping
	public ResponseEntity<SolicitanteDto> cadastrar(@RequestBody @Valid SolicitanteForm form, UriComponentsBuilder uriBuilder) {
		Solicitante solicitante = form.converter();
		solicitanteRepository.save(solicitante);
		URI uri = uriBuilder.path("/solicitante/{id}").buildAndExpand(solicitante.getId()).toUri();
		return ResponseEntity.created(uri).body(new SolicitanteDto(solicitante));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Long> deletar(@PathVariable Long id) {
		Optional<Solicitante> solicitante = solicitanteRepository.findById(id);
		if(solicitante.isPresent()) {
			solicitanteRepository.delete(solicitante.get());
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.noContent().build();
	}
}
