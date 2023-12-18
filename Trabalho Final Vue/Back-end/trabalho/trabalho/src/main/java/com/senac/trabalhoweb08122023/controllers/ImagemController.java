	package com.senac.trabalhoweb08122023.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.trabalhoweb08122023.entities.Imagem;
import com.senac.trabalhoweb08122023.services.ImagemService;

@RestController
@RequestMapping(value = "/imagens")
@CrossOrigin(origins = "http://localhost:8080")
public class ImagemController {

	@Autowired
	private ImagemService service;
	
	@GetMapping
	public ResponseEntity<List<Imagem>> findAll() {
		List<Imagem> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Imagem> findById(@PathVariable Integer id) {
		Imagem obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
