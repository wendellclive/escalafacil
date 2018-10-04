package com.databuilder.com.br.escalafacil.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.databuilder.com.br.escalafacil.domain.Proprietario;
import com.databuilder.com.br.escalafacil.domain.enums.StatusUsuario;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProprietarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotEmpty(message = "Preeenchimento Obrigatório")
	@Length(min=5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
	private String email;
	// @NotEmpty(message="Preeenchimento Obrigatório")
	// @Length(min=5, max=15, message="O tamanho deve ser entre 5 e 15 caracteres")
	private String senha;
	// @NotEmpty(message="Preeenchimento Obrigatório")
	// @Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String nome;
	// @NotEmpty(message="Preeenchimento Obrigatório")
	private Date dataDeNascimento;
	private Date dataCadastro;
	private StatusUsuario statusUsuario;
	private Integer tentativasDeAcesso;

	public ProprietarioDTO(Proprietario obj) {

		id = obj.getId();
		email = obj.getEmail();
		senha = obj.getSenha();
		nome = obj.getNome();
		dataDeNascimento = obj.getDataDeNascimento();
		dataCadastro = obj.getDataCadastro();
		statusUsuario = obj.getStatusUsuario();
		tentativasDeAcesso = obj.getTentativasDeAcesso();
	}

}
