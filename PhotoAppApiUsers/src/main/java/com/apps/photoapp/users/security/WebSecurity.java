package com.apps.photoapp.users.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	private Environment environment;

	public WebSecurity(Environment environment) {
		this.environment = environment;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		// http.authorizeRequests().antMatchers("/users/**").permitAll();
		http.authorizeRequests().antMatchers("/users/**").hasIpAddress(environment.getProperty("gateway.ip"));
	}

}
