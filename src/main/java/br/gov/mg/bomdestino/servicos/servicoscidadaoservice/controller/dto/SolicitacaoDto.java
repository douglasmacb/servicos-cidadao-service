package br.gov.mg.bomdestino.servicos.servicoscidadaoservice.controller.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.model.Solicitacao;
import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.model.Status;

public class SolicitacaoDto {

	private Long id;
	private String descricao;
	private LocalDate data;
	private Status status;
	
	public SolicitacaoDto(Solicitacao solicitacao) {
		this.setId(solicitacao.getId());
		this.setData(solicitacao.getData());
		this.setDescricao(solicitacao.getDescricao());
		this.setStatus(solicitacao.getStatus());
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
