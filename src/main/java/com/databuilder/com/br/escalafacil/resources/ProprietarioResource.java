package com.databuilder.com.br.escalafacil.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.databuilder.com.br.escalafacil.domain.Proprietario;
import com.databuilder.com.br.escalafacil.services.ProprietarioService;

import javassist.tools.rmi.ObjectNotFoundException;

/**
 * Created by Wendell Clive Santos de Lira - Email: wendell.clive@gmail.com Data:
 *         14/09/2018
 */

// Incluir anotations para compor a camada End-Poin REST
@RestController
@RequestMapping(value = "/proprietarios")
public class ProprietarioResource {

	@Autowired
	private ProprietarioService service;
	
	// Associado ao verbo HTTP
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) throws ObjectNotFoundException {
		
		Proprietario obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);

	}

}
