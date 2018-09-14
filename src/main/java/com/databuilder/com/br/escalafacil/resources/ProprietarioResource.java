package com.databuilder.com.br.escalafacil.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wendell Clive Santos de Lira - Email: wendell.clive@gmail.com
 * Data: 14/09/2018
 */

// Incluir anotations para compor a camada End-Poin REST
@RestController
@RequestMapping(value="/proprietarios")
public class ProprietarioResource {

	// Associado ao verbo HTTP
	@RequestMapping(method=RequestMethod.GET)
	public String listar() {
		
		return "REST está em funcionamento!";
		
	}
	
}
