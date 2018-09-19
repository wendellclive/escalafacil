package com.databuilder.com.br.escalafacil.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusUsuario {

	ATIVO(1, "Ativo"),
	INATIVO(2, "Inativo"),
	BLOQUEADO(3, "Bloqueado");
	
	private int codigo;
	private String descricao;
	
	public static StatusUsuario toEnum(Integer codigo) {
		
		if (codigo == null) {
			return null;
		}
		for (StatusUsuario x : StatusUsuario.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
			
		}
		throw new IllegalArgumentException("Id inválido: " + codigo);
	}
}
