package com.cognizant.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AuthenticationController {
	@GetMapping("authenticate")
	public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
		Map<String, String> map = new HashMap<>();
		String user = getuser(authHeader);
		String token=generateJwt(user);
		map.put("token", token);
		return map;
	}

	private String getuser(String authHeader) {
		String result[] = authHeader.split(" ");
		return new String(Base64.getDecoder().decode(result[1]));
	}

	private String generateJwt(String user) {
		JwtBuilder builder = Jwts.builder();
		builder.setSubject(user);
		builder.setIssuedAt(new Date());
		builder.setExpiration(new Date((new Date()).getTime() + 1200000));
		builder.signWith(SignatureAlgorithm.HS256, "secretkey");
		String token = builder.compact();
		return token;
	}
}
