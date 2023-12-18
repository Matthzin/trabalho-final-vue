package com.senac.trabalhoweb08122023.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senac.trabalhoweb08122023.entities.Pedido;
import com.senac.trabalhoweb08122023.entities.enums.StatusPedido;

public interface PedidoDAO extends JpaRepository<Pedido, Integer> {
	List<Pedido> findByStatusPedido(Integer statusPedido);
}
