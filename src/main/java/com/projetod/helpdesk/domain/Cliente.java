package com.projetod.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Cliente extends Pessoa {
    
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "cliente")
	private List<Chamado> chamados = new ArrayList<>();// Para evitar a excessao de ponto nulo

	public Cliente() {
		super();
	}

	 // nao se passa uma lista de chamados quando se instacia um
	//cliente
	public Cliente(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
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
