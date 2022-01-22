package com.projetod.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetod.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository <Pessoa,Integer>{

}
