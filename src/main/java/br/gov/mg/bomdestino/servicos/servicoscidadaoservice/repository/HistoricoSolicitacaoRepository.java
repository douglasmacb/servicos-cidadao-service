package br.gov.mg.bomdestino.servicos.servicoscidadaoservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.model.HistoricoSolicitacao;

public interface HistoricoSolicitacaoRepository extends JpaRepository<HistoricoSolicitacao, Long> {

	List<HistoricoSolicitacao> findBySolicitacao_Id(Long id);
}
