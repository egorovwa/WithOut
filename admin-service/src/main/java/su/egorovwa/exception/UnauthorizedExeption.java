package su.egorovwa.exception;

import org.springframework.http.HttpStatus;

public class UnauthorizedExeption extends RuntimeException{
    private final HttpStatus httpStatus = HttpStatus.UNAUTHORIZED;
    public UnauthorizedExeption(String message) {
        super(message);

    }
}
