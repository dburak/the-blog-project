package com.burakdiker.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlingException {


    @ExceptionHandler({BurakDikerException.class})
    public String handlingNotFoundException(){
        return "There is no error like this";
    }

    @ExceptionHandler({NullPointerException.class})
    public String handlingNullPointerException(){
        return "Null value";
    }
}
