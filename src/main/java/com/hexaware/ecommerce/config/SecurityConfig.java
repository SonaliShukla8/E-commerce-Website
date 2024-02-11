package com.hexaware.ecommerce.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.hexaware.ecommerce.filter.JwtAuthFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	@Autowired
	JwtAuthFilter authFilter;
	
	     @Bean
	    //authentication
	    public UserDetailsService userDetailsService() {
			
	       return new AdminCustomerSellerInfoDetailsService();
	    }
	    
		@Bean
	    public  SecurityFilterChain   getSecurityFilterChain(HttpSecurity http) throws Exception {
	    	
	    		return http.csrf(csrf -> csrf.disable())
                        .authorizeHttpRequests(requests -> requests.requestMatchers("api/customer/register", "api/seller/register", "/api/admin/login/authenticate", "/api/customer/login/authenticate", "/api/seller/login/authenticate").permitAll())
                        .authorizeHttpRequests(requests -> requests.requestMatchers("api/admin/**", "api/customer/**", "api/seller/**")
                                .authenticated())   //.formLogin().and().build();
                        .sessionManagement(management -> management
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                        .authenticationProvider(authenticationProvider())
                        .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
                        .build();
	    	
	    }
	    
	     
	    
	    

	    @Bean    
	    public PasswordEncoder passwordEncoder() {          
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    public AuthenticationProvider authenticationProvider(){
	        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
	        authenticationProvider.setUserDetailsService(userDetailsService());
	        authenticationProvider.setPasswordEncoder(passwordEncoder());
	        return authenticationProvider;
	    }

	    
	    
	    @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
	    	
	    	return config.getAuthenticationManager();
	    	
	    }
	    
	    

}
