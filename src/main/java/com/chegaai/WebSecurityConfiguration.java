package com.chegaai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.chegaai.authentication.AuthenticationFilter;
import com.chegaai.authentication.AuthenticationLoginFilter;
import com.chegaai.user.UserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
    private ChegaAiAuthenticationEntryPoint authenticationEntryPoint;

    @Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().cors().and()
            .exceptionHandling().authenticationEntryPoint(this.authenticationEntryPoint)
            .and()
            .authorizeRequests()
			.antMatchers(HttpMethod.POST, "/user").permitAll()
			.antMatchers("/login", "/login/facebook").permitAll()
			.anyRequest().authenticated()
			.and()

			.addFilterBefore(new AuthenticationLoginFilter("/login", authenticationManager()), 
					UsernamePasswordAuthenticationFilter.class)
			
			.addFilterBefore(new AuthenticationFilter(), 
					UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {	
		auth
			.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder());
	}

	private PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
