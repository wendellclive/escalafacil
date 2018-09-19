package com.databuilder.com.br.escalafacil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/***
 * 
 * Created by Wendell Clive - email: wendell.clive@gmail.com 14/09/2018
 */

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="membro")
public class Membro implements Serializable {

	private static final long serialVersionUID = 5914356445552675840L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Integer id;
	@Column(nullable = false, length = 100)
	@Getter @Setter private String nome;
	@Column(nullable = false, length = 100)
	@Getter @Setter private String email;

}
