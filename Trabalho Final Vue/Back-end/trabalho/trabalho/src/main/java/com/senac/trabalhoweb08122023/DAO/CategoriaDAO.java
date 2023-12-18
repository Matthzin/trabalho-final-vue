package com.senac.trabalhoweb08122023.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senac.trabalhoweb08122023.entities.Categoria;

public interface CategoriaDAO extends JpaRepository<Categoria, Integer> {
	
}
