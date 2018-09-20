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

import com.databuilder.com.br.escalafacil.domain.enums.StatusUsuario;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name = "proprietario")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Proprietario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String email;
	private String senha;
	private String nome;
	private Date dataDeNascimento;
	private Date dataCadastro;
	private Integer statusUsuario;
	private Integer tentativasDeAcesso;
	
	@JsonManagedReference
	@OneToMany(mappedBy="proprietario")
	public List<Escala> escalas = new ArrayList<>();
	
	public Proprietario(Integer id, String email, String senha, String nome, Date dataCadastro,Date dataDeNascimento, StatusUsuario statusUsuario,
			Integer tentativasDeAcesso) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.dataCadastro = dataCadastro;
		this.statusUsuario = statusUsuario.getCodigo();
		this.tentativasDeAcesso = tentativasDeAcesso;
	}

	@NonNull
	public StatusUsuario getStatusUsuario() {
		return StatusUsuario.toEnum(statusUsuario);
	}
	@NonNull
	public void setStatusUsuario(StatusUsuario statusUsuario) {
		this.statusUsuario = statusUsuario.getCodigo();
	}
}
