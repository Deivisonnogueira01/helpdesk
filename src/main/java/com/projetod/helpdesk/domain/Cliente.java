package com.projetod.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projetod.helpdesk.domain.dto.ClienteDTO;
import com.projetod.helpdesk.domain.enums.Perfil;


@Entity
public class Cliente extends Pessoa {
    
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<Chamado> chamados = new ArrayList<>();// Para evitar a excessao de ponto nulo

	public Cliente() {
		super();
		addPerfil(Perfil.CLIENTE);
	}

	 // nao se passa uma lista de chamados quando se instacia um
	//cliente
	public Cliente(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
		addPerfil(Perfil.CLIENTE);
	}
	
public Cliente(ClienteDTO obj) {
		
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.senha = obj.getSenha(); // lambda // Integer busca apenas por numero
		this.perfis = obj.getPerfis().stream().map(x -> x.getNumeracao()).collect(Collectors.toSet());
		this.dataCriação = obj.getDataCriação();
	}


	   // Polimorfismo
	  // Classe Cliente herda da Classe Pessoa
	// onde a classe Cliente possui metodos que a classe Pessoa nao possui
	public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}
	
	
	
}
