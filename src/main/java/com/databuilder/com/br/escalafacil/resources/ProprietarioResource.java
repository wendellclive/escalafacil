package com.databuilder.com.br.escalafacil.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.databuilder.com.br.escalafacil.domain.Proprietario;
import com.databuilder.com.br.escalafacil.services.ProprietarioService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
	@ApiOperation(value="Busca Proprietario por id")
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Proprietario> find(@PathVariable Integer id) throws ObjectNotFoundException {
		
		Proprietario obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);

	}

	// Método para chamar Servico de inserir objeto
	@ApiOperation(value="Insere Proprietario")
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Proprietario obj) {
		
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@ApiOperation(value="Atualiza Proprietario")
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Proprietario obj, @PathVariable Integer id) {

		obj.setId(id);
		obj = service.update(obj);
		
		return ResponseEntity.noContent().build();
		
	}
	
	// Associado ao verbo HTTP
	@ApiOperation(value="Remove Proprietario")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Não é possível excluir um Proprietário que tem Escala criada"),
			@ApiResponse(code = 404, message = "Código inexistente") })
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		service.delete(id);
		return ResponseEntity.noContent().build();

	}
	
	@ApiOperation(value="Retorna todos os Proprietários")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Proprietario>> findAll() {

		List<Proprietario> list = service.findAll();

		return ResponseEntity.ok().body(list);

	}
	
}
