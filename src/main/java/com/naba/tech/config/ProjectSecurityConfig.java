package com.naba.tech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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

        http.csrf( (csrf) -> csrf.disable() )
                .authorizeHttpRequests( (requests) ->
                        requests.requestMatchers( "dashboard" ).authenticated()
                                .requestMatchers( "/", "/home" ).permitAll()
                                .requestMatchers( "/holidays/**" ).permitAll()
                                .requestMatchers( "/contact" ).permitAll()
                                .requestMatchers( "/saveMsg" ).permitAll()
                                .requestMatchers( "/courses" ).authenticated()
                                .requestMatchers( "/about" ).permitAll()
                                .requestMatchers( "/assets/**" ).permitAll()
                                .requestMatchers( "/login" ).permitAll())
                .formLogin(loginConfigurer->loginConfigurer.loginPage("/login")
                        .defaultSuccessUrl("/dashboard")
                        .failureUrl("/login?error=true").permitAll())
                .logout(logoutConfigurer->logoutConfigurer.logoutSuccessUrl("/login?login=true")
                        .invalidateHttpSession(true).permitAll())
                .httpBasic( Customizer.withDefaults() );
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService(){

        UserDetails user= User.withDefaultPasswordEncoder()
                .username("naba")
                .password("12345")
                .roles("USERS")
                .build();

        UserDetails admin=User.withDefaultPasswordEncoder()
                .username("nasir")
                .password("54321")
                .roles("USERS","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user,admin);
    }
}
