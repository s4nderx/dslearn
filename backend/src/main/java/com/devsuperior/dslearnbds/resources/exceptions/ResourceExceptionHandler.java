package com.devsuperior.dslearnbds.resources.exceptions;

//import com.amazonaws.AmazonClientException;
//import com.amazonaws.AmazonServiceException;
import com.devsuperior.dslearnbds.service.exceptions.DataBaseException;
import com.devsuperior.dslearnbds.service.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException exception, HttpServletRequest request){
        StandardError error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setError("Resource not found");
        error.setMessage(exception.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(error.getStatus()).body(error);
    }

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandardError> dataBase(DataBaseException exception, HttpServletRequest request){
        StandardError error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setError("Database Exception");
        error.setMessage(exception.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(error.getStatus()).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> validation(MethodArgumentNotValidException exception, HttpServletRequest request){
        ValidationError error = new ValidationError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        error.setError("Validation Exception");
        error.setMessage(exception.getMessage());
        error.setPath(request.getRequestURI());

        for(FieldError f : exception.getBindingResult().getFieldErrors()){
            error.addError(f.getField(), f.getDefaultMessage());
        }

        return ResponseEntity.status(error.getStatus()).body(error);
    }

//    @ExceptionHandler(AmazonServiceException.class)
//    public ResponseEntity<StandardError> amazonService(AmazonServiceException exception, HttpServletRequest request){
//        StandardError error = new StandardError();
//        error.setTimestamp(Instant.now());
//        error.setStatus(HttpStatus.BAD_REQUEST.value());
//        error.setError("AWS Service Exception.");
//        error.setMessage(exception.getMessage());
//        error.setPath(request.getRequestURI());
//        return ResponseEntity.status(error.getStatus()).body(error);
//    }
//
//    @ExceptionHandler(AmazonClientException.class)
//    public ResponseEntity<StandardError> amazonClient(AmazonClientException exception, HttpServletRequest request){
//        StandardError error = new StandardError();
//        error.setTimestamp(Instant.now());
//        error.setStatus(HttpStatus.BAD_REQUEST.value());
//        error.setError("AWS Client Exception.");
//        error.setMessage(exception.getMessage());
//        error.setPath(request.getRequestURI());
//        return ResponseEntity.status(error.getStatus()).body(error);
//    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<StandardError> illegalArgument(IllegalArgumentException exception, HttpServletRequest request){
        StandardError error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setError("Bad request.");
        error.setMessage(exception.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(error.getStatus()).body(error);
    }

}
