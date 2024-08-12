package com.springboot.hungersolution.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.springboot.hungersolution.Service.CustomAuthenticationSuccessHandler;
import com.springboot.hungersolution.Service.CustomerUserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

	@Autowired
	private CustomerUserService customerUserService;

	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(requests -> requests.antMatchers(
                        "/registration**", "/home/**", "/customer", "/forgot_password", "/js/**", "/css/**", "/images/**", "/scss/**", "/vendor/**", "/menupage/**", "/aboutuspage/**", "/header/**", "/header2/**", "/contactususpage/**", "/savecontactus/**").permitAll()
                		.antMatchers("/admin/**,/admin_dashboard/**").hasRole("ADMIN")
                        .antMatchers("/user/**").hasRole("USER")
                		.anyRequest().authenticated())
                .formLogin(login -> login
                        .loginPage("/login")
		 .successHandler(customAuthenticationSuccessHandler) // Set custom success handler
                        .permitAll()
                        .failureUrl("/login?failure=true"))
                .logout(logout -> logout
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()) 
	    ;
	}   
	  @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
	        auth.userDetailsService(customerUserService).passwordEncoder(passwordEncoder());
	    }
 

}
