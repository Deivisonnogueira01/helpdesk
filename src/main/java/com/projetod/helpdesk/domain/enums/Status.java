package com.projetod.helpdesk.domain.enums;

public enum Status {
    
	
	  ABERTO(0,"ABERTO"), ANDAMENTO(1,"ANDAMENTO"), ENCERRADO(2,"ENCERRADO");
	
	private Integer numeracao;
	private String descricao;
	
	
	private Status(Integer numeracao, String descricao) {
		this.numeracao = numeracao;
		this.descricao = descricao;
	}


	public Integer getNumeracao() {
		return numeracao;
	}


	public String getDescricao() {
		return descricao;
	}
	
	public static Status toEnum(Integer cod) {
		if(cod == null) {
			return null;
			
		}
		for(Status x : Status.values()) {
			if(cod.equals(x.getNumeracao())) {
				
			}
		}
		              // nao existe
		throw new IllegalArgumentException("Status inválido");
	}
	
	
}
