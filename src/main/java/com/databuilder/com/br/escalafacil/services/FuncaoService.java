package com.databuilder.com.br.escalafacil.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.databuilder.com.br.escalafacil.domain.Funcao;
import com.databuilder.com.br.escalafacil.repositories.FuncaoRepository;

@Service
public class FuncaoService {

	@Autowired
	private FuncaoRepository reposit;
	
	public Funcao find(Integer id) {
		
		Optional<Funcao> obj = reposit.findById(id);
		return obj.orElse(null);
		
	}
}
