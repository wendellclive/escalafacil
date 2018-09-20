package com.databuilder.com.br.escalafacil.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.databuilder.com.br.escalafacil.domain.enums.TipoEscala;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

/***
 * 
 * Created by Wendell Clive - email: wendell.clive@gmail.com 14/09/2018
 */


@Entity
@Table(name = "escala")
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode
public class Escala implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String instituicao;
	private String finalidade;
	private String titulo;
	private Integer tipoEscala;
	private Date DataCriacao;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "proprietario_id")
	private Proprietario proprietario;

	@OneToMany(mappedBy="id.escala")
	private Set<MembrosEscalados> membrosEscalados = new HashSet<>();
	
	public Escala(Integer id, String instituicao, String finalidade, String titulo, TipoEscala tipoEscala, Date dataCriacao,
			Proprietario proprietario) {
		super();
		this.id = id;
		this.instituicao = instituicao;
		this.finalidade = finalidade;
		this.titulo = titulo;
		this.tipoEscala = tipoEscala.getCodigo();
		DataCriacao = dataCriacao;
		this.proprietario = proprietario;
	}
	
	@NonNull
	public TipoEscala getTipoEscala() {
		return TipoEscala.toEnum(tipoEscala);
	}
	@NonNull
	public void setTipoEscala(TipoEscala tipoEscala) {
		this.tipoEscala = tipoEscala.getCodigo();
	}
}
