package com.example.project.Exception;


import com.example.project.DTO.UserMessageDTO;
import com.example.project.Exception.OpportunityException.InvalidInputException;
import com.example.project.Exception.OpportunityException.NotFoundException;
import com.example.project.Exception.OpportunityException.OpportunityServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler({IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<UserMessageDTO> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(new UserMessageDTO(ex.getMessage(), false));
    }

    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<UserMessageDTO> handleUserNotFoundException(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new UserMessageDTO(ex.getMessage(), false));
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<UserMessageDTO> handleInvalidInputException(InvalidInputException ex) {
        UserMessageDTO response = new UserMessageDTO(ex.getMessage(), false);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OpportunityServiceException.class)
    public ResponseEntity<UserMessageDTO> handleOpportunityServiceException(OpportunityServiceException ex) {
        UserMessageDTO response = new UserMessageDTO(ex.getMessage(), false);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}