package com.databuilder.com.br.escalafacil.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.databuilder.com.br.escalafacil.domain.Membro;
import com.databuilder.com.br.escalafacil.repositories.MembroRepository;

@Service
public class MembroService {

	@Autowired
	private MembroRepository reposit;
	
	public Membro find(Integer id) {
		
		Optional<Membro> obj = reposit.findById(id);
		return obj.orElse(null);
		
	}
}
