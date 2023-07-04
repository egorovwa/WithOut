package su.egorovwa.exception;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends  RuntimeException{
    private HttpStatus httpStatus;

    public UnauthorizedException(String message) {
        super(message);
        this.httpStatus = HttpStatus.UNAUTHORIZED;
    }
}
