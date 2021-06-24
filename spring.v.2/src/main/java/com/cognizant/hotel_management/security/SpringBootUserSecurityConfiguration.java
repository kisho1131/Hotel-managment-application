//package com.cognizant.hotel_management.security;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@Order(3)
//public class SpringBootUserSecurityConfiguration extends WebSecurityConfigurerAdapter {
//	@Autowired
//	BCryptPasswordEncoder bCryptPasswordEncoder;
//	
//	@Autowired
//	UserDetailsService userDetailsServiceImpl;
//	
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(bCryptPasswordEncoder);
//	}
//
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		/*http
//			.antMatcher("/**")
//			.authorizeRequests().anyRequest().authenticated()
//			.and().formLogin().loginPage("/login")
//				.defaultSuccessUrl("/dashboard", true)
//				.failureUrl("/accessdenied")
//			.permitAll()
//			.and().logout().logoutSuccessUrl("/login");
//		
//		http.csrf().disable();*/
//		/*http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/user/*").permitAll().anyRequest()
//		.authenticated().and()
//		// .formLogin().and()
//		.httpBasic();*/
//		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/user/*").permitAll().anyRequest()
//		.authenticated().and()
//		// .formLogin().and()
//		.httpBasic();
//	}	
//}
//
