package com.databuilder.com.br.escalafacil.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.databuilder.com.br.escalafacil.domain.Escala;
import com.databuilder.com.br.escalafacil.domain.Proprietario;

/**
 * Created by Wendell Clive Santos de Lira - Email: wendell.clive@gmail.com Data:
 *         14/09/2018
 */

@Repository
public interface EscalaRepository extends JpaRepository<Escala, Integer> {

	@Transactional(readOnly=true)
	Page<Escala> findByProprietario(Proprietario proprietario, Pageable pageRequest);

}
