package su.egorovwa.exception;

import org.springframework.http.HttpStatus;

public class AppException extends Exception {
    HttpStatus httpStatus;

    public AppException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
