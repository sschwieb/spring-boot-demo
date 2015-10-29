package com.dius.stephan.springdemo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http
	      .csrf().disable() // Don't do this in real life!
	      .authorizeRequests()
	        .antMatchers(HttpMethod.POST, "/services/**").authenticated()
	        .anyRequest().permitAll()
	        .and()
	      .httpBasic().and() // Basic authentication without https is also a bad idea
	      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	  }
}

