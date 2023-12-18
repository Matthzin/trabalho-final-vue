package com.senac.trabalhoweb08122023.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.trabalhoweb08122023.DAO.ImagemDAO;
import com.senac.trabalhoweb08122023.entities.Imagem;

@Service
public class ImagemService {
	
	@Autowired
	private ImagemDAO dao;

	public List<Imagem> findAll() {
		return dao.findAll();
	}
	
	public Imagem findById(Integer id) {
		Optional<Imagem> obj=  dao.findById(id);
		return obj.get();
	}
	
}
