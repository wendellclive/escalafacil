package com.databuilder.com.br.escalafacil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.databuilder.com.br.escalafacil.services.S3Service;

@SpringBootApplication
public class EscalafacilApplication implements CommandLineRunner {

	@Autowired
	private S3Service s3Service;
	
	public static void main(String[] args) {
		SpringApplication.run(EscalafacilApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	
		//s3Service.uploadFile("C:\\Temp\\fotos\\foto1.jpg");
		
		
	}
}
