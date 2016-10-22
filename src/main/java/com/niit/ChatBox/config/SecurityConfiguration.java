package com.niit.ChatBox.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
	public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
		@Autowired
		DataSource dataSource;
		
		@Autowired
		public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
	             System.out.println("Inside the configauthentication");
	             System.out.println("data source:"+dataSource);
		  auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery(
				"select emailid,password,enabled from applicationuser where emailid=?")
			.authoritiesByUsernameQuery(
				"select u1.emailid, u2.authority from applicationuser u1, userrole u2 where u1.userid = u2.userid and u1.emailid =?");
		}
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			 System.out.println("Inside the configure");
		  http.authorizeRequests()
			.antMatchers("/user/**").access("hasRole('ROLE_USER')")
			.and()
			  .formLogin().loginPage("/login").loginProcessingUrl("/j_spring_security_check").defaultSuccessUrl("/user").failureUrl("/log?error").usernameParameter("username").passwordParameter("password")
			.and()
			  .logout().logoutSuccessUrl("/log?logout")
			.and()
			  .exceptionHandling().accessDeniedPage("/403")
			.and()
			  .csrf();
		  
		  http.authorizeRequests()
			.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
			.and()
			  .formLogin().loginPage("/login").loginProcessingUrl("/j_spring_security_check").defaultSuccessUrl("/admin").failureUrl("/log?error").usernameParameter("username").passwordParameter("password")
			.and()
			  .logout().logoutSuccessUrl("/log?logout")
			.and()
			  .exceptionHandling().accessDeniedPage("/403")
			.and()
			  .csrf();
		  
		  System.out.println("endof configure");
		}
}
