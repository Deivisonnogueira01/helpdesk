package com.projetod.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa{
                                    // Para evitar a excessao de ponto nulo
	private List<Chamado> chamados = new ArrayList<>();

	public Cliente() {
		super();
	}

	public Cliente(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
	}
	
	
	
}
