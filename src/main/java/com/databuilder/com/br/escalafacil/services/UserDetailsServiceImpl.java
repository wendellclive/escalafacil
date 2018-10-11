package com.databuilder.com.br.escalafacil.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.databuilder.com.br.escalafacil.domain.Proprietario;
import com.databuilder.com.br.escalafacil.repositories.ProprietarioRepository;
import com.databuilder.com.br.escalafacil.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private ProprietarioRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Proprietario prop = repo.findByEmail(email);
		
		if (prop == null) {
			throw new UsernameNotFoundException(email);
		}
		
		return new UserSS(prop.getId(), prop.getEmail(), prop.getSenha(), prop.getPerfis());
	}

}
