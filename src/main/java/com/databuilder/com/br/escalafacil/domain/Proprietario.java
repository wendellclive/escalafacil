package com.databuilder.com.br.escalafacil.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
@Getter
@Setter
@Table(name = "proprietario")
public class Proprietario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String email;
	private String senha;
	private String nome;
	private Date dataDeNascimento;
	private Integer status;
	private Integer tentativasDeAcesso;

	@OneToMany(mappedBy="proprietario")
	public List<Escala> escalas = new ArrayList<>();

	public Proprietario(Integer id, String email, String senha, String nome, Date dataDeNascimento, Integer status,
			Integer tentativasDeAcesso) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.status = status;
		this.tentativasDeAcesso = tentativasDeAcesso;
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
		Proprietario other = (Proprietario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
