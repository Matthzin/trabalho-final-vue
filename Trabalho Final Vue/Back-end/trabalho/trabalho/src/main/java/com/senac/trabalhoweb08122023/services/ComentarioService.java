package com.senac.trabalhoweb08122023.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.trabalhoweb08122023.DAO.ComentarioDAO;
import com.senac.trabalhoweb08122023.entities.Comentario;

@Service
public class ComentarioService {
	
	@Autowired
	private ComentarioDAO dao;

	public List<Comentario> findAll() {
		return dao.findAll();
	}
	
	public Comentario findById(Integer id) {
		Optional<Comentario> obj=  dao.findById(id);
		return obj.get();
	}
	
}
