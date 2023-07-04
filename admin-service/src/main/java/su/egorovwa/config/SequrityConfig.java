package su.egorovwa.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import su.egorovwa.model.Administrator;
import su.egorovwa.service.AdministratorService;

@Configuration
@RequiredArgsConstructor
public class SequrityConfig {
    private final UserDetailsService userDetailsService;


    @Bean
    SecurityFilterChain securityWebFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizationManager -> authorizationManager
                        .requestMatchers("/auth/**").permitAll()
                        .anyRequest().authenticated()
                )
                .userDetailsService(userDetailsService);
        return http.build();
    }


}
