package br.gov.mg.bomdestino.servicos.servicoscidadaoservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.model.Status;
import br.gov.mg.bomdestino.servicos.servicoscidadaoservice.repository.StatusRepository;

@RestController
@RequestMapping("/status")
@CrossOrigin
public class StatusController {

	@Autowired
	private StatusRepository statusRepository;
	
	@GetMapping()
	public List<Status> buscar() {
		return statusRepository.findAll();
	}
	
}
