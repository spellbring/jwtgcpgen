package org.gcp.jwt.jwtgcpgen;

import org.gcp.jwt.jwtgcpgen.jwt.GoogleJwtClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.IOException;

@SpringBootApplication
public class JwtgcpgenApplication {

	@Value("${jwt.file}")
	private static String credentialPath;

	@Value("${jwt.issuer}")
	private static String issuer;

	@Value("${jwt.audience}")
	private static String audience;

	@Value("${jwt.expiry}")
	private static int expiry;


	@Autowired
	private static GoogleJwtClient googleJwtClient;

	public static void main(String[] args) {

		SpringApplication.run(JwtgcpgenApplication.class, args);

		try{

			googleJwtClient.generateJwt(credentialPath, issuer, audience, expiry);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


		System.out.printf("hola");
	}

}
