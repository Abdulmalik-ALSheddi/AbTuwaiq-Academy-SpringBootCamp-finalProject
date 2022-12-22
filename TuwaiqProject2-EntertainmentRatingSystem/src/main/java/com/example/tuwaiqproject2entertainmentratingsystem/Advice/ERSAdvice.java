package com.example.tuwaiqproject2entertainmentratingsystem.Advice;

import com.example.tuwaiqproject2entertainmentratingsystem.Dto.APIResponse;
import com.example.tuwaiqproject2entertainmentratingsystem.Exception.APIException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class ERSAdvice {

    @ExceptionHandler(value = APIException.class)
    public ResponseEntity APIException(APIException o)
    {
        return ResponseEntity.status(400).body(o.getMessage());
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity ConstraintViolationException(ConstraintViolationException e){
        String message=e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<APIResponse> SQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e){
        String msg=e.getMessage();
        return ResponseEntity.status(400).body(new APIResponse(msg));
    }
    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<APIResponse> DataIntegrityViolationException(DataIntegrityViolationException e){
        String msg=e.getMessage();
        return ResponseEntity.status(400).body(new APIResponse(msg));
    }
    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<APIResponse> EntityNotFoundException(EntityNotFoundException e) {
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(new APIResponse(msg));
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<APIResponse> MethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String msg = e.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(new APIResponse(msg));
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<APIResponse> HttpMessageNotReadableException(HttpMessageNotReadableException e) {
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(new APIResponse(msg));
    }

}
