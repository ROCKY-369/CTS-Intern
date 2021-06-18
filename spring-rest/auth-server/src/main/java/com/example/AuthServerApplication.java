package com.example;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableAuthorizationServer // to generate the token based on the user & client credentials
@EnableResourceServer // filter to read the tokens for authentication & authorization 
@RestController
public class AuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServerApplication.class, args);
	}
	// accepts the token & returns the user details, it is usually sent to the protected service
	// OAuth2Authentication will receive the token having client & user information
	@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> user(OAuth2Authentication token) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user", token.getUserAuthentication().getPrincipal());
		map.put("authorities", AuthorityUtils.authorityListToSet(token.getUserAuthentication().getAuthorities()));
		return map;
	}

}