package com.bhashitha.springBootApiTemplate.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

public class securityConfig {

    // add support for JDBC ... no more hardcoded users :-)
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager=new JdbcUserDetailsManager(dataSource);

        //define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id=?"
        );
        return jdbcUserDetailsManager;

    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(
                confiturer->confiturer
                        .requestMatchers(HttpMethod.GET,"/api/v1/users").hasRole("USER")
                        .requestMatchers(HttpMethod.GET,"/api/v1/users/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST,"/api/v1/users").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/v1/users").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/v1/users/**").hasRole("ADMIN")

        );
        // use HTTP Basic authentication
        http.httpBasic();

        // disable Cross Site Request Forgery (CSRF)
        // in general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
        http.csrf().disable();

        return http.build();
    }
}
