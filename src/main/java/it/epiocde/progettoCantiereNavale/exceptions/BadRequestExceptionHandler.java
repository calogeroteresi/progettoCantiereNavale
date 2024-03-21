package it.epiocde.progettoCantiereNavale.exceptions;

public class BadRequestExceptionHandler extends Exception{
    public BadRequestExceptionHandler(String message) {
        super(message);
    }
}
