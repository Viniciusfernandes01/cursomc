package com.viniciusfernandes.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viniciusfernandes.cursomc.domain.Pedido;
import com.viniciusfernandes.cursomc.repositories.PedidoRepository;
import com.viniciusfernandes.cursomc.services.exceptions.ObjectNotFoundException;


//PedidoService - classe resposavel por fazer a consulta no repositorio

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Pedido obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! ID: " + id
											+ ", tipo: " + Pedido.class.getName());
		}
		return obj;
		
	}

}
