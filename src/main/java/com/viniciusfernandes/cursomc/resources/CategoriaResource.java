package com.viniciusfernandes.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viniciusfernandes.cursomc.domain.Categoria;
import com.viniciusfernandes.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired //para instanciar automaticamente esse objeto
	private CategoriaService service;
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) { //PathVariable para o Spring entender que estamos fazendo referencia para o "/{id}"
		//ResponseEntity - tipo especial que armazena varias informaçoes http para um serviço REST
		//o <?> quer dizer que pode ser qualquer tipo, qualquer informaçao
		
		Categoria obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
		
	}

}
