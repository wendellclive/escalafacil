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

import com.databuilder.com.br.escalafacil.domain.Grupo;
import com.databuilder.com.br.escalafacil.dto.GrupoDTO;
import com.databuilder.com.br.escalafacil.repositories.GrupoRepository;
import com.databuilder.com.br.escalafacil.services.exceptions.DataIntegrityException;
import com.databuilder.com.br.escalafacil.services.exceptions.ObjectNotFoundException;

@Service
public class GrupoService {

	@Autowired
	private GrupoRepository reposit;

	public Grupo find(Integer id) {

		Optional<Grupo> obj = reposit.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Grupo.class.getName()));
	}

	@Transactional
	public Grupo insert(Grupo obj) {

		Grupo newObj = find(obj.getId());
		updateData(newObj, obj);
		return reposit.save(newObj);

	}

	public Grupo update(Grupo obj) {

		Grupo newObj = find(obj.getId());
		updateData(newObj, obj);
		return reposit.save(newObj);
		
	}

	public void delete(Integer id) {

		find(id);
		try {
			reposit.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel Excluir um Grupo");
		}
	}
	
	public List<Grupo> findAll() {
		return reposit.findAll();
	}
		
	public Page<Grupo> findPage(Integer page, Integer linesPerPage, String direction, String orderBy) {
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		return reposit.findAll(pageRequest);
	}
	
	public Grupo fromDTO(GrupoDTO objDto) {
		return new Grupo(objDto.getId(), objDto.getNome());
	}
	
	private void updateData(Grupo newObj, Grupo obj) {
		newObj.setNome(obj.getNome());
	}
	
	
}
