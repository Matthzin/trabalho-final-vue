	package com.senac.trabalhoweb08122023.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.trabalhoweb08122023.entities.ItemPedido;
import com.senac.trabalhoweb08122023.entities.Pedido;
import com.senac.trabalhoweb08122023.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
@CrossOrigin(origins = "http://localhost:8080")
public class PedidoController {

	@Autowired
	private PedidoService service;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> findAll() {
		List<Pedido> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Integer id) {
		Pedido obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/status/{statusPedido}")
	public ResponseEntity<List<Pedido>> findByStatusPedido(@PathVariable Integer statusPedido) {
		List<Pedido> lista = service.findPedidosByStatus(statusPedido);
		return ResponseEntity.ok().body(lista);
	}
	
	@PostMapping
	public ResponseEntity<Pedido> insert(@RequestBody Pedido obj) {
		obj = service.insert(obj.getCliente());
		return ResponseEntity.ok().body(obj);
	}
	
//	@PostMapping("/insert-item")
//    public ResponseEntity<Pedido> insertItem(@RequestBody ItemPedido item) {
//		String cliente = request.getCliente();
//        Pedido obj = service.createPedidoAndInsertItem(item, cliente);
//        return ResponseEntity.ok().body(obj);
//    }
}
