package br.gov.mg.bomdestino.servicos.servicoscidadaoservice.controller.form;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.model.Servico;
import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.model.Solicitacao;
import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.model.Status;
import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.repository.ServicoRepository;
import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.repository.StatusRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SolicitacaoForm {

	@NotNull @NotEmpty
	private String nomeSolicitante;
	@NotNull @NotEmpty
	private String telefoneSolicitante;
	@NotNull @NotEmpty
	private String cpfSolicitante;
	@NotNull @NotEmpty
	private String emailSolicitante;

	private Long servicoId;

	@NotNull @NotEmpty
	private String logradouro;

	@NotNull
	private int numero;

	@NotNull @NotEmpty
	private String cep;

	@NotNull @NotEmpty
	private String cidade;

	@NotNull @NotEmpty	
	private String estado;
	
	private String descricao;

	public Solicitacao converter(ServicoRepository servicoRepository, StatusRepository statusSolicitacaoRepository) {
		Optional<Servico> servico = servicoRepository.findById(servicoId);
		Optional<Status> status = statusSolicitacaoRepository.findById(1l);
		if(servico.isPresent() && status.isPresent()) {
			Solicitacao solicitacao = new Solicitacao(this);
			solicitacao.setServico(servico.get());
			solicitacao.setStatus(status.get());
			return solicitacao;
		}
		return null;
	}

}
