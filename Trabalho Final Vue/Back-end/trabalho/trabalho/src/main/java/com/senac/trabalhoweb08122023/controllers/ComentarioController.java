	package com.senac.trabalhoweb08122023.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.trabalhoweb08122023.entities.Comentario;
import com.senac.trabalhoweb08122023.services.ComentarioService;

@RestController
@RequestMapping(value = "/comentarios")
@CrossOrigin(origins = "http://localhost:8080")
public class ComentarioController {

	@Autowired
	private ComentarioService service;
	
	@GetMapping
	public ResponseEntity<List<Comentario>> findAll() {
		List<Comentario> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Comentario> findById(@PathVariable Integer id) {
		Comentario obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
