package su.egorovwa.client;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;
import su.egorovwa.dto.DriverShortDto;
import su.egorovwa.dto.NewDriverDto;


import java.io.IOException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class Client {
    private final WebClient webClient;

    public ServerResponse sendRequest(ServerRequest serverRequest) throws Exception {
        Object body = null;
        try {
            serverRequest.body(Object.class);
        }catch (Exception e){

        }
        ClientResponse clientResponse;
        if (body != null){
         clientResponse = webClient.method(serverRequest.method())
                .uri(serverRequest.uri())
                .bodyValue(body)
                .headers(heaters -> heaters.putAll(serverRequest.headers().asHttpHeaders()))
                .exchange().block();
        } else  {
             clientResponse = webClient.method(serverRequest.method())
                    .uri(serverRequest.uri())
                    .headers(heaters -> heaters.putAll(serverRequest.headers().asHttpHeaders()))
                    .exchange().block();
        }
        if (clientResponse != null){

        return ServerResponse.status(clientResponse.statusCode())
                .body(clientResponse.bodyToMono(Object.class));
        }else {
            throw new Exception("ServerResponce is null");
        }


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


    public Object sendGetRequest(String path) {
        return  webClient.method(HttpMethod.GET)
                .uri(path)
                .contentType(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Object.class)
                .block();
    }
}
