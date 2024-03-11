package com.example.employee_management_system.configuration;

import com.example.employee_management_system.model.entity.enums.RoleNameEnum;
import com.example.employee_management_system.repository.UserRepository;
import com.example.employee_management_system.service.impl.ApplicationUserDetailServiceImpl;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class AuthorizeUrlsSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        .requestMatchers("/css/**", "/images/**", "/js/**", "/videos/**").permitAll()
                        .requestMatchers("/", "/index", "/users/login-error").permitAll()
                        .requestMatchers("/users/login", "/users/register").anonymous()
                        .requestMatchers("/users/logout", "/", "/index").authenticated()
                        .requestMatchers("/departments", "/employees").hasAnyRole(RoleNameEnum.BOSS.name(), RoleNameEnum.MODERATOR.name())
                        .requestMatchers("/admin").hasRole(RoleNameEnum.BOSS.name())
                        .anyRequest()
                        .authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/users/login").permitAll()
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/")
                        .failureForwardUrl("/users/login-error")
                )
                .logout((logout) -> logout
                        .logoutUrl("/users/logout")
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true)
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new ApplicationUserDetailServiceImpl(userRepository);
    }
}
