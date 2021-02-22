package br.gov.mg.bomdestino.servicos.servicoscidadaoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
