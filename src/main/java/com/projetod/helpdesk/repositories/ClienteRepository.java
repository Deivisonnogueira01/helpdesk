package com.projetod.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetod.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente,Integer>{

	
}
