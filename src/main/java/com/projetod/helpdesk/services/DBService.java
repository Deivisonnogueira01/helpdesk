package com.projetod.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetod.helpdesk.domain.Chamado;
import com.projetod.helpdesk.domain.Cliente;
import com.projetod.helpdesk.domain.Tecnico;
import com.projetod.helpdesk.domain.enums.Perfil;
import com.projetod.helpdesk.domain.enums.Prioridade;
import com.projetod.helpdesk.domain.enums.Status;
import com.projetod.helpdesk.repositories.ChamadoRepository;
import com.projetod.helpdesk.repositories.ClienteRepository;
import com.projetod.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	
	
	
	public void instanciaDB() {
		
		 Tecnico tec1 = new Tecnico(null, "Nicolas Tanaka","14758740522","tanakanick@gmail.com","nick0@");
         tec1.addPerfil(Perfil.ADMIN);
         
         Cliente cli1 = new Cliente(null, "Rubens Almeida","40848717693", "rubinho@gmail.xom" , "barrick457"); 
         
         Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO,"Chamado 01" ,"primerio chamado" ,tec1,cli1);
         
         tecnicoRepository.saveAll(Arrays.asList(tec1));
         clienteRepository.saveAll(Arrays.asList(cli1));
         chamadoRepository.saveAll(Arrays.asList(c1));
		
		
	}
}
