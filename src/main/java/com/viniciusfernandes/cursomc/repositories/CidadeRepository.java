package com.viniciusfernandes.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viniciusfernandes.cursomc.domain.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer>{ 
	
	//Somente isso para implantar o Rpository na classe.(no caso aqui é a classe Categoria)
	//aqui poderá realizar operaçoes de busca, deletar, implantar... tudo no banco
	//O Objeto categoria já está mapeado no banco
	//repository é a camada de acesso a dados
	}
