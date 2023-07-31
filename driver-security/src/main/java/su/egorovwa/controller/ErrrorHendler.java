package su.egorovwa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.function.ServerResponse;
import su.egorovwa.dto.ErrorApi;
import su.egorovwa.dto.ErrorCode;
import su.egorovwa.exception.AuthException;
import su.egorovwa.exception.ServerGetvayClientException;

import java.util.Date;
import java.util.Optional;

@RestControllerAdvice("su.egorovwa.controller")
public class ErrrorHendler {
    @ExceptionHandler(ServerGetvayClientException.class)
    public ResponseEntity<ErrorApi> serverExcweptionEndle(ServerGetvayClientException e) {
        return ResponseEntity.status(e.getStatus())
                .body(e.getErrorApi());
    }
    @ExceptionHandler(AuthException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorApi onAuthException(AuthException e){
        return ErrorApi.builder()
                .timeInMilis(new Date().getTime())
                .errorCode(ErrorCode.AUTH_ERROR)
                .casus("Password or phone incorrect")
                .exceptionMessage(e.getMessage())
                .build();
    }

}
