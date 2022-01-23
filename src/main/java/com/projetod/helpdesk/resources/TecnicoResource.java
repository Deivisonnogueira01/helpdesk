package com.projetod.helpdesk.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetod.helpdesk.domain.Tecnico;
import com.projetod.helpdesk.services.TecnicoService;

// camada que recebe o primeiro contato com o front

@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoResource {
	
	@Autowired
	private TecnicoService service;
	
@GetMapping(value = "/{id}")	
 public ResponseEntity<Tecnico> findById(@PathVariable Integer id){
	Tecnico obj = service.findByid(id);
	return ResponseEntity.ok().body(obj);
	 
 }
	
}
