package com.senac.trabalhoweb08122023.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_produto")
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private Double preco;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	
	@JsonIgnore
	private Categoria categoria;
	
	@OneToMany(mappedBy = "produto")
	private Set<Imagem> imagens = new HashSet<>();
	
	@OneToMany(mappedBy = "produto")
	private List<Comentario> comentarios = new ArrayList<>();
	
	@OneToMany(mappedBy = "id.produto")
	private Set<ItemPedido> itens = new HashSet<>();
	
	public Produto() {
	}
	
	public Produto(Integer id, String descricao, Double preco, String imgUrl, Categoria categoria) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Set<Imagem> getImagens() {
		return imagens;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@JsonIgnore
	public Set<Pedido> getPedidos() {
		Set<Pedido> set = new HashSet<>();
		for (ItemPedido x: itens) {
			set.add(x.getPedido());
		}
		return set;
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
		return Objects.equals(id, other.id);
	}
}
