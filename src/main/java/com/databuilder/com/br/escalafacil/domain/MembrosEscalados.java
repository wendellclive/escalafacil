package com.databuilder.com.br.escalafacil.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class MembrosEscalados implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private MembrosEscaladosPK id = new MembrosEscaladosPK();

	private Date dataHoraInicio;
	private Date dataHoraFim;
	private String funcao;

	public MembrosEscalados(Membro membro, Escala escala, Date dataHoraInicio, Date dataHoraFim, String funcao) {
		super();
		id.setMembro(membro);
		id.setEscala(escala);
		this.dataHoraInicio = dataHoraInicio;
		this.dataHoraFim = dataHoraFim;
		this.funcao = funcao;
	}

	@JsonIgnore
	public Membro getMembro() {
		return id.getMembro();
	}
	
	@JsonIgnore
	public Escala getEscala() {
		return id.getEscala();
	}

	public MembrosEscaladosPK getId() {
		return id;
	}

	public void setId(MembrosEscaladosPK id) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MembrosEscalados other = (MembrosEscalados) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
