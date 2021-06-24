package com.cognizant.hotel_management.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity

public class SpringBootAnySecurityConfiguration extends WebSecurityConfigurerAdapter {
 
    @Bean
    public UserDetailsService userDetailsService() {
        return new AnyDetailsServiceImpl();
    }
     
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    /*@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/
     
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(bCryptPasswordEncoder);
         
        return authProvider;
    }
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.cors();
        http.authorizeRequests()
            .antMatchers("/user").hasAnyAuthority("USER", "ADMIN")
            .antMatchers("/admin").hasAnyAuthority("ADMIN")
            .anyRequest().authenticated()
            .and()
            .httpBasic();
            
    	/*
    	http.csrf().disable().authorizeRequests()
    	.antMatchers(HttpMethod.OPTIONS, "/**").hasAnyAuthority("ADMIN")
        .anyRequest().authenticated()
        .and()
        .httpBasic();*/
    	
    }
}