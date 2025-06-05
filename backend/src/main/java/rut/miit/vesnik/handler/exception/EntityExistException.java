package rut.miit.vesnik.handler.exception;

import org.springframework.http.HttpStatus;

public class EntityExistException extends RuntimeException {
    private HttpStatus httpStatus;

    public EntityExistException(String message) {
        super(message);
    }
}