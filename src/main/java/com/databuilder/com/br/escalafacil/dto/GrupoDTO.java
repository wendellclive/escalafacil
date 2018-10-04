package com.databuilder.com.br.escalafacil.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.databuilder.com.br.escalafacil.domain.Grupo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/***
 * 
 * Created by Wendell Clive - email: wendell.clive@gmail.com 14/09/2018
 */

@NoArgsConstructor
@Getter
@Setter
public class GrupoDTO implements Serializable {

	private static final long serialVersionUID = 5914356445552675840L;

	private Integer id;
	@NotEmpty
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String nome;
	
	public GrupoDTO(Grupo obj) {

		id = obj.getId();
		nome = obj.getNome();
		
	}
}
