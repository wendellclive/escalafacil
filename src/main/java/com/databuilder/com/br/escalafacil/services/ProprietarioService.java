package com.databuilder.com.br.escalafacil.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.databuilder.com.br.escalafacil.domain.Proprietario;
import com.databuilder.com.br.escalafacil.domain.enums.Perfil;
import com.databuilder.com.br.escalafacil.domain.enums.StatusUsuario;
import com.databuilder.com.br.escalafacil.dto.ProprietarioDTO;
import com.databuilder.com.br.escalafacil.dto.ProprietarioNewDTO;
import com.databuilder.com.br.escalafacil.repositories.ProprietarioRepository;
import com.databuilder.com.br.escalafacil.security.UserSS;
import com.databuilder.com.br.escalafacil.services.exceptions.AuthorizationException;
import com.databuilder.com.br.escalafacil.services.exceptions.DataIntegrityException;
import com.databuilder.com.br.escalafacil.services.exceptions.ObjectNotFoundException;

@Service
public class ProprietarioService {

	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private ProprietarioRepository reposit;
	
	public Proprietario find(Integer id) throws ObjectNotFoundException {
		
		UserSS user = UserService.authenticated();
		if (user==null || !user.hasHole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		
		
		Optional<Proprietario> obj = reposit.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Proprietario.class.getName()));
		
	}
	
	@Transactional
	public Proprietario insert(Proprietario obj) {

		obj.setId(null); // faz o método entender que se não houver ID então é uma alteração
		return reposit.save(obj);

	}

	public Proprietario update(Proprietario obj) {

		Proprietario newObj = find(obj.getId());
		updateData(newObj, obj);
		return reposit.save(newObj);

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
	
	public Page<Proprietario> findPage(Integer page, Integer linesPerPage, String direction, String orderBy) {
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		return reposit.findAll(pageRequest);
	}
	
	public Proprietario fromDTO(ProprietarioDTO objDto) {
		return new Proprietario(objDto.getId(), objDto.getNome(), 
				objDto.getEmail(), null, 
				objDto.getDataDeNascimento(), objDto.getDataCadastro(), 
				objDto.getStatusUsuario(), objDto.getTentativasDeAcesso());
	}

	public Proprietario fromDTO(ProprietarioNewDTO objDto) {
		Proprietario prop = new Proprietario(null, objDto.getEmail(), objDto.getNome(), pe.encode(objDto.getSenha()), objDto.getDataCadastro(), objDto.getDataDeNascimento(), StatusUsuario.toEnum(objDto.getStatusUsuario()), objDto.getTentativasDeAcesso());
		return prop;
		
	}

	private void updateData(Proprietario newObj, Proprietario obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
		newObj.setSenha(obj.getSenha());
		newObj.setDataCadastro(obj.getDataCadastro());
		newObj.setDataDeNascimento(obj.getDataDeNascimento());
		newObj.setStatusUsuario(obj.getStatusUsuario());
		newObj.setTentativasDeAcesso(obj.getTentativasDeAcesso());
	}
}
