package com.milton.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServiceConfiguration extends ResourceServerConfigurerAdapter {

	public void configure(HttpSecurity http) throws Exception {

		http 
			.logout()
			.invalidateHttpSession(true)
			.clearAuthentication(true)
			.and().authorizeRequests()
			.antMatchers("usuario/**").hasAnyRole("ADMIN")
			.anyRequest().denyAll();
		
	}

}
