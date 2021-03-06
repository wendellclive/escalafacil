package com.databuilder.com.br.escalafacil.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.databuilder.com.br.escalafacil.domain.enums.Perfil;
import com.databuilder.com.br.escalafacil.domain.enums.StatusUsuario;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/***
 * 
 * Created by Wendell Clive - email: wendell.clive@gmail.com 14/09/2018
 */

@Entity
@Table(name = "proprietario")
@Getter
@Setter
@EqualsAndHashCode
public class Proprietario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique=true)
	private String email;
	private String nome;

	@JsonIgnore
	private String senha;
	private Date dataDeNascimento;
	private Date dataCadastro;
	private Integer statusUsuario;
	private Integer tentativasDeAcesso;

	@OneToMany(mappedBy = "proprietario")
	public List<Escala> escalas = new ArrayList<>();

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "perfis")
	private Set<Integer> perfis = new HashSet<>();
	
	public Proprietario() {
		addPerfil(Perfil.PROPRIETARIO);
	}

	public Proprietario(Integer id, String email, String nome, String senha, Date dataCadastro, Date dataDeNascimento,
			StatusUsuario statusUsuario, Integer tentativasDeAcesso) {
		super();
		this.id = id;
		this.email = email;
		this.nome = nome;
		this.senha = senha;
		this.dataDeNascimento = dataDeNascimento;
		this.dataCadastro = dataCadastro;
		this.statusUsuario = statusUsuario.getCodigo();
		this.tentativasDeAcesso = tentativasDeAcesso;
		addPerfil(Perfil.PROPRIETARIO);
	}

	@NonNull
	public StatusUsuario getStatusUsuario() {
		return StatusUsuario.toEnum(statusUsuario);
	}

	@NonNull
	public void setStatusUsuario(StatusUsuario statusUsuario) {
		this.statusUsuario = statusUsuario.getCodigo();
	}

	@NonNull
	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	@NonNull
	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCodigo());

	}

}
