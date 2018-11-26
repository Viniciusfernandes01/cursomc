package com.viniciusfernandes.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viniciusfernandes.cursomc.domain.Cliente;
import com.viniciusfernandes.cursomc.repositories.ClienteRepository;
import com.viniciusfernandes.cursomc.services.exceptions.ObjectNotFoundException;


//ClienteService - classe resposavel por fazer a consulta no repositorio

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Cliente obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! ID: " + id
											+ ", tipo: " + Cliente.class.getName());
		}
		return obj;
		
	}

}
