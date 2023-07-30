package su.egorovwa.exception;

import org.springframework.http.HttpStatus;

public class ObjectNotFoundException extends AppException{
    public ObjectNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
