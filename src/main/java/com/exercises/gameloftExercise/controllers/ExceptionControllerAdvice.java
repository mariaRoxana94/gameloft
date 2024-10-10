package com.exercises.gameloftExercise.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<?> handleNoSuchElementException(RuntimeException e) {

        return ResponseEntity.status(NOT_FOUND)
                .body(e.getMessage());
    }
}
