package com.databuilder.com.br.escalafacil.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.databuilder.com.br.escalafacil.domain.Proprietario;
import com.databuilder.com.br.escalafacil.repositories.ProprietarioRepository;

@Service
public class ProprietarioService {

	@Autowired
	private ProprietarioRepository reposit;
	
	public Proprietario find(Integer id) {
		
		Optional<Proprietario> obj = reposit.findById(id);
		return obj.orElse(null);
		
	}
}
