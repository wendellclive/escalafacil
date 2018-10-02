package com.databuilder.com.br.escalafacil.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.databuilder.com.br.escalafacil.domain.Proprietario;
import com.databuilder.com.br.escalafacil.repositories.ProprietarioRepository;
import com.databuilder.com.br.escalafacil.services.exceptions.DataIntegrityException;
import com.databuilder.com.br.escalafacil.services.exceptions.ObjectNotFoundException;

@Service
public class ProprietarioService {

	@Autowired
	private ProprietarioRepository reposit;
	
	public Proprietario find(Integer id) throws ObjectNotFoundException {
		
		Optional<Proprietario> obj = reposit.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Proprietario.class.getName()));
		
	}
	
	public Proprietario insert(Proprietario obj) {

		obj.setId(null); // faz o método entender que se não houver ID então é uma alteração
		return reposit.save(obj);

	}

	public Proprietario update(Proprietario obj) {

		find(obj.getId());
		return reposit.save(obj);

	}

	public void delete(Integer id) {

		find(id);
		try {
			reposit.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel Excluir um Proprietario");
		}
	}
	
	public List<Proprietario> findAll() {
		return reposit.findAll();
	}
	
/*	public Page<Proprietario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
	
		PageRequest pageRequest = new PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return reposit.findAll(pageRequest);
	}
	*/
}
