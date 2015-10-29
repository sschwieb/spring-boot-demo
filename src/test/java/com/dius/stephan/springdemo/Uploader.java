package com.dius.stephan.springdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.dius.stephan.springdemo.models.Cat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Uploader {
 
    private static final String UPLOAD_URL = "http://localhost:8080/services/upload";
    
    private RestTemplate template = new RestTemplate();
    private ObjectMapper mapper = new ObjectMapper();
    private LinkedMultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
    
    public Uploader() {
    	// Encoded version of "user:password", as set in application.properties
    	headers.set(HttpHeaders.AUTHORIZATION, "Basic dXNlcjpwYXNzd29yZA==");
	}
    
    @Test
    @Ignore("This is not a test, just a convenient way to populate the database")
    public void upload() throws JsonProcessingException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/cats.json")));
    	br.lines().forEach(line -> uploadCat(line));
    }

	private void uploadCat(String line) {
		try {
			Cat cat = mapper.readValue(line, Cat.class);
			template.exchange(UPLOAD_URL, HttpMethod.POST, new HttpEntity<Cat>(cat, headers), Void.class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
