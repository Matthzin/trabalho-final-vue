	package com.senac.trabalhoweb08122023.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.trabalhoweb08122023.entities.ItemPedido;
import com.senac.trabalhoweb08122023.services.ItemPedidoService;

@RestController
@RequestMapping(value = "/itens-pedido")
@CrossOrigin(origins = "http://localhost:8080")
public class ItemPedidoController {

	@Autowired
	private ItemPedidoService service;
	
	@GetMapping
	public ResponseEntity<List<ItemPedido>> findAll() {
		List<ItemPedido> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ItemPedido> findById(@PathVariable Integer id) {
		ItemPedido obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
