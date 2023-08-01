package su.egorovwa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import su.egorovwa.client.Client;
import su.egorovwa.dto.state.DriverStateRequest;
import su.egorovwa.dto.state.DriverStateResponce;

@RestController
@RequiredArgsConstructor
public class OtherController {
    private final Client client;
    @PostMapping("/state/{id}")
    ResponseEntity<DriverStateResponce> statePost(
            @PathVariable("id") String id,
            @RequestBody DriverStateRequest request
    ){
        var body = client.sendDriverStateRequest(id, request);
        return ResponseEntity.status(200)
                .body(body);
    }
}
