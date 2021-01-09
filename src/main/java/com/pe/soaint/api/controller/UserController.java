package com.pe.soaint.api.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.csvreader.CsvReader;
import com.pe.soaint.api.dto.User;
import com.pe.soaint.api.type.ResponseUserType;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class UserController {

	@PostMapping("user")
	public ResponseUserType login(@RequestParam("user") String username, @RequestParam("password") String pwd) {

		ResponseUserType response = new ResponseUserType();
		
		try {
			
			boolean validaCredenciales = leerCredenciales(username, pwd);

			if (validaCredenciales) {

				String token = getJWTToken(username);

				response.setTipoMensaje("debug");
				response.setMensaje("Logueo exitoso");
				response.setToken(token);
				
				
			} else {
				response.setTipoMensaje("info");
				response.setMensaje("datos incorrectos en el logueo");
			}

			
		} catch (Exception e) {
			
			response.setTipoMensaje("error");
			response.setMensaje("error");
			
		} finally {
			response.setFechayHora(java.util.Calendar.getInstance().getTime());
			response.setUsuario(username);
		}
		return response;

	}

	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

		String token = Jwts.builder().setId("softtekJWT").setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

		return "Bearer " + token;
	}

	private boolean leerCredenciales(String username, String pwd) {

		boolean valida = false;
		try {
			User usuario = new User();
			List<User> listaCredenciales = new ArrayList<User>();
			CsvReader leerUsuarios = new CsvReader("Usuarios.csv");
			leerUsuarios.readHeaders();

			while (leerUsuarios.readRecord()) {
				usuario.setUser(leerUsuarios.get(0));
				usuario.setPass(leerUsuarios.get(1));

				listaCredenciales.add(usuario);
			}

			leerUsuarios.close();

			for (User user : listaCredenciales) {

				if (username.equalsIgnoreCase(user.getUser()) && pwd.equalsIgnoreCase(user.getPass())) {
					valida = true;
					break;
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return valida;

	}
}
