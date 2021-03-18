package br.gov.mg.bomdestino.servicos.servicoscidadaoservice.model;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.controller.form.SolicitacaoForm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Solicitacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private LocalDate data = LocalDate.now();
	
	@ManyToOne
	private Status status;
	
	@ManyToOne
	private Servico servico;
	
	private String nomeSolicitante;
	private String telefoneSolicitante;
	private String cpfSolicitante;
	private String emailSolicitante;
	private String logradouro;
	private int numero;
	private String cep;
	private String cidade;
	private String estado;
	private int protocolo;
	
	public Solicitacao(SolicitacaoForm form) {
		setCep(form.getCep());
		setNomeSolicitante(form.getNomeSolicitante());
		setTelefoneSolicitante(form.getTelefoneSolicitante());
		setCpfSolicitante(form.getCpfSolicitante());
		setEmailSolicitante(form.getEmailSolicitante());
		setLogradouro(form.getLogradouro());
		setNumero(form.getNumero());
		setCidade(form.getCidade());
		setEstado(form.getEstado());
		setDescricao(form.getDescricao());
		setProtocolo(ThreadLocalRandom.current().nextInt(99999999));
	}
}
