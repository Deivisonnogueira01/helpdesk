package com.projetod.helpdesk.domain.enums;

public enum Prioridade {
    
	
	  BAIXA(0,"BAIXA"), MEDIA(1,"MEDIA"), ALTA(2,"ALTA");
	
	private Integer numeracao;
	private String descricao;
	
	
	private Prioridade(Integer numeracao, String descricao) {
		this.numeracao = numeracao;
		this.descricao = descricao;
	}


	public Integer getNumeracao() {
		return numeracao;
	}


	public String getDescricao() {
		return descricao;
	}
	
	public static Prioridade toEnum(Integer cod) {
		if(cod == null) {
			return null;
			
		}
		for(Prioridade x : Prioridade.values()) {
			if(cod.equals(x.getNumeracao())) {
				
			}
		}
		              // nao existe
		throw new IllegalArgumentException("Prioridade inválida");
	}
	
	
}
