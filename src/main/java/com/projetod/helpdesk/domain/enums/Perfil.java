package com.projetod.helpdesk.domain.enums;

public enum Perfil {
    
	
	  ADMIN(0,"ROLE_ADMIN"), CLIENTE(1,"ROLE_CLIENTE"), TECNICO(2,"ROLE_TECNICO");
	
	private Integer numeracao;
	private String descricao;
	
	
	private Perfil(Integer numeracao, String descricao) {
		this.numeracao = numeracao;
		this.descricao = descricao;
	}


	public Integer getNumeracao() {
		return numeracao;
	}


	public String getDescricao() {
		return descricao;
	}
	
	public static Perfil toEnum(Integer cod) {
		if(cod == null) {
			return null;
			
		}
		for(Perfil x : Perfil.values()) {
			if(cod.equals(x.getNumeracao())) {
				return x;
				
			}
		}
		              // nao existe
		throw new IllegalArgumentException("Perfil inválido");
	}
	
	
}
