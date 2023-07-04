package su.egorovwa.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ClientConfig {
    @Value("${drriver-service.address}")
    private String driverServiceAddress;


    @Bean
    public WebClient webClient(){
        return WebClient.builder()
                .baseUrl(driverServiceAddress)
                .build();
    }
}
