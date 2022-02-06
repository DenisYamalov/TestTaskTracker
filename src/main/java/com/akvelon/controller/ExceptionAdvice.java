package com.akvelon.controller;

import com.akvelon.exceptions.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception advisor to send error messages
 */
@ControllerAdvice
public class ExceptionAdvice {

    private static final Logger log = LoggerFactory.getLogger(ExceptionAdvice.class);

    @ResponseBody
    @ExceptionHandler(MyException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    private String maxPressureHandler(MyException myException) {

        log.info(myException.getMessage());
        return myException.getMessage();
    }

}
