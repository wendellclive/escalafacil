package com.databuilder.com.br.escalafacil.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/***
 * 
 * Created by Wendell Clive - email: wendell.clive@gmail.com 14/09/2018
 */

@NoArgsConstructor
@Entity
@Table(name="membro")
@Getter 
@Setter 
public class Membro implements Serializable {

	private static final long serialVersionUID = 5914356445552675840L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;

	@OneToMany(mappedBy="id.membro")
	private Set<EscalaMembros> membrosEscalados = new HashSet<>();
	
	public List<Escala> getEscalas() {
		
		List<Escala> lista = new ArrayList<>();
		
		for(EscalaMembros x : membrosEscalados) {
			lista.add(x.getEscala());
		}
		return lista;
		
	}

	public Membro(Integer id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}
	
}
