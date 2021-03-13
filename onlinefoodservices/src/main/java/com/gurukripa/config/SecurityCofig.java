package com.gurukripa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityCofig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.authenticationProvider(getAuththenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests().antMatchers("/user/**").hasRole("user").antMatchers("/admin/**").hasRole("admin").antMatchers("/**").permitAll().and().csrf().disable();
	}

	@Bean
	protected UserDetailsService userDetailsService() {
		// TODO Auto-generated method stub
		return  new CustomUserDetailService();
	}

	@Bean
public	 BCryptPasswordEncoder getPasswordEncoder()
	{
	return	new BCryptPasswordEncoder();
		
	}
	
	public DaoAuthenticationProvider getAuththenticationProvider()
	{
		DaoAuthenticationProvider dp=new DaoAuthenticationProvider();
		dp.setUserDetailsService(userDetailsService());
		 dp.setPasswordEncoder(getPasswordEncoder());
		return dp;
	}
}
