package com.timeandspacehub.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
               
                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()

                
                .requestMatchers("/", "/public/**", "/bmi").permitAll()

               
                .requestMatchers("/bmi/**").authenticated()

              
                .anyRequest().authenticated()
            )
            .oauth2Login(oauth2 -> oauth2 
                .defaultSuccessUrl("/swagger-ui/index.html", true) 
            );

        return http.build();
    }
}
