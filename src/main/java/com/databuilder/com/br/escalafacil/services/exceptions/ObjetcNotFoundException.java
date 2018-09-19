package com.databuilder.com.br.escalafacil.services.exceptions;

public class ObjetcNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ObjetcNotFoundException(String msg) {
		super(msg);
	}
	
	public ObjetcNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
