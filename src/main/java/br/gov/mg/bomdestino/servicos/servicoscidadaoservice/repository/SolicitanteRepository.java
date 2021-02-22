package br.gov.mg.bomdestino.servicos.servicoscidadaoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.model.Solicitante;

public interface SolicitanteRepository extends JpaRepository<Solicitante, Long> {

}
