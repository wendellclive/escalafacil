package com.databuilder.com.br.escalafacil.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.databuilder.com.br.escalafacil.domain.Escala;
import com.databuilder.com.br.escalafacil.repositories.EscalaRepository;
import com.databuilder.com.br.escalafacil.services.exceptions.DataIntegrityException;
import com.databuilder.com.br.escalafacil.services.exceptions.ObjectNotFoundException;

@Service
public class EscalaService {

	@Autowired
	private EscalaRepository reposit;

	public Escala find(Integer id) {

		Optional<Escala> obj = reposit.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Escala.class.getName()));

	}
	

	public Escala insert(Escala obj) {

		obj.setId(null); // faz o método entender que se não houver ID então é uma alteração
		return reposit.save(obj);

	}

	public Escala update(Escala obj) {

		find(obj.getId());
		return reposit.save(obj);

	}

	public void delete(Integer id) {

		find(id);
		try {
			reposit.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel Excluir um Escala");
		}
	}
	
	public List<Escala> findAll() {
		return reposit.findAll();
	}
	
}
