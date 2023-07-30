package su.egorovwa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import su.egorovwa.dto.ErrorApi;
import su.egorovwa.dto.ErrorCode;
import su.egorovwa.exception.ObjectAlredyExistException;
import su.egorovwa.exception.ObjectNotFoundException;

import java.util.Date;

@RestControllerAdvice("su.egorovwa.controller.DriverController")

public class DriverErrrorHendler {
    @ExceptionHandler(ObjectAlredyExistException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorApi alredyExistHending(ObjectAlredyExistException e) {
        return ErrorApi.builder()
                .casus("Driver not found.")
                .exceptionMessage(e.getMessage())
                .timeInMilis(new Date().getTime())
                .errorCode(ErrorCode.ALREDY_EXIST)
                .build();
    }
    @ExceptionHandler(ObjectNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorApi notFoundHandling(ObjectNotFoundException e){
        return ErrorApi.builder()
                .casus("Driver with this phone number not found.")
                .errorCode(ErrorCode.NOT_FOUND)
                .timeInMilis(new Date().getTime())
                .exceptionMessage(e.getMessage())
                .build();
    }
}
