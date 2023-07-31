package su.egorovwa.dto;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    NOT_FOUND("Икомый объект не найден", HttpStatus.NOT_FOUND.value()),
    SERVER_ERROR("ошибка сервера", HttpStatus.INTERNAL_SERVER_ERROR.value()),
    ALREDY_EXIST("Уже существует", HttpStatus.FORBIDDEN.value());

    private final String description;
    private final Integer statusCode;

    ErrorCode(String description, Integer statusCode) {
        this.description = description;
        this.statusCode = statusCode;
    }
}
