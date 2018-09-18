package com.databuilder.com.br.escalafacil.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.databuilder.com.br.escalafacil.domain.Grupo;
import com.databuilder.com.br.escalafacil.repositories.GrupoRepository;

@Service
public class GrupoService {

	@Autowired
	private GrupoRepository reposit;
	
	public Grupo find(Integer id) {
		
		Optional<Grupo> obj = reposit.findById(id);
		return obj.orElse(null);
		
	}
}
