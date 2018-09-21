package com.databuilder.com.br.escalafacil.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@EqualsAndHashCode
@Getter
@Setter
public class MembrosEscaladosPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "membro_id")
	private Membro membro;

	@ManyToOne
	@JoinColumn(name = "escala_id")
	private Escala escala;

}
