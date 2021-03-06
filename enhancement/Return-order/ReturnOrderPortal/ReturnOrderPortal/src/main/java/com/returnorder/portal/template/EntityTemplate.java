package com.returnorder.portal.template;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class EntityTemplate {
	public HttpEntity<String> getEntity(String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBearerAuth(token);
		
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return entity;
	}
}
