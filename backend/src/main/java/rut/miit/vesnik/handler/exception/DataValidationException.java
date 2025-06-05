package rut.miit.vesnik.handler.exception;

public class DataValidationException extends RuntimeException{
    public DataValidationException(String message){
        super(message);
    }
}