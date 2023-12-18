package com.senac.trabalhoweb08122023.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senac.trabalhoweb08122023.entities.Imagem;

public interface ImagemDAO extends JpaRepository<Imagem, Integer> {
	
}
