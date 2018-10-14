package com.databuilder.com.br.escalafacil.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Perfil {

	ADMIN(1, "ROLE_ADMIN"),
	PROPRIETARIO(2, "ROLE_PROPRIETARIO");
	
	private int codigo;
	private String descricao;
	
	public static Perfil toEnum(Integer codigo) {
		
		if (codigo == null) {
			return null;
		}
		for (Perfil x : Perfil.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
			
		}
		throw new IllegalArgumentException("Id inválido: " + codigo);
	}
}
