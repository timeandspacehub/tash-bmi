package com.timeandspacehub.configure;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;
import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	 http
         .authorizeHttpRequests(auth -> auth
             .requestMatchers("/", "/public/**").permitAll()   
             .requestMatchers("/bmi/**").authenticated()     
             .anyRequest().authenticated()                      
         )
         .oauth2Login(withDefaults());
     return http.build();
    }
}
