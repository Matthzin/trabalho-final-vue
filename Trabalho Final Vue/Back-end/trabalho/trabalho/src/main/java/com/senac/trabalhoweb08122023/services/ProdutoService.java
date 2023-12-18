package com.senac.trabalhoweb08122023.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.trabalhoweb08122023.DAO.ProdutoDAO;
import com.senac.trabalhoweb08122023.entities.Produto;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoDAO dao;

	public List<Produto> findAll() {
		return dao.findAll();
	}
	
	public Produto findById(Integer id) {
		Optional<Produto> obj=  dao.findById(id);
		return obj.get();
	}
	
}
