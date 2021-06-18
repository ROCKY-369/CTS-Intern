package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;


@Configuration
public class OAuth2 extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetails;
	@Autowired
	private AuthenticationManager authentication;
	
	@Autowired
	private TokenStore tokenStore;
	
	@Autowired
	private JwtAccessTokenConverter jwtAccessTokenConverter;
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
		.withClient("zomato")
		.secret("{noop}secretpassword")
		.authorizedGrantTypes("password", "client credentials", "refresh token")
		.scopes("webclient", "mobileclient");
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
		.tokenStore(tokenStore)
		.accessTokenConverter(jwtAccessTokenConverter)
		.authenticationManager(authentication)
		.userDetailsService(userDetails);
	}

	
}