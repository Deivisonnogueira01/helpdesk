package com.projetod.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetod.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository <Chamado,Integer>{

	
}
