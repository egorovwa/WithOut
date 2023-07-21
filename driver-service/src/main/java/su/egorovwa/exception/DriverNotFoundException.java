package su.egorovwa.exception;

import org.springframework.http.HttpStatus;

public class DriverNotFoundException extends AppException{
    public DriverNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
