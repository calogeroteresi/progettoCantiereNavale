package it.epiocde.progettoCantiereNavale.exceptions;

import it.epiocde.progettoCantiereNavale.responses.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse notFoundException(NotFoundException e){
        return new ErrorResponse(e.getMessage());
    }
    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponse unauthorizedException(UnauthorizedException e){
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler(BadRequestExceptionHandler.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse badRequestExceptionHandler(BadRequestExceptionHandler e){
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler(AlreadyAdminException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponse alreadyAdminException(AlreadyAdminException e){
        return new ErrorResponse(e.getMessage());
    }


}
