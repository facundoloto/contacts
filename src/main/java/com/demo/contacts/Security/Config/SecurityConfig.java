package com.demo.contacts.Security.Config;

import com.demo.contacts.Security.Jwt.IJWTUtilityServices;
import com.demo.contacts.Security.Jwt.JWTAuthorizationFilter;
import com.demo.contacts.Security.Jwt.JWTUtilityImpl;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {
    @Autowired
    private IJWTUtilityServices jwtUtilityService;
    /**
     * security filter chain
     *
     * @param http http
     * @return {@link SecurityFilterChain}
     * @throws Exception java.lang. exception
     *                   CSRF configuration: Disables CSRF protection.
     *                   Authorization rules: Permits all requests to paths starting with "/auth/" and requires authentication for any other request.
     *                   Session management: Sets the session creation policy to STATELESS, indicating that the application won't create sessions.
     *                   JWTAuthorizationFilter: Adds a custom JWTAuthorizationFilter before the UsernamePasswordAuthenticationFilter in the filter chain. This filter handles JWT authentication.
     *                   Exception handling: Sets up an authentication entry point to handle unauthorized requests.
     * @see SecurityFilterChain
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .cors(Customizer.withDefaults())
                .csrf(csrf ->
                        csrf.disable())
                .authorizeHttpRequests(authRequest ->
                        authRequest
                                .requestMatchers("/auth/**").permitAll()
                                .anyRequest().authenticated()
                )
                .sessionManagement(sessionManager -> sessionManager
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(new JWTAuthorizationFilter((JWTUtilityImpl) jwtUtilityService), UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(exceptionHandling -> exceptionHandling
                        .authenticationEntryPoint((request, response, authException) -> {
                            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
                        }))
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
