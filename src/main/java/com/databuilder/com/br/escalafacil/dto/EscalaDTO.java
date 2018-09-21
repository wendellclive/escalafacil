package com.databuilder.com.br.escalafacil.dto;

import java.io.Serializable;
import java.util.Date;

import com.databuilder.com.br.escalafacil.domain.Escala;
import com.databuilder.com.br.escalafacil.domain.enums.TipoEscala;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EscalaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String instituicao;
	private String finalidade;
	private String titulo;
	private TipoEscala tipoEscala;
	private Date DataCriacao;
	
	public EscalaDTO(Escala obj) {
		id = obj.getId();
		instituicao = obj.getInstituicao();
		finalidade = obj.getFinalidade();
		titulo = obj.getTitulo();
		tipoEscala = obj.getTipoEscala();
		DataCriacao = obj.getDataCriacao();
	}
}
