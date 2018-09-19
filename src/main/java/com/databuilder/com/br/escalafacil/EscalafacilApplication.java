package com.databuilder.com.br.escalafacil;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.databuilder.com.br.escalafacil.domain.Escala;
import com.databuilder.com.br.escalafacil.domain.Grupo;
import com.databuilder.com.br.escalafacil.domain.Membro;
import com.databuilder.com.br.escalafacil.domain.Proprietario;
import com.databuilder.com.br.escalafacil.repositories.EscalaRepository;
import com.databuilder.com.br.escalafacil.repositories.GrupoRepository;
import com.databuilder.com.br.escalafacil.repositories.MembroRepository;
import com.databuilder.com.br.escalafacil.repositories.ProprietarioRepository;

@SpringBootApplication
public class EscalafacilApplication implements CommandLineRunner {

	@Autowired
	private ProprietarioRepository proprietarioRepository;

	@Autowired
	private GrupoRepository grupoRepository;

	@Autowired
	private MembroRepository membroRepository;

	@Autowired
	private EscalaRepository escalaRepository;

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
		
		Grupo gru1 = new Grupo(null, "GRUPO 01");
		Grupo gru2 = new Grupo(null, "GRUPO 02");
		Grupo gru3 = new Grupo(null, "GRUPO 03");
		Grupo gru4 = new Grupo(null, "GRUPO 04");
		Grupo gru5 = new Grupo(null, "GRUPO 05");
		Grupo gru6 = new Grupo(null, "GRUPO 06");
		
		grupoRepository.saveAll(Arrays.asList(gru1, gru2, gru3, gru4, gru5, gru6));
		
		Membro mem1 = new Membro(null, "FULANO DA SILVA SA", "fulano@gmail.com");
		Membro mem2 = new Membro(null, "SICRANO FOFO QUEIRO", "sicrano@gmail.com");
		Membro mem3 = new Membro(null, "BELTRANO OUVINTE FOFO", "beltrano@gmail.com");
		
		membroRepository.saveAll(Arrays.asList(mem1, mem2, mem3));

		Escala esc1 = new Escala(null, "POLICIA MILITAR", "ESCALA DE RUA", "ESCALA DE GUARNICOES", "01", sdf.parse("09/02/1987 00:00"), prop1);
		Escala esc2 = new Escala(null, "ASSEMBLEIA DE DEUS", "ESCALA DE DIACONATO", "DIACONOS ESCALAS", "01", sdf.parse("11/11/1987 00:00"), prop1);
		Escala esc3 = new Escala(null, "GUARDA MUNICIPAL", "ESCALA DE VIGILANCIA", "GUARDAS", "02", sdf.parse("11/11/1987 00:00"), prop2);
		Escala esc4 = new Escala(null, "ASSEMBLEIA DE DEUS", "ESCALA DE CONSELHEIROS", "CONSELHEIRO ESCALAS", "01", sdf.parse("11/11/1987 00:00"), prop2);
		Escala esc5 = new Escala(null, "ESCOLA ESTADUAL X", "ESCALA DE PROFESSORES", "PROFESSORES ESCALAS", "01", sdf.parse("11/11/1987 00:00"), prop2);
		Escala esc6 = new Escala(null, "EXERCITO BRASILEIRO", "ESCALA DE SOLDADOS", "SOLDADO ESCALAS", "01", sdf.parse("11/11/1987 00:00"), prop1);
		
		prop1.getEscalas().addAll(Arrays.asList(esc1, esc2, esc6));
		prop2.getEscalas().addAll(Arrays.asList(esc3, esc4, esc5));

		proprietarioRepository.saveAll(Arrays.asList(prop1, prop2,prop3, prop4, prop5));
		escalaRepository.saveAll(Arrays.asList(esc1, esc2, esc3, esc4, esc5, esc6));		
		
	}
}
