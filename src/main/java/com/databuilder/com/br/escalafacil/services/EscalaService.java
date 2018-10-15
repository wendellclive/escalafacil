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

import com.databuilder.com.br.escalafacil.domain.Escala;
import com.databuilder.com.br.escalafacil.domain.Proprietario;
import com.databuilder.com.br.escalafacil.repositories.EscalaRepository;
import com.databuilder.com.br.escalafacil.security.UserSS;
import com.databuilder.com.br.escalafacil.services.exceptions.AuthorizationException;
import com.databuilder.com.br.escalafacil.services.exceptions.DataIntegrityException;
import com.databuilder.com.br.escalafacil.services.exceptions.ObjectNotFoundException;

@Service
public class EscalaService {

	@Autowired
	private EscalaRepository reposit;

	@Autowired
	private ProprietarioService proprietarioService;

	public Escala find(Integer id) {

		Optional<Escala> obj = reposit.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Escala.class.getName()));

	}

	@Transactional
	public Escala insert(Escala obj) {

		obj.setId(null); // faz o método entender que se não houver ID então é uma alteração
		return reposit.save(obj);

	}

	public Escala update(Escala obj) {

		Escala newObj = find(obj.getId());
		updateData(newObj, obj);
		return reposit.save(newObj);

	}

	public void delete(Integer id) {

		find(id);
		try {
			reposit.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel Excluir um Escala");
		}
	}

	public List<Escala> findAll() {
		return reposit.findAll();
	}

	public Page<Escala> findPage(Integer page, Integer linesPerPage, String direction, String orderBy) {

		UserSS user = UserService.authenticated();

		if (user == null) {
			throw new AuthorizationException("Acesso negado");
		}

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Proprietario proprietario = proprietarioService.find(user.getId());
		return reposit.findByProprietario(proprietario, pageRequest);

	}

	private void updateData(Escala newObj, Escala obj) {
		newObj.setInstituicao(obj.getInstituicao());
		newObj.setFinalidade(obj.getFinalidade());
		newObj.setTitulo(obj.getTitulo());
		newObj.setTipoEscala(obj.getTipoEscala());
		newObj.setDataCriacao(obj.getDataCriacao());
	}

}
