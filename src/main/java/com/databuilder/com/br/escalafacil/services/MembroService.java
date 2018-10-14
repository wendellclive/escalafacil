package com.databuilder.com.br.escalafacil.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.databuilder.com.br.escalafacil.domain.Membro;
import com.databuilder.com.br.escalafacil.repositories.MembroRepository;
import com.databuilder.com.br.escalafacil.services.exceptions.DataIntegrityException;
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
	
	@Transactional
	public Membro insert(Membro obj) {

		Membro newObj = find(obj.getId());
		updateData(newObj, obj);
		return reposit.save(newObj);

	}

	public Membro update(Membro obj) {

		Membro newObj = find(obj.getId());
		updateData(newObj, obj);
		return reposit.save(newObj);

	}

	public void delete(Integer id) {

		find(id);
		try {
			reposit.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel Excluir um Membro");
		}
	}
	
	public List<Membro> findAll() {
		return reposit.findAll();
	}
	
	public Page<Membro> findPage(Integer page, Integer linesPerPage, String direction, String orderBy) {
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		return reposit.findAll(pageRequest);
	}
	
	private void updateData(Membro newObj, Membro obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
	
}
