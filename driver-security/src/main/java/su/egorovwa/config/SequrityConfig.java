package su.egorovwa.config;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatchers;
import su.egorovwa.security.BearerTokenConverter;
import su.egorovwa.security.JwtHendle;

@Configuration
@EnableWebSecurity

public class SequrityConfig {
    private final UserDetailsService userDetailsService;
    @Value("${security.secret}")
    private String secret;

    public SequrityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityWebFilterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(matcherRegistry -> {
                    matcherRegistry.requestMatchers("/auth/**").permitAll()
                            .anyRequest().authenticated()
                    ;
                })

                .addFilterAt(authenticationFilter(authenticationManager), UsernamePasswordAuthenticationFilter.class)

        ;
        return http.build();
    }

    @Bean
    public AuthenticationFilter authenticationFilter(AuthenticationManager authenticationManager) {
        AuthenticationFilter filter = new AuthenticationFilter(authenticationManager,
                new BearerTokenConverter(new JwtHendle(secret)));
        filter.setRequestMatcher(RequestMatchers.allOf(RequestMatchers.not(AntPathRequestMatcher.antMatcher("/auth/**")),
                RequestMatchers.allOf(AntPathRequestMatcher.antMatcher("/**"))));
        // что делать если успешно
        filter.setSuccessHandler((request, response, authentication) -> response.setStatus(HttpServletResponse.SC_OK));
        return filter;
    }
}

