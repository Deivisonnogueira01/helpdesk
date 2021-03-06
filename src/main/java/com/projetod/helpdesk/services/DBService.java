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
		
		 Tecnico tec1 = new Tecnico(1, "Nicolas Tanaka","147.587.405-22","tanakanick@gmail.com","nick0@");
         tec1.addPerfil(Perfil.ADMIN);
         Tecnico tec2 = new Tecnico(2, "Giuliano hugo","481.875.454-44","gh@gmail.com","hugodugrau01");
         tec1.addPerfil(Perfil.TECNICO);
         
         Cliente cli2 = new Cliente(null, "Usiminas","225.478.999-66", "usiminas@gmail.xom" , "45@@A011"); 
         Cliente cli1 = new Cliente(null, "Rubens Almeida","408.487.176-93", "rubinho@gmail.xom" , "barrick457"); 
         
         Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO,"Chamado 01" ,"primerio chamado" ,tec1,cli1);
         Chamado c2 = new Chamado(null, Prioridade.BAIXA, Status.ANDAMENTO,"Chamado 02" ," 2° chamado" ,tec2,cli2);
         
         
         tecnicoRepository.saveAll(Arrays.asList(tec2));
         clienteRepository.saveAll(Arrays.asList(cli2));
         chamadoRepository.saveAll(Arrays.asList(c2));
         
         tecnicoRepository.saveAll(Arrays.asList(tec1));
         clienteRepository.saveAll(Arrays.asList(cli1));
         chamadoRepository.saveAll(Arrays.asList(c1));
		
		
	}
}
