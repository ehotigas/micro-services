package edp.microservices.global;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(
                auth -> auth.requestMatchers(
                    "/public/**",
                    "/docs/**",
                    "/swagger-ui/**"
                ).permitAll().anyRequest().authenticated()
            )
            .oauth2ResourceServer(
                oauth2 -> oauth2.jwt()
            );
        return http.build();
    }
}