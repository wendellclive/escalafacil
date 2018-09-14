package com.databuilder.com.br.escalafacil.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.databuilder.com.br.escalafacil.domain.Proprietario;

@Repository
public interface ProprietarioRepositories extends JpaRepository<Proprietario, Integer> {

}
