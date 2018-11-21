package com.viniciusfernandes.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.viniciusfernandes.cursomc.domain.Categoria;
import com.viniciusfernandes.cursomc.domain.Produto;
import com.viniciusfernandes.cursomc.repositories.CategoriaRepository;
import com.viniciusfernandes.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{   //CommandLineRunner vai permitir implementar um metodo auxiliar para executar alguma açao quando a aplicaçao iniciar
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

@Override
public void run(String... args) throws Exception {
	
	Categoria cat1 = new Categoria(null, "Informática");
	Categoria cat2 = new Categoria(null, "Escritório");
	
	Produto p1 = new Produto(null, "Computador", 2000.00);
	Produto p2 = new Produto(null, "Impressora", 800.00);
	Produto p3 = new Produto(null, "Mouse", 80.00);
	
	//Associando os produtos as suas categorias
	
	cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));  //Arrays.asList - macete para criar uma lista sem precisar instanciar uma lista(Criar uma lista somente ali)
	cat2.getProdutos().addAll(Arrays.asList(p2));
	//agora as categorias sabem quais sao os seus produtos
	
	p1.getCategorias().addAll(Arrays.asList(cat1));
	p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
	p3.getCategorias().addAll(Arrays.asList(cat1));
	
	categoriaRepository.save(Arrays.asList(cat1, cat2)); //save para salvar no banco; "Arrays.asList(cat1, cat2)" macete para salvar como lista
	produtoRepository.save(Arrays.asList(p1, p2, p3));
	
}
}
