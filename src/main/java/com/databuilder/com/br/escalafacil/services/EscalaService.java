package com.databuilder.com.br.escalafacil.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.databuilder.com.br.escalafacil.domain.Escala;
import com.databuilder.com.br.escalafacil.repositories.EscalaRepository;

@Service
public class EscalaService {

	@Autowired
	private EscalaRepository reposit;
	
	public Escala find(Integer id) {
		
		Optional<Escala> obj = reposit.findById(id);
		return obj.orElse(null);
		
	}
}
