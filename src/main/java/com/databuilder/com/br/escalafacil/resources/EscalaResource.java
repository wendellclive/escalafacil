package com.databuilder.com.br.escalafacil.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.databuilder.com.br.escalafacil.domain.Escala;
import com.databuilder.com.br.escalafacil.services.EscalaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Created by Wendell Clive Santos de Lira - Email: wendell.clive@gmail.com
 * Data: 14/09/2018
 */

// Incluir anotations para compor a camada End-Poin REST
@RestController
@RequestMapping(value = "/escalas")
public class EscalaResource {

	@Autowired
	private EscalaService service;

	// Associado ao verbo HTTP
	@ApiOperation(value="Busca Escala por id")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Escala> find(@PathVariable Integer id) {

		Escala obj = service.find(id);

		return ResponseEntity.ok().body(obj);

	}

	// Método para chamar Servico de inserir objeto
	@ApiOperation(value="Insere nova Escala")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Escala obj) {

		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	@ApiOperation(value="Atualiza Escala")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Escala obj, @PathVariable Integer id) {

		obj.setId(id);
		obj = service.update(obj);

		return ResponseEntity.noContent().build();

	}

	// Associado ao verbo HTTP
	@ApiOperation(value="Remove Escala")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Não é possível excluir uma Escala que possui membros"),
			@ApiResponse(code = 404, message = "Código inexistente") })
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		service.delete(id);
		return ResponseEntity.noContent().build();

	}
/*
	@ApiOperation(value="Retorna todas as Escalas")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<EscalaDTO>> findAll() {

		List<Escala> list = service.findAll();
		List<EscalaDTO> listDto = list.stream().map(obj -> new EscalaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);

	}

	@ApiOperation(value="Retorna Escalas até 24 linhas por pagina")
	@RequestMapping(value="/page", method = RequestMethod.GET)
	public ResponseEntity<Page<EscalaDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="direction", defaultValue="ASC") String direction, 
			@RequestParam(value="orderBy", defaultValue="titulo") String orderBy) {

		Page<Escala> list = service.findPage(page, linesPerPage, direction, orderBy);
		Page<EscalaDTO> listDto = list.map(obj -> new EscalaDTO(obj));
		return ResponseEntity.ok().body(listDto);

	}
	
	*/
	@ApiOperation(value="Retorna Escalas até 24 linhas por pagina")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<Escala>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="direction", defaultValue="DESC") String direction, 
			@RequestParam(value="orderBy", defaultValue="instituicao") String orderBy) {
		Page<Escala> list = service.findPage(page, linesPerPage, direction, orderBy);
		return ResponseEntity.ok().body(list);

	}
	
}
