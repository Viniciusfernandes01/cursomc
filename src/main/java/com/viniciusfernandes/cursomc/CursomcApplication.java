package com.viniciusfernandes.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.viniciusfernandes.cursomc.domain.Categoria;
import com.viniciusfernandes.cursomc.repositories.CategoriaRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{   //CommandLineRunner vai permitir implementar um metodo auxiliar para executar alguma açao quando a aplicaçao iniciar
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

@Override
public void run(String... args) throws Exception {
	
	Categoria cat1 = new Categoria(null, "Informática");
	Categoria cat2 = new Categoria(null, "Escritório");
	
	categoriaRepository.save(Arrays.asList(cat1, cat2)); //save para salvar no banco; "Arrays.asList(cat1, cat2)" massete para salvar como lista
	
	
}
}
