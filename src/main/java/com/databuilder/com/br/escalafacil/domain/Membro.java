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

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@JsonIgnore
	@OneToMany(mappedBy="id.membro")
	private Set<MembrosEscalados> membrosEscalados = new HashSet<>();
	
	@JsonIgnore
	public List<Escala> getEscalas() {
		
		List<Escala> lista = new ArrayList<>();
		
		for(MembrosEscalados x : membrosEscalados) {
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
		Membro other = (Membro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
