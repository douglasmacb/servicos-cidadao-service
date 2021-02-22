package br.gov.mg.bomdestino.servicos.servicoscidadaoservice.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.controller.dto.SolicitacaoDto;
import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.controller.form.SolicitacaoForm;
import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.model.Solicitacao;
import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.model.Status;
import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.repository.EnderecoRepository;
import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.repository.ServicoRepository;
import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.repository.SolicitacaoRepository;
import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.repository.SolicitanteRepository;
import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.repository.StatusRepository;

@RestController
@RequestMapping("/solicitacao")
public class SolicitacaoController {
	
	@Autowired
	private SolicitacaoRepository solicitacaoRepository;
	
	@Autowired
	private SolicitanteRepository solicitanteRepository;
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	@Autowired
	private StatusRepository statusRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@GetMapping
	public List<SolicitacaoDto> lista() {
		List<Solicitacao> solicitacoes = solicitacaoRepository.findAll();
		return SolicitacaoDto.converter(solicitacoes);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<SolicitacaoDto> buscar(@PathVariable Long id) {
		Optional<Solicitacao> solicitacao = solicitacaoRepository.findById(id);
		if(solicitacao.isPresent()) {
			return ResponseEntity.ok().body(new SolicitacaoDto(solicitacao.get()));
		}
		return ResponseEntity.accepted().build();
	}
	
	@GetMapping("/status/{id}")
	public List<SolicitacaoDto> buscarPorStatus(@PathVariable Long id) {
		List<Solicitacao> solicitacoes = solicitacaoRepository.findByStatus_Id(id);
		return SolicitacaoDto.converter(solicitacoes);
	}
	
	@GetMapping("/servico/categoria/{id}")
	public List<SolicitacaoDto> buscarPorCategoria(@PathVariable Long id) {
		List<Solicitacao> solicitacoes = solicitacaoRepository.findByServico_Categoria_Id(id);
		return SolicitacaoDto.converter(solicitacoes);
	}
	
	@GetMapping("/servico/{id}")
	public List<SolicitacaoDto> buscarPorServico(@PathVariable Long id) {
		List<Solicitacao> solicitacoes = solicitacaoRepository.findByServico_Id(id);
		return SolicitacaoDto.converter(solicitacoes);
	}
	
	@PatchMapping("{id}/status/{idStatus}")
	public ResponseEntity<SolicitacaoDto> alterarStatus(@PathVariable Long id, @PathVariable Long idStatus) {
		try {
			Solicitacao solicitacao = solicitacaoRepository.getOne(id);
			Optional<Status> status = statusRepository.findById(idStatus);
			
			if(solicitacao != null && status.isPresent()) {
				solicitacao.setStatus(status.get());
				solicitacaoRepository.save(solicitacao);
				return ResponseEntity.ok().body(new SolicitacaoDto(solicitacao));
			} 
			
		} catch(EntityNotFoundException e) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.badRequest().build();
	}
	
	@PostMapping
	public ResponseEntity<SolicitacaoDto> cadastrar(@RequestBody @Valid SolicitacaoForm form, UriComponentsBuilder uriBuilder) {
		Solicitacao solicitacao = form.converter(solicitanteRepository, servicoRepository, statusRepository, enderecoRepository);
		solicitacaoRepository.save(solicitacao);
		URI uri = uriBuilder.path("/solicitacao/{id}").buildAndExpand(solicitacao.getId()).toUri();
		return ResponseEntity.created(uri).body(new SolicitacaoDto(solicitacao));
	}
	
	
	
}
