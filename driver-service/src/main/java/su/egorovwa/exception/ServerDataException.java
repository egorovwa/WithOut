package su.egorovwa.exception;

import org.springframework.http.HttpStatus;

/**
 * Бросается при несоответствии данных сервера пример(если  проходит запрос состояния от несуществующего водителя)
 * HttpStatus 500
 */
public class ServerDataException extends AppException{
    public ServerDataException(String message) {
        super(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
