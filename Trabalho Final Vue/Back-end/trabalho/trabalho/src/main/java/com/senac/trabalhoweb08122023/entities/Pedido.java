package com.senac.trabalhoweb08122023.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.senac.trabalhoweb08122023.entities.enums.StatusPedido;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant dataHoraPedido;
	private String cliente;
	private Integer statusPedido;
	
	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemPedido> itens = new HashSet<>();
	
	public Pedido() {
	}
	
	public Pedido(String cliente) {
		this.dataHoraPedido = Instant.now();
		setStatusPedido(StatusPedido.ABERTO);
		this.cliente = cliente;
	}
	
	public Pedido(Integer id, Instant dataHoraPedido, String cliente, StatusPedido statusPedido) {
		super();
		this.id = id;
		this.dataHoraPedido = dataHoraPedido;
		this.cliente = cliente;
		setStatusPedido(statusPedido);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Instant getDataHoraPedido() {
		return dataHoraPedido;
	}

	public void setDataHoraPedido(Instant dataHoraPedido) {
		this.dataHoraPedido = dataHoraPedido;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	public Set<ItemPedido> getItens() {
		return itens;
	}

	public StatusPedido getStatusPedido() {
		return StatusPedido.valueOf(statusPedido);
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		if(statusPedido != null)
		this.statusPedido = statusPedido.getCode();
	}
	
	public Double getTotal() {
		double soma = 0.0;
		for (ItemPedido x: itens) {
			soma += x.getSubTotal();
		}
		return soma;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
