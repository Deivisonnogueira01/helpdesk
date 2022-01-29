package com.projetod.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetod.helpdesk.domain.Pessoa;
import com.projetod.helpdesk.domain.Tecnico;
import com.projetod.helpdesk.domain.dto.TecnicoDTO;
import com.projetod.helpdesk.repositories.PessoaRepository;
import com.projetod.helpdesk.repositories.TecnicoRepository;
import com.projetod.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.projetod.helpdesk.services.exceptions.ObjectnotFoundException;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("nao existe :" +  "id: " + id));
	}


	public List<Tecnico> findAll() {
		return repository.findAll();
	}
	
	
	public Tecnico create(TecnicoDTO objDTO) {
		objDTO.setId(null);
		validarCpfEEmail(objDTO);
		Tecnico newObj = new Tecnico(objDTO);
		return repository.save(newObj);
	}


	private void validarCpfEEmail(TecnicoDTO objDTO) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId())	{
			throw new DataIntegrityViolationException("CPF ja cadastrado");
		}
		
		obj = pessoaRepository.findByEmail(objDTO.getEmail());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("E-mail já cadastrado no Sistema");
		}
	}
	
	
	
}
