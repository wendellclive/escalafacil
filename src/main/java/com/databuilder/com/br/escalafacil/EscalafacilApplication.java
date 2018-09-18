package com.databuilder.com.br.escalafacil;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.databuilder.com.br.escalafacil.domain.Funcao;
import com.databuilder.com.br.escalafacil.domain.Grupo;
import com.databuilder.com.br.escalafacil.domain.Proprietario;
import com.databuilder.com.br.escalafacil.repositories.FuncaoRepository;
import com.databuilder.com.br.escalafacil.repositories.GrupoRepository;
import com.databuilder.com.br.escalafacil.repositories.ProprietarioRepository;

@SpringBootApplication
public class EscalafacilApplication implements CommandLineRunner {

	@Autowired
	private ProprietarioRepository proprietarioRepository;

	@Autowired
	private GrupoRepository grupoRepository;

	@Autowired
	private FuncaoRepository funcaoRepository;

	public static void main(String[] args) {
		SpringApplication.run(EscalafacilApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Proprietario prop1 = new Proprietario(null, "teste@teste.com.br", "ADEROGILDO DA SILVA", "123456", sdf.parse("09/02/1987 00:00"), 0,0);
		Proprietario prop2 = new Proprietario (null, "teste@teste.com.br", "SIGFREID DA SILVA", "123456", sdf.parse("01/09/1987 00:00"), 0,0);
		Proprietario prop3 = new Proprietario (null, "teste@teste.com.br", "JORGE NAILTON", "123456",sdf.parse("13/12/1990 00:00"), 0,0);
		Proprietario prop4 = new Proprietario (null, "teste@teste.com.br", "LEANDRO LIANDERSON", "123456", sdf.parse("02/05/1980 00:00"), 0,0);
		Proprietario prop5 = new Proprietario (null, "teste@teste.com.br", "CASSIO CASSIANO", "123456", sdf.parse("09/10/2000 00:00"), 0,0);

		proprietarioRepository.saveAll(Arrays.asList(prop1, prop2,prop3, prop4, prop5));
		
		Grupo gru1 = new Grupo(null, "GRUPO 01");
		Grupo gru2 = new Grupo(null, "GRUPO 02");
		Grupo gru3 = new Grupo(null, "GRUPO 03");
		Grupo gru4 = new Grupo(null, "GRUPO 04");
		Grupo gru5 = new Grupo(null, "GRUPO 05");
		Grupo gru6 = new Grupo(null, "GRUPO 06");
		
		grupoRepository.saveAll(Arrays.asList(gru1, gru2, gru3, gru4, gru5, gru6));
		
		Funcao fun1 = new Funcao(null, "LIDER");
		Funcao fun2 = new Funcao(null, "OUVINTE");
		Funcao fun3 = new Funcao(null, "OUVINTE");
		
		funcaoRepository.saveAll(Arrays.asList(fun1, fun2, fun3));
	}
}
