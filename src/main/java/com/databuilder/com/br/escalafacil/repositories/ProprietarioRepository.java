package com.databuilder.com.br.escalafacil.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.databuilder.com.br.escalafacil.domain.Proprietario;

/**
 * Created by Wendell Clive Santos de Lira - Email: wendell.clive@gmail.com Data:
 *         14/09/2018
 */

@Repository
public interface ProprietarioRepository extends JpaRepository<Proprietario, Integer> {

	@Transactional(readOnly=true)
	Proprietario findByEmail(String email);
	
}
