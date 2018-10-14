package com.databuilder.com.br.escalafacil.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.databuilder.com.br.escalafacil.domain.Proprietario;
import com.databuilder.com.br.escalafacil.dto.ProprietarioNewDTO;
import com.databuilder.com.br.escalafacil.repositories.ProprietarioRepository;
import com.databuilder.com.br.escalafacil.resources.exceptions.FieldMessage;

public class ProprietarioInsertValidator implements ConstraintValidator<ProprietarioInsert, ProprietarioNewDTO> {

	@Autowired
	private ProprietarioRepository reposit;
	
	@Override
	public void initialize(ProprietarioInsert ann) {
	}

	@Override
	public boolean isValid(ProprietarioNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		if (objDto.getStatusUsuario() == null) {
			list.add(new FieldMessage("statusUsuario", "Status não pode ser nulo"));
		}
		
		Proprietario aux = reposit.findByEmail(objDto.getEmail());
		if (aux != null) {
			list.add(new FieldMessage("email", "Email já existente!!"));
		}
		
		// inclua os testes aqui, inserindo erros na lista
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}