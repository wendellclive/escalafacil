package com.databuilder.com.br.escalafacil;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.databuilder.com.br.escalafacil.domain.Grupo;
import com.databuilder.com.br.escalafacil.repositories.GrupoRepository;
import com.databuilder.com.br.escalafacil.services.GrupoService;

/**
 * Classe de teste criada para garantir o funcionamento das principais operações
 * sobre Grupo, realizadas pela classe {@link GrupoService}.
 * 
 * @author Wendell Clive
 * @date 24/09/2018
 */

@RunWith(SpringRunner.class)
public class GerenciadoraGruposTeste {

	@Autowired
	private GrupoRepository grupoRepository;
	
	@Test
	public void insereGruposTeste() {

		/* ========== Montagem do cenário ========== */

		// criando alguns Grupos
		Grupo gru1 = new Grupo(null, "GRUPO 01");
		Grupo gru2 = new Grupo(null, "GRUPO 02");
		Grupo gru3 = new Grupo(null, "GRUPO 03");
		Grupo gru4 = new Grupo(null, "GRUPO 04");
		Grupo gru5 = new Grupo(null, "GRUPO 05");
		Grupo gru6 = new Grupo(null, "GRUPO 06");

		grupoRepository.saveAll(Arrays.asList(gru1, gru2, gru3, gru4, gru5, gru6));
		
		// inserindo os grupos criados na lista de Grupos
	
	}

}
