package com.databuilder.com.br.escalafacil.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.databuilder.com.br.escalafacil.domain.Proprietario;
import com.databuilder.com.br.escalafacil.dto.ProprietarioDTO;
import com.databuilder.com.br.escalafacil.repositories.ProprietarioRepository;
import com.databuilder.com.br.escalafacil.resources.exceptions.FieldMessage;

public class ProprietarioUpdateValidator implements ConstraintValidator<ProprietarioUpdate, ProprietarioDTO> {

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private ProprietarioRepository reposit;
	
	@Override
	public void initialize(ProprietarioUpdate ann) {
	}

	@Override
	public boolean isValid(ProprietarioDTO objDto, ConstraintValidatorContext context) {

		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));

		List<FieldMessage> list = new ArrayList<>();

		if (objDto.getStatusUsuario() == null) {
			list.add(new FieldMessage("statusUsuario", "Status não pode ser nulo"));
		}
		
		Proprietario aux = reposit.findByEmail(objDto.getEmail());
		if (aux != null && !aux.getId().equals(uriId)) {
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