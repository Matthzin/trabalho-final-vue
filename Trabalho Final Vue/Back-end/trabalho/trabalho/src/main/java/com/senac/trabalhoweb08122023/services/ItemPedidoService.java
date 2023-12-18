package com.senac.trabalhoweb08122023.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.trabalhoweb08122023.DAO.ItemPedidoDAO;
import com.senac.trabalhoweb08122023.entities.ItemPedido;

@Service
public class ItemPedidoService {
	
	@Autowired
	private ItemPedidoDAO dao;

	public List<ItemPedido> findAll() {
		return dao.findAll();
	}
	
	public ItemPedido findById(Integer id) {
		Optional<ItemPedido> obj=  dao.findById(id);
		return obj.get();
	}
	
}
