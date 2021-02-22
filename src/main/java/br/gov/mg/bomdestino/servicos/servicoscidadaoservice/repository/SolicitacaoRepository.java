package br.gov.mg.bomdestino.servicos.servicoscidadaoservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.model.Solicitacao;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {
	List<Solicitacao> findByStatus_Id(Long id);
	List<Solicitacao> findByServico_Categoria_Id(Long id);
	List<Solicitacao> findByServico_Id(Long id);
}


