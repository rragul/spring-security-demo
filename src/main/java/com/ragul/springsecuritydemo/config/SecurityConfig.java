package com.ragul.springsecuritydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests(request ->
//                        {
//                            try {
//                                request.requestMatchers("/api/v1/user/add", "/api/v1/user/all")
//                                        .permitAll()
//                                        .anyRequest()
//                                        .authenticated()
//                                        .and()
//                                        .httpBasic();
//                            } catch (Exception e) {
//                                throw new RuntimeException(e);
//                            }
//                        }
//                );
//        return http.build();
//    }

//    allow one post request to /api/v1/user/add
//    allow one get request to /api/v1/user/all
//    allow all other requests to authenticated users
//    use http basic authentication
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(request ->
                        {
                            try {
                                request.requestMatchers("/api/v1/user/add", "/api/v1/user/all")
                                        .permitAll()
                                        .anyRequest()
                                        .authenticated()
                                        .and()
                                        .csrf().disable()
                                        .httpBasic();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                );
        return http.build();
    }



    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
