package com.dms.document_management.configs;

import com.dms.document_management.managers.implementation.configs.JwtAuthentFilter;
import com.dms.document_management.managers.implementation.user.UserInfoManagerImpl;
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
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

    @Autowired
    private JwtAuthentFilter jwtAuthentFilter;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserInfoManagerImpl();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        return authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable) // disable CSRF protection
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(
                                "/api/dms/login", "/api/dms/register", "/dms/login", "/dms/createUser"
                        ).permitAll() // permit access to login and registration
                        .requestMatchers("/api/dms/**", "/dms/**").authenticated() // require authentication for other URLs
                ).formLogin(login -> login
                        .loginPage("/user/login")
                        .permitAll()
                        .loginProcessingUrl("/user/login")
                        .defaultSuccessUrl("/dms/") // Specify the default success URL after login
                        .failureUrl("/user/login?error=true") // Specify the URL to redirect to if login fails
                )
                .logout(logout -> logout
                        .logoutUrl("/user/logout")
                        .logoutSuccessUrl("/") // Specify the default success URL after logout
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID", "*") // Specify the cookies to delete on logout
                )
                .exceptionHandling(exceptionHandling -> exceptionHandling
                        .accessDeniedPage("/access-denied") // Specify the custom access denied page
                )
                .sessionManagement(sessionManagement -> sessionManagement
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Set session creation policy to STATELESS
                )
                .authenticationProvider(authenticationProvider()) // Assuming you have an authenticationProvider bean
                .addFilterBefore(jwtAuthentFilter, UsernamePasswordAuthenticationFilter.class)
                ;

        return httpSecurity.build();
    }
}

