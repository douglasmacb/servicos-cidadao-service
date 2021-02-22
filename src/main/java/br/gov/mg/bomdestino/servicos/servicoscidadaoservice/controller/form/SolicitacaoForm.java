package br.gov.mg.bomdestino.servicos.servicoscidadaoservice.controller.form;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.model.Endereco;
import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.model.Servico;
import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.model.Solicitacao;
import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.model.Solicitante;
import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.model.Status;
import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.repository.EnderecoRepository;
import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.repository.ServicoRepository;
import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.repository.SolicitanteRepository;
import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.repository.StatusRepository;

public class SolicitacaoForm {

	private String descricao;

	private Long solicitanteId;

	@NotNull
	private Long servicoId;

	@NotNull @NotEmpty
	private String logradouro;

	@NotNull
	private int numero;

	private String complemento;

	@NotNull @NotEmpty
	private String cep;

	@NotNull @NotEmpty
	private String cidade;

	@NotNull @NotEmpty
	private String estado;

	public Solicitacao converter(SolicitanteRepository solicitanteRepository, ServicoRepository servicoRepository,
			StatusRepository statusSolicitacaoRepository, EnderecoRepository enderecoRepository) {
		Optional<Solicitante> solicitante = solicitanteRepository.findById(solicitanteId);
		Optional<Servico> servico = servicoRepository.findById(servicoId);
		Optional<Status> status = statusSolicitacaoRepository.findById(1l);
		Endereco endereco = new Endereco(logradouro, numero, complemento, cep, cidade, estado);
		
		enderecoRepository.save(endereco);

		return new Solicitacao(descricao, status.isPresent() ? status.get() : null,
				servico.isPresent() ? servico.get() : null, endereco,
				solicitante.isPresent() ? solicitante.get() : null);
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the solicitanteId
	 */
	public Long getSolicitanteId() {
		return solicitanteId;
	}

	/**
	 * @param solicitanteId the solicitanteId to set
	 */
	public void setSolicitanteId(Long solicitanteId) {
		this.solicitanteId = solicitanteId;
	}

	/**
	 * @return the servicoId
	 */
	public Long getServicoId() {
		return servicoId;
	}

	/**
	 * @param servicoId the servicoId to set
	 */
	public void setServicoId(Long servicoId) {
		this.servicoId = servicoId;
	}

	/**
	 * @return the logradouro
	 */
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * @param logradouro the logradouro to set
	 */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return the complemento
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * @param complemento the complemento to set
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/**
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * @param cep the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

}
