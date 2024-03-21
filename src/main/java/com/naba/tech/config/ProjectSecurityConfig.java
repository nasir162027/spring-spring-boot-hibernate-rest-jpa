package com.naba.tech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig{

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

//        Configure PermitAll  using Spring Security
//        http.authorizeHttpRequests(requests -> requests.anyRequest().permitAll())
//                .formLogin( Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults());
//    return http.build();

//        Configure denyAll  using Spring Security
//                http.authorizeHttpRequests(requests -> requests.anyRequest().denyAll())
//                .formLogin( Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults());
//    return http.build();

        http.csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((requests) -> requests.requestMatchers("/", "/home").permitAll()
                        .requestMatchers("/holidays/**").permitAll()
                        .requestMatchers("/contact").permitAll()
                        .requestMatchers("/saveMsg").permitAll()
                        .requestMatchers("/courses").authenticated()
                        .requestMatchers("/about").permitAll()
                        .requestMatchers("/assets/**").permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
