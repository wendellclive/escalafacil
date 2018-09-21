package com.databuilder.com.br.escalafacil.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.databuilder.com.br.escalafacil.domain.Membro;
import com.databuilder.com.br.escalafacil.repositories.MembroRepository;
import com.databuilder.com.br.escalafacil.services.exceptions.ObjectNotFoundException;



@Service
public class MembroService {

	@Autowired
	private MembroRepository reposit;
	
	public Membro find(Integer id) throws ObjectNotFoundException {
		
		Optional<Membro> obj = reposit.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Membro.class.getName()));
		
	}
}
