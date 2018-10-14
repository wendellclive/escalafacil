package com.databuilder.com.br.escalafacil.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class ProprietarioNewDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String email;
	private String nome;
	private String senha;
	private Date dataDeNascimento;
	private Date dataCadastro;
	private Integer statusUsuario;
	private Integer tentativasDeAcesso;

}
