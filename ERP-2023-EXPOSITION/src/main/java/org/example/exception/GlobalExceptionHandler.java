package org.example.exception;

import org.example.application.exception.DevisNonConformeException;
import org.example.exception.dto.MessageExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<MessageExceptionDto> handleProduitNotFoundExeption (EntityNotFoundException ex) {
            MessageExceptionDto errorMessage=new MessageExceptionDto("NOT_FOUND",ex.getMessage(), LocalDate.now());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorMessage);
    }

    @ExceptionHandler(DevisNonConformeException.class)
    public ResponseEntity<MessageExceptionDto> handleDevisNonConformExeption (DevisNonConformeException ex) {
        MessageExceptionDto errorMessage=new MessageExceptionDto("NON_CONFORME",ex.getMessage(), LocalDate.now());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorMessage);
    }

}
