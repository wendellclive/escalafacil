package com.databuilder.com.br.escalafacil.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.databuilder.com.br.escalafacil.domain.Escala;
import com.databuilder.com.br.escalafacil.domain.Grupo;
import com.databuilder.com.br.escalafacil.domain.Membro;
import com.databuilder.com.br.escalafacil.domain.MembrosEscalados;
import com.databuilder.com.br.escalafacil.domain.Proprietario;
import com.databuilder.com.br.escalafacil.domain.enums.Perfil;
import com.databuilder.com.br.escalafacil.domain.enums.StatusUsuario;
import com.databuilder.com.br.escalafacil.domain.enums.TipoEscala;
import com.databuilder.com.br.escalafacil.repositories.EscalaRepository;
import com.databuilder.com.br.escalafacil.repositories.GrupoRepository;
import com.databuilder.com.br.escalafacil.repositories.MembroRepository;
import com.databuilder.com.br.escalafacil.repositories.MembrosEscaladosRepository;
import com.databuilder.com.br.escalafacil.repositories.ProprietarioRepository;

@Service
public class DBService {

	@Autowired
	private BCryptPasswordEncoder pe;

	@Autowired
	private ProprietarioRepository proprietarioRepository;

	@Autowired
	private GrupoRepository grupoRepository;

	@Autowired
	private MembroRepository membroRepository;

	@Autowired
	private EscalaRepository escalaRepository;

