package com.viniciusfernandes.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viniciusfernandes.cursomc.domain.Categoria;
import com.viniciusfernandes.cursomc.repositories.CategoriaRepository;
import com.viniciusfernandes.cursomc.services.exceptions.ObjectNotFoundException;


//CategoriaService - classe resposavel por fazer a consulta no repositorio

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Categoria obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! ID: " + id
											+ ", tipo: " + Categoria.class.getName());
		}
		return obj;
		
	}

}
