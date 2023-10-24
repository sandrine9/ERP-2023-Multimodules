package org.example.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpFilter;

@Configuration
public class SecurityConfiguration {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests()
                .antMatchers(HttpMethod.POST, "/api/v1/client").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/devis").permitAll()
                .antMatchers(HttpMethod.GET).permitAll()
                //.antMatchers(HttpMethod.GET).hasRole("USER")
                .anyRequest().denyAll()
                .and()
                .addFilterBefore(new JWTVerify(), UsernamePasswordAuthenticationFilter.class)
                .csrf().disable()
                .formLogin().disable();
          return http.build();
    }
}