	@Autowired
	private MembrosEscaladosRepository membrosEscaladosRepository;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	public void instantiateTestDatabase() throws ParseException {

		Proprietario prop1 = new Proprietario(null, "teste@teste.com.br", "ADEROGILDO DA SILVA", pe.encode("123456"),
				new Date(), sdf.parse("09/02/1987 00:00"), StatusUsuario.ATIVO, 0);
		Proprietario prop2 = new Proprietario(null, "teste@teste1.com.br", "SIGFREID DA SILVA", pe.encode("123456"),
				new Date(), sdf.parse("09/02/1987 00:00"), StatusUsuario.ATIVO, 0);
		Proprietario prop3 = new Proprietario(null, "teste@teste2.com.br", "JORGE NAILTON", pe.encode("123456"),
				new Date(), sdf.parse("09/02/1987 00:00"), StatusUsuario.BLOQUEADO, 0);
		Proprietario prop4 = new Proprietario(null, "teste@teste3.com.br", "LEANDRO LIANDERSON", pe.encode("123456"),
				new Date(), sdf.parse("09/02/1987 00:00"), StatusUsuario.INATIVO, 0);
		Proprietario prop5 = new Proprietario(null, "teste@teste4.com.br", "CASSIO CASSIANO", pe.encode("123456"),
				new Date(), sdf.parse("09/02/1987 00:00"), StatusUsuario.BLOQUEADO, 0);
		Proprietario prop6 = new Proprietario(null, "teste@teste5.com.br", "PEREIRA CASSIANO", pe.encode("123456"),
				new Date(), sdf.parse("09/02/1987 00:00"), StatusUsuario.BLOQUEADO, 0);
		Proprietario prop7 = new Proprietario(null, "teste@teste6.com.br", "SALVIO SILVA", pe.encode("123456"),
				new Date(), sdf.parse("09/02/1987 00:00"), StatusUsuario.BLOQUEADO, 0);
		Proprietario prop8 = new Proprietario(null, "teste@teste7.com.br", "CARLOS ALITNO", pe.encode("123456"),
				new Date(), sdf.parse("09/02/1987 00:00"), StatusUsuario.BLOQUEADO, 0);
		Proprietario prop9 = new Proprietario(null, "teste@teste8.com.br", "JOSEFA FERREIRA", pe.encode("123456"),
				new Date(), sdf.parse("09/02/1987 00:00"), StatusUsuario.BLOQUEADO, 0);
		Proprietario prop10 = new Proprietario(null, "teste@teste9.com.br", "LACAIOS PARREIRA", pe.encode("123456"),
				new Date(), sdf.parse("09/02/1987 00:00"), StatusUsuario.BLOQUEADO, 0);
		Proprietario prop11 = new Proprietario(null, "teste@teste10.com.br", "JOSE FERNANDO RIBEIRA", pe.encode("123456"),
				new Date(), sdf.parse("09/02/1987 00:00"), StatusUsuario.BLOQUEADO, 0);
		Proprietario prop12 = new Proprietario(null, "teste@teste11.com.br", "GABRIEL CELESTINO", pe.encode("123456"),
				new Date(), sdf.parse("09/02/1987 00:00"), StatusUsuario.BLOQUEADO, 0);
		Proprietario prop13 = new Proprietario(null, "teste@teste12.com.br", "CASSIA CELESTINO", pe.encode("123456"),
				new Date(), sdf.parse("09/02/1987 00:00"), StatusUsuario.BLOQUEADO, 0);
		Proprietario prop14 = new Proprietario(null, "teste@teste13.com.br", "WENDELL CLIVE", pe.encode("123456"),
				new Date(), sdf.parse("09/02/1987 00:00"), StatusUsuario.BLOQUEADO, 0);
		Proprietario prop15 = new Proprietario(null, "teste@teste14.com.br", "REBEKAH CELESTINO", pe.encode("123456"),
				new Date(), sdf.parse("09/02/1987 00:00"), StatusUsuario.BLOQUEADO, 0);
		Proprietario prop16 = new Proprietario(null, "teste@teste15.com.br", "MARIA DO SOCORRO PINTO",
				pe.encode("123456"), new Date(), sdf.parse("09/02/1987 00:00"), StatusUsuario.BLOQUEADO, 0);
		Proprietario prop17 = new Proprietario(null, "wendell.clive@gmail.com", "WENDELL CLIVE SANTOS DE LIRA",
				pe.encode("123"), new Date(), sdf.parse("09/02/1987 00:00"), StatusUsuario.ATIVO, 0);
		prop17.addPerfil(Perfil.ADMIN);

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
		Membro mem4 = new Membro(null, "JOAO HENRIQUE", "beltrano@gmail.com");
		Membro mem5 = new Membro(null, "APOLINO SABINO", "beltrano@gmail.com");

		membroRepository.saveAll(Arrays.asList(mem1, mem2, mem3, mem4, mem5));

		Escala esc1 = new Escala(null, "POLICIA MILITAR", "ESCALA DE RUA", "ESCALA DE GUARNICOES", TipoEscala.DIARIA,
				sdf.parse("09/02/1987 00:00"), prop1);
		Escala esc2 = new Escala(null, "ASSEMBLEIA DE DEUS", "ESCALA DE DIACONATO", "DIACONOS ESCALAS",
				TipoEscala.SEMANAL, sdf.parse("11/11/1987 00:00"), prop1);
		Escala esc3 = new Escala(null, "GUARDA MUNICIPAL", "ESCALA DE VIGILANCIA", "GUARDAS", TipoEscala.E12H24H,
				sdf.parse("11/11/1987 00:00"), prop2);
		Escala esc4 = new Escala(null, "ASSEMBLEIA DE DEUS", "ESCALA DE CONSELHEIROS", "CONSELHEIRO ESCALAS",
				TipoEscala.E24H24H, sdf.parse("11/11/1987 00:00"), prop2);
		Escala esc5 = new Escala(null, "ESCOLA ESTADUAL X", "ESCALA DE PROFESSORES", "PROFESSORES ESCALAS",
				TipoEscala.E24H48H, sdf.parse("11/11/1987 00:00"), prop2);
		Escala esc6 = new Escala(null, "EXERCITO BRASILEIRO", "ESCALA DE SOLDADOS", "SOLDADO ESCALAS",
				TipoEscala.SEMANAL, sdf.parse("11/11/1987 00:00"), prop1);

		prop1.getEscalas().addAll(Arrays.asList(esc1, esc2, esc6));
		prop2.getEscalas().addAll(Arrays.asList(esc3, esc4, esc5));

		proprietarioRepository.saveAll(Arrays.asList(prop1, prop2, prop3, prop4, prop5, prop6, prop7, prop8, prop9,
				prop10, prop11, prop12, prop13, prop14, prop15, prop16, prop17));
		escalaRepository.saveAll(Arrays.asList(esc1, esc2, esc3, esc4, esc5, esc6));

		MembrosEscalados mesc1 = new MembrosEscalados(mem1, esc1, sdf.parse("20/09/2018 08:00"),
				sdf.parse("20/09/2018 18:00"), "PROFESSOR");
		MembrosEscalados mesc2 = new MembrosEscalados(mem1, esc2, sdf.parse("21/09/2018 08:00"),
				sdf.parse("21/09/2018 18:00"), "PROFESSOR");
		MembrosEscalados mesc3 = new MembrosEscalados(mem2, esc3, sdf.parse("19/09/2018 08:00"),
				sdf.parse("19/09/2018 18:00"), "PROFESSOR");
		MembrosEscalados mesc4 = new MembrosEscalados(mem2, esc4, sdf.parse("19/09/2018 08:00"),
				sdf.parse("19/09/2018 18:00"), "PROFESSOR");
		MembrosEscalados mesc5 = new MembrosEscalados(mem3, esc1, sdf.parse("20/09/2018 08:00"),
				sdf.parse("20/09/2018 18:00"), "PROFESSOR");
		MembrosEscalados mesc6 = new MembrosEscalados(mem3, esc2, sdf.parse("21/09/2018 08:00"),
				sdf.parse("21/09/2018 18:00"), "PROFESSOR");
		MembrosEscalados mesc7 = new MembrosEscalados(mem4, esc3, sdf.parse("19/09/2018 08:00"),
				sdf.parse("19/09/2018 18:00"), "PROFESSOR");
		MembrosEscalados mesc8 = new MembrosEscalados(mem4, esc4, sdf.parse("19/09/2018 08:00"),
				sdf.parse("19/09/2018 18:00"), "PROFESSOR");
		MembrosEscalados mesc9 = new MembrosEscalados(mem5, esc5, sdf.parse("19/09/2018 08:00"),
				sdf.parse("19/09/2018 18:00"), "PROFESSOR");
		MembrosEscalados mesc10 = new MembrosEscalados(mem5, esc6, sdf.parse("19/09/2018 08:00"),
				sdf.parse("19/09/2018 18:00"), "PROFESSOR");
		MembrosEscalados mesc11 = new MembrosEscalados(mem1, esc1, sdf.parse("20/09/2018 08:00"),
				sdf.parse("20/09/2018 18:00"), "PROFESSOR");
		MembrosEscalados mesc12 = new MembrosEscalados(mem2, esc1, sdf.parse("20/09/2018 08:00"),
				sdf.parse("20/09/2018 18:00"), "PROFESSOR");
		MembrosEscalados mesc13 = new MembrosEscalados(mem3, esc1, sdf.parse("20/09/2018 08:00"),
				sdf.parse("20/09/2018 18:00"), "PROFESSOR");

		mem1.getMembrosEscalados().addAll(Arrays.asList(mesc1, mesc2, mesc11));
		mem2.getMembrosEscalados().addAll(Arrays.asList(mesc3, mesc4, mesc12));
		mem3.getMembrosEscalados().addAll(Arrays.asList(mesc5, mesc6, mesc13));
		mem4.getMembrosEscalados().addAll(Arrays.asList(mesc7, mesc8));
		mem5.getMembrosEscalados().addAll(Arrays.asList(mesc9, mesc10));

		esc1.getMembrosEscalados().addAll(Arrays.asList(mesc1, mesc5, mesc11, mesc12, mesc13));
		esc2.getMembrosEscalados().addAll(Arrays.asList(mesc2, mesc6));
		esc3.getMembrosEscalados().addAll(Arrays.asList(mesc3, mesc7));
		esc4.getMembrosEscalados().addAll(Arrays.asList(mesc4, mesc8));
		esc5.getMembrosEscalados().addAll(Arrays.asList(mesc9));
		esc6.getMembrosEscalados().addAll(Arrays.asList(mesc10));

		membrosEscaladosRepository.saveAll(Arrays.asList(mesc1, mesc2, mesc3, mesc4, mesc5, mesc6, mesc7, mesc8, mesc9,
				mesc10, mesc11, mesc12, mesc13));

	}
}
