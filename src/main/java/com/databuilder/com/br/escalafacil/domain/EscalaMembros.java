package com.databuilder.com.br.escalafacil.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class EscalaMembros implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EscalaMembroPK id = new EscalaMembroPK();

	private Date dataHoraInicio;
	private Date dataHoraFim;
	private String funcao;

	public EscalaMembros(Membro membro, Escala escala, Date dataHoraInicio, Date dataHoraFim,
			String funcao) {
		super();
		id.setMembro(membro);
		id.setEscala(escala);
		this.dataHoraInicio = dataHoraInicio;
		this.dataHoraFim = dataHoraFim;
		this.funcao = funcao;
	}

	public Membro getMembro() {
		return id.getMembro();
	}

	public Escala getEscala() {
		return id.getEscala();
	}

	public EscalaMembroPK getId() {
		return id;
	}

	public void setId(EscalaMembroPK id) {
		this.id = id;
	}

	public Date getDataHoraInicio() {
		return dataHoraInicio;
	}

	public void setDataHoraInicio(Date dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}

	public Date getDataHoraFim() {
		return dataHoraFim;
	}

	public void setDataHoraFim(Date dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

}
