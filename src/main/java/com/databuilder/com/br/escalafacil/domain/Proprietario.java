package com.databuilder.com.br.escalafacil.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/***
 * 
 * Created by Wendell Clive - email: wendell.clive@gmail.com 14/09/2018
 */

@Data
@Entity
@Table(name = "proprietario")
public class Proprietario implements Serializable {

	private static final long serialVersionUID = -6985558711787239599L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false, length = 100)
	private String email;
	@Column(nullable = false, length = 100)
	private String senha;
	@Column(length = 100)
	private String nome;
	@Column(nullable = false)
	private Date dataDeNascimento;
	@Column(columnDefinition = "smallint", nullable = false)
	private Integer status;
	@Column(columnDefinition = "smallint", nullable = false)
	private Integer tentativasDeAcesso;

}
