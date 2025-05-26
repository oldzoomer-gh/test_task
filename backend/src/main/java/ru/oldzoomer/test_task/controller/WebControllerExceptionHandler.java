package ru.oldzoomer.test_task.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.log4j.Log4j2;
import ru.oldzoomer.test_task.exceptions.UserNotFound;

@RestControllerAdvice
@Log4j2
public class WebControllerExceptionHandler {
    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFound e) {
        log.error("User not found", e);
        return ResponseEntity.status(403).body(e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        log.error("Illegal argument", e);
        return ResponseEntity.status(400).body(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        log.error("Internal Server Error", e);
        return ResponseEntity.status(500).body("Internal Server Error");
    }
}
