package su.egorovwa.client;

import jakarta.servlet.ServletException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import su.egorovwa.dto.DriverShortDto;
import su.egorovwa.dto.NewDriverDto;


import java.io.IOException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class Client {
    private final WebClient webClient;

    public ServerResponse sendRequest(ServerRequest serverRequest) throws ServletException, IOException {
        ClientResponse clientResponse = webClient.method(serverRequest.method())
                .uri(serverRequest.uri())
                .bodyValue(serverRequest.bodyToMono(Object.class))
                .headers(heaters -> heaters.putAll(serverRequest.headers().asHttpHeaders()))
                .exchange().block();
        return ServerResponse.status(clientResponse.statusCode())
                .body(clientResponse.bodyToMono(Object.class), Object.class)
                .doFinally(it -> {
                    log.info("Responce from {} with status {}", serverRequest.uri(), clientResponse.statusCode());
                })
                .block();
    }

    public Optional<DriverShortDto> findDriverByName(String name) {
        return webClient.get().uri(uriBuilder ->
                        uriBuilder.path("/driver")
                                .pathSegment(name)
                                .build()
                )
                .retrieve()
                .bodyToMono(DriverShortDto.class)
                .map(Optional::ofNullable)
                .block();
    }

    public NewDriverDto registerDriver(NewDriverDto newDriverDto) {
        return webClient.post()
                .uri("/driver/register")
                .bodyValue(newDriverDto)
                .retrieve()
                .bodyToMono(NewDriverDto.class)
                .block();
    }
}
