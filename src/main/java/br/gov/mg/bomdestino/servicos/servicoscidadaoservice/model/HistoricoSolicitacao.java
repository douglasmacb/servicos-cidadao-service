package br.gov.mg.bomdestino.servicos.servicoscidadaoservice.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class HistoricoSolicitacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Solicitacao solicitacao;
	
	private String responsavel;
	
	private String status;
	
	private LocalDateTime data;
	
	public HistoricoSolicitacao() {}

	public HistoricoSolicitacao(Solicitacao solicitacao, String responsavel, String status) {
		super();
		this.solicitacao = solicitacao;
		this.responsavel = responsavel;
		this.status = status;
		this.data = LocalDateTime.now();
	}
	
}
