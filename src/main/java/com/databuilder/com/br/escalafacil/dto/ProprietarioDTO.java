package com.databuilder.com.br.escalafacil.dto;

import java.io.Serializable;
import java.util.Date;

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
	private String email;
	private String senha;
	private String nome;
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
