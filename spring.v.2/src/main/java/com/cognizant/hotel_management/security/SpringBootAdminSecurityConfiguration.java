//package com.cognizant.hotel_management.security;
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
//@Order(2)
//public class SpringBootAdminSecurityConfiguration extends WebSecurityConfigurerAdapter {
//	@Autowired
//	BCryptPasswordEncoder bCryptPasswordEncoder;
//	
//	@Autowired
//	UserDetailsService adminDetailsServiceImpl;
//	
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(adminDetailsServiceImpl).passwordEncoder(bCryptPasswordEncoder);
//	}
//
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		/*http
//			.antMatcher("/admin/**")
//			.authorizeRequests().anyRequest().authenticated()
//			.and().formLogin().loginPage("/admin/login")
//				.defaultSuccessUrl("/admin/dashboard", true)
//				.failureUrl("/admin/accessdenied")
//			.permitAll()
//			.and().logout().logoutUrl("/admin/logout").logoutSuccessUrl("/admin/login")
//			.and().exceptionHandling().accessDeniedPage("/admin/accessdenied");
//			http.csrf().disable();
//			*/
//		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/admin/*").permitAll().anyRequest()
//		.authenticated().and()
//		// .formLogin().and()
//		.httpBasic();
//		http.csrf().disable();
//	}
//}	
