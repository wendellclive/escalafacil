package com.databuilder.com.br.escalafacil.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/***
 * 
 * Created by Wendell Clive - email: wendell.clive@gmail.com 14/09/2018
 */


@Entity
@Table(name = "escala")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Escala implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String instituicao;
	private String finalidade;
	private String titulo;
	private String tipo;
	private Date DataCriacao;

	@ManyToOne
	@JoinColumn(name = "proprietario_id")
	private Proprietario proprietario;

}
