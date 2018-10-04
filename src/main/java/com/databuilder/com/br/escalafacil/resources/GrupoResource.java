package com.databuilder.com.br.escalafacil.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.databuilder.com.br.escalafacil.domain.Grupo;
import com.databuilder.com.br.escalafacil.dto.GrupoDTO;
import com.databuilder.com.br.escalafacil.services.GrupoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Created by Wendell Clive Santos de Lira - Email: wendell.clive@gmail.com
 * Data: 14/09/2018
 */

// Incluir anotations para compor a camada End-Poin REST
@RestController
@RequestMapping(value = "/grupos")
public class GrupoResource {

	@Autowired
	private GrupoService service;

	// Associado ao verbo HTTP
	@ApiOperation(value="Busca por id")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Grupo> find(@PathVariable Integer id) {

		Grupo obj = service.find(id);

		return ResponseEntity.ok().body(obj);

	}

	// Método para chamar Servico de inserir objeto
	@ApiOperation(value="Insere Grupo")
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody GrupoDTO objDto) {
		Grupo obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@ApiOperation(value="Atualiza Grupo")
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody GrupoDTO objDto, @PathVariable Integer id) {
		Grupo obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		
		return ResponseEntity.noContent().build();
		
	}
	
	// Associado ao verbo HTTP
	@ApiOperation(value="Detela Grupo")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Não é possível excluir uma Grupo que possui membros"),
			@ApiResponse(code = 404, message = "Código inexistente") })
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		service.delete(id);
		return ResponseEntity.noContent().build();

	}
	
	@ApiOperation(value="Retorna todos os Grupos")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Grupo>> findAll() {

		List<Grupo> list = service.findAll();

		return ResponseEntity.ok().body(list);

	}
	
	@ApiOperation(value="Retorna Escalas de até 24 linhas por pagina")
	@RequestMapping(value="/page", method = RequestMethod.GET)
	public ResponseEntity<Page<Grupo>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="direction", defaultValue="ASC") String direction, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy) {

		Page<Grupo> list = service.findPage(page, linesPerPage, direction, orderBy);
		return ResponseEntity.ok().body(list);

	}
}
