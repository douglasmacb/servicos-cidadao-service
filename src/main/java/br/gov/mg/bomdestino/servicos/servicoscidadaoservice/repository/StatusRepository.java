package br.gov.mg.bomdestino.servicos.servicoscidadaoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.model.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {

}
