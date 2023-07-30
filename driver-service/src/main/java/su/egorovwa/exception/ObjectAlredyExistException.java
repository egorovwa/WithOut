package su.egorovwa.exception;

import org.springframework.http.HttpStatus;

public class ObjectAlredyExistException extends AppException{
    public ObjectAlredyExistException(String message) {
        super(message, HttpStatus.FORBIDDEN);
    }
}
