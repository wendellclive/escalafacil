package com.databuilder.com.br.escalafacil.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.databuilder.com.br.escalafacil.security.UserSS;

public class UserService {

	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();	
			}
		catch (Exception e) {
			return null;
		}
	}
}
