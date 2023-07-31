package su.egorovwa.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import su.egorovwa.dto.DriverShortDto;
import su.egorovwa.dto.ErrorApi;
import su.egorovwa.dto.ErrorCode;
import su.egorovwa.dto.NewDriverDto;
import su.egorovwa.exception.ServerGetvayClientException;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class Client {
    private final WebClient webClient;
    private final ObjectMapper objectMapper;


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
        try {
            return webClient.get().uri(uriBuilder ->
                            uriBuilder.path("/driver")
                                    .pathSegment(name)
                                    .build()
                    )
                    .retrieve()
                    .bodyToMono(DriverShortDto.class)
                    .map(Optional::ofNullable)
                    .block();
        }catch (WebClientResponseException e){
            return Optional.empty();
        }
    }

    public NewDriverDto registerDriver(NewDriverDto newDriverDto) throws ServerGetvayClientException {
        try {
            return webClient.post()
                    .uri("/driver/register")
                    .bodyValue(newDriverDto)
                    .retrieve()
                    .bodyToMono(NewDriverDto.class)
                    .block();
        } catch (WebClientResponseException e) {
            byte[] responce = e.getResponseBodyAsByteArray();
            try {
                ErrorApi errorApi = objectMapper.readValue(responce, ErrorApi.class);
                throw new ServerGetvayClientException(errorApi, e.getStatusCode().value());
            } catch (IOException ex) {
                throw new ServerGetvayClientException(ErrorApi.builder()
                        .errorCode(ErrorCode.SERVER_ERROR)
                        .casus("Server request empty")
                        .exceptionMessage(e.getMessage())
                        .timeInMilis(new Date().getTime())
                        .build(), 500);
            }

        }
    }
}
