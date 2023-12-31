package com.example.demo.springboot.config;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.demo.springboot.service.CustomUserDetailService;


@Configuration
@EnableWebSecurity
public class MySequirityConfig extends WebSecurityConfigurerAdapter
{		
		@Autowired
		private CustomUserDetailService customUserDetailService;
	
		@Autowired
		private JwtAuthenticationFilter jwtAuthenticationFilter;
		
		@Autowired
		private JwtAuthenticationEntryPoint entryPoint;
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			// TODO Auto-generated method stub
			auth.userDetailsService(customUserDetailService);
		}
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
				
			http
					.csrf()
					.disable()
					.cors()
					.disable()
					.authorizeRequests()
					.antMatchers("/token","/getreview","/count","/adminproducts","/updatereviewdelete","/login","/register","/adminlogin","/updatereview")
					
					.permitAll()
					.antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
					.anyRequest().authenticated()
					.and()
					.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
					.and()
					.exceptionHandling().authenticationEntryPoint(entryPoint);
					http.headers().addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Origin", "*"));
			http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
			
			;
		}
		
//		@Bean
//		public PasswordEncoder passwordEncoder() 
//		{
//			return NoOpPasswordEncoder.getInstance();
//		}
//		
		@Bean
		public AuthenticationManager authenticationManagerBean() throws Exception 
		{
			return super.authenticationManagerBean();
		}
	
		@Bean
	    public PasswordEncoder passwordEncoder() {
	        PasswordEncoder encoder = new BCryptPasswordEncoder();
	        return encoder;
	    }

}
