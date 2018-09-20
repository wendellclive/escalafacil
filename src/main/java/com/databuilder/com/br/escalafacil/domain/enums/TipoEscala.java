package com.databuilder.com.br.escalafacil.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoEscala {

	DIARIA(1, "Diaria"),
	SEMANAL(2, "Semanal"),
	E12H24H(3, "12H x 24H"),
	E12H36H(4, "12H x 36H"),
	E12H72H(5, "12H x 72H"),
	E24H24H(6, "24H x 24H"),
	E24H48H(7, "24H x 48H"),
	E24H72H(8, "48H x 48H");
	
	private int codigo;
	private String descricao;
	
	public static TipoEscala toEnum(Integer codigo) {
		
		if (codigo == null) {
			return null;
		}
		for (TipoEscala x : TipoEscala.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
			
		}
		throw new IllegalArgumentException("Id inválido: " + codigo);
	}
}
