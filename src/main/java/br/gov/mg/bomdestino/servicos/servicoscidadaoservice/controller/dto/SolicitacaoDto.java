package br.gov.mg.bomdestino.servicos.servicoscidadaoservice.controller.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.model.Solicitacao;

public class SolicitacaoDto {

	private Long id;
	private String descricao;
	private LocalDate data;
	private String status;
	private String servico;
	private int protocolo;

	public SolicitacaoDto(Solicitacao solicitacao) {
		setId(solicitacao.getId());
		setData(solicitacao.getData());
		setDescricao(solicitacao.getDescricao());
		setStatus(solicitacao.getStatus().getNome());
		setProtocolo(solicitacao.getProtocolo());
		setServico(solicitacao.getServico().getNome());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static List<SolicitacaoDto> converter(List<Solicitacao> solicitacoes) {
		return solicitacoes.stream().map(SolicitacaoDto::new).collect(Collectors.toList());
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(int protocolo) {
		this.protocolo = protocolo;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

}
