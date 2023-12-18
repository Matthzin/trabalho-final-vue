package com.senac.trabalhoweb08122023.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senac.trabalhoweb08122023.entities.Produto;

public interface ProdutoDAO extends JpaRepository<Produto, Integer> {
	
}
