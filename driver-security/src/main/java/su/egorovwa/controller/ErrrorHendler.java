package su.egorovwa.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.function.ServerResponse;
import su.egorovwa.dto.ErrorApi;
import su.egorovwa.exception.ServerGetvayClientException;

import java.util.Optional;

@RestControllerAdvice("su.egorovwa.controller")
public class ErrrorHendler {
    @ExceptionHandler(ServerGetvayClientException.class)
    public ResponseEntity<ErrorApi> serverExcweptionEndle(ServerGetvayClientException e) {
        return ResponseEntity.status(e.getStatus())
                .body(e.getErrorApi());
    }

}
