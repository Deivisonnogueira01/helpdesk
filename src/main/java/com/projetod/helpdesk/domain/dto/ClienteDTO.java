package com.projetod.helpdesk.domain.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projetod.helpdesk.domain.Cliente;
import com.projetod.helpdesk.domain.enums.Perfil;

public class ClienteDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	 
	
	protected Integer id;
	@NotNull(message = "O campo nome é obrigatorio")
	protected String nome;
	@NotNull(message = "O campo cpf é obrigatorio")
	protected String cpf;
	@NotNull(message = "O campo email é obrigatorio")
	protected String email;
	@NotNull(message = "O campo senha é obrigatorio")
	protected String senha;
	protected Set<Integer> perfis = new HashSet<>();
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataCriação = LocalDate.now(); // momento atual

	public ClienteDTO() {
		super();
		addPerfil(Perfil.CLIENTE);
	}

	public ClienteDTO(Cliente obj){	
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf =  obj.getCpf();
		this.email =  obj.getEmail();
		this.senha =  obj.getSenha();      // lambda                // Integer busca apenas por numero  
		this.perfis = obj.getPerfis().stream().map(x -> x.getNumeracao()).collect(Collectors.toSet());
		this.dataCriação = obj.getDataCriação();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		this.perfis.add(perfil.getNumeracao());
	}

	public LocalDate getDataCriação() {
		return dataCriação;
	}

	public void setDataCriação(LocalDate dataCriação) {
		this.dataCriação = dataCriação;
	}
	
	

}
