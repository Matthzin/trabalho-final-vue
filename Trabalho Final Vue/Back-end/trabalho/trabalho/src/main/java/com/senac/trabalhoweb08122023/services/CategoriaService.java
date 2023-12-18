package com.senac.trabalhoweb08122023.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.trabalhoweb08122023.DAO.CategoriaDAO;
import com.senac.trabalhoweb08122023.entities.Categoria;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaDAO dao;

	public List<Categoria> findAll() {
		return dao.findAll();
	}
	
	public Categoria findById(Integer id) {
		Optional<Categoria> obj=  dao.findById(id);
		return obj.get();
	}
	
}
