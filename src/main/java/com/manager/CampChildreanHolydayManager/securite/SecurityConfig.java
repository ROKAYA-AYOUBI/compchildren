package com.manager.CampChildreanHolydayManager.securite;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)  
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private void globalConfig(AuthenticationManagerBuilder  auth,DataSource dataSource) throws Exception {
		
	
		  auth.inMemoryAuthentication().withUser("personne").password("{noop}123").roles( "Personne");
		  auth.inMemoryAuthentication().withUser("admin").password("{noop}123").roles("ADMIN"); 
		  auth.inMemoryAuthentication().withUser("economiste").password("{noop}123").roles("economiste");
		  auth.inMemoryAuthentication().withUser("assistentmedical").password("{noop}123").roles("assistentmedical");
		  auth.inMemoryAuthentication().withUser("moniteur").password("{noop}123").roles("moniteur");
		 
		
		/*
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("select username as principal,password as credentials ,true from users where username=?") 
			.authoritiesByUsernameQuery("select users_username as principal,roles_role as role from users_roles where users_username=?") 
		.rolePrefix("ROLE_") ;*/
			//	.rolePrefix("ROLE_") .passwordEncoder(new Md5PasswordEncoder()); } 
		
	/*@Override
	protected void configure(HttpSecurity http) throws Exception { 
		http.formLogin().loginPage("/login"); 
		http.authorizeRequests().antMatchers("/operations","/consultercompte").hasRole("US ER"); 
		http.authorizeRequests().antMatchers("/saveOperation").hasRole("ADMIN"); 
		http.exceptionHandling().accessDeniedPage("/403"); } }
	- SecurityController package org.sid.sec;*/
		
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers( "/css/**","/img/**","/fonts/**","/js/**","/images/**","/vendor/**","/videos/**").permitAll()
				.antMatchers("/", "/P-Pedaogique","/P-Fixe","/p-General").permitAll() 
				.anyRequest()
					.authenticated()
						.and()
		    .formLogin()
		    	.loginPage("/login")
		    		.permitAll()
		   .defaultSuccessUrl("/")
		   .failureUrl("/error.html");
	}
	
	

	
	
	
	
	
}
