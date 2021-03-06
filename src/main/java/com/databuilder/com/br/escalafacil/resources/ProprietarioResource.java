package com.databuilder.com.br.escalafacil.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.databuilder.com.br.escalafacil.domain.Proprietario;
import com.databuilder.com.br.escalafacil.dto.ProprietarioDTO;
import com.databuilder.com.br.escalafacil.dto.ProprietarioNewDTO;
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

	// Associado ao verbo HTTP
		@ApiOperation(value="Busca Proprietario por Email")
		@RequestMapping(value="/email", method = RequestMethod.GET)
		public ResponseEntity<Proprietario> find(@RequestParam(value="value") String email) {
			
			Proprietario obj = service.findByEmail(email);	
			return ResponseEntity.ok().body(obj);

		}
		
	// Método para chamar Servico de inserir objeto
	@ApiOperation(value="Insere Proprietario")
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ProprietarioNewDTO objDto) {
		Proprietario obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@ApiOperation(value="Atualiza Proprietario")
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ProprietarioDTO objDto, @PathVariable Integer id) {

		Proprietario obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		
		return ResponseEntity.noContent().build();
			
	}


	// Associado ao verbo HTTP
	@ApiOperation(value="Remove Proprietario")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Não é possível excluir um Proprietário que tem Escala criada"),
			@ApiResponse(code = 404, message = "Código inexistente") })
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		service.delete(id);
		return ResponseEntity.noContent().build();

	}
	
	@ApiOperation(value="Retorna todos os Proprietários")
	//@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProprietarioDTO>> findAll() {

		List<Proprietario> list = service.findAll();
		List<ProprietarioDTO> listDto = list.stream().map(obj -> new ProprietarioDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDto);

	}
	
	@ApiOperation(value="Retorna Proprietarios até 24 linhas por pagina")
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/page", method = RequestMethod.GET)
	public ResponseEntity<Page<ProprietarioDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="direction", defaultValue="ASC") String direction, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy) {

		Page<Proprietario> list = service.findPage(page, linesPerPage, direction, orderBy);
		Page<ProprietarioDTO> listDto = list.map(obj -> new ProprietarioDTO(obj));
		return ResponseEntity.ok().body(listDto);

	}
	
	// Método para chamar Servico de inserir objeto
	@ApiOperation(value="Insere Imagem do Profile")
	@RequestMapping(value="/picture", method=RequestMethod.POST)
	public ResponseEntity<Void> uploadProfilePicture(@RequestParam(name="file") MultipartFile file) {

		URI uri = service.uploadProfilePicture(file);
		return ResponseEntity.created(uri).build();
		
	}
	
}
