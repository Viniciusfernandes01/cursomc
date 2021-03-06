package com.viniciusfernandes.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity //para mapear a tabela produtos
public class Produto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //estrategia de geraçao automatica de ID para criar a tabela no banco
	private Integer id;
	private String nome;
	private Double preco;
	
	@JsonIgnore
	@ManyToMany //para mapear muitos pra muitos; listas para listas;
	@JoinTable(name = "PRODUTO_CATEGORIA",                            //nome da tabela que vai estar entre o produto e a categoria
	        joinColumns = @JoinColumn(name = "produto_id"),          //chave estrangeira de Produtos  
	        inverseJoinColumns = @JoinColumn(name = "categoria_id")		//chave estrangeira de Categorias
	)
	
	private List<Categoria> categorias = new ArrayList<>();    //no ManyToMany de Categorias se faz referencias a esse array que foi feito o mapeamento por aqui
	
	@JsonIgnore //o ideal é saber os produtos dos itens de pedido e nao o inverso, por isso ignorar para nao serializar.
	@OneToMany(mappedBy="id.produto")
	private Set<ItemPedido> itens = new HashSet<>();  //Essa coleçao vai auziliar a garantir que nao repetirá os mesmo itens por produto

	
	public Produto() {
	}

	public Produto(Integer id, String nome, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}
	@JsonIgnore//se nao ignorar essa lista, será serializado os produtos dos pedidos, tudo que começa com get será serializado
	public List<Pedido> getPedido(){
		List<Pedido> lista = new ArrayList<>();
		for (ItemPedido x : itens) {
			lista.add(x.getPedido());
		}
		return lista;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
