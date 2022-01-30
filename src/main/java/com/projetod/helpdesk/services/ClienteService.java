package com.projetod.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetod.helpdesk.domain.Pessoa;
import com.projetod.helpdesk.domain.Cliente;
import com.projetod.helpdesk.domain.dto.ClienteDTO;
import com.projetod.helpdesk.repositories.PessoaRepository;
import com.projetod.helpdesk.repositories.ClienteRepository;
import com.projetod.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.projetod.helpdesk.services.exceptions.ObjectnotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("nao existe :" +  "id: " + id));
	}


	public List<Cliente> findAll() {
		return repository.findAll();
	}
	
	
	public Cliente create(ClienteDTO objDTO) {
		objDTO.setId(null);
		validarCpfEEmail(objDTO);
		Cliente newObj = new Cliente(objDTO);
		return repository.save(newObj);
	}
	

	public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
		objDTO.setId(id);
		Cliente oldObj = findById(id);
		validarCpfEEmail(objDTO);
		oldObj = new Cliente(objDTO);
		return repository.save(oldObj);
	}
	
	public void delete(Integer id ) {
      Cliente obj = findById(id);
      if(obj.getChamados().size() > 0) {
    	  throw new DataIntegrityViolationException("Cliente possui ordens de Serviço !");
      }else {
    	  repository.deleteById(id);
      }
	}


	private void validarCpfEEmail(ClienteDTO objDTO) {
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

	 

