package com.timeandspacehub.configure;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfigurationSource;





@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		    http.cors(cors -> {}) // enable CORS
		        .csrf(csrf -> csrf.disable())
		        .authorizeHttpRequests
		         (auth -> auth.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll() // allow preflight
	                     .requestMatchers("/public/**").permitAll()
	                     .anyRequest().authenticated() // all others require login
	             )
		        .oauth2Login(oauth2 -> oauth2
		            .defaultSuccessUrl("/welcome", true) // after Azure login
//		           
//			        .oauth2Login(oauth2 -> oauth2.defaultSuccessUrl("http://localhost:4200", true))
//					.logout(logout -> logout.logoutSuccessUrl("/public/test"));
		        )
		        .logout(logout -> logout
		                .logoutSuccessUrl("/logout") // backtowelcome.html
		        );
		return http.build();
	}
	 @Bean
	    public CorsConfigurationSource corsConfigurationSource() {
	        CorsConfiguration configuration = new CorsConfiguration();
	        configuration.setAllowedOrigins(List.of("http://localhost:4200")); // your Angular origin
	        configuration.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS"));
	        configuration.setAllowedHeaders(List.of("*"));
	        configuration.setAllowCredentials(true); 
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", configuration);
	        return source;
	    }
}
