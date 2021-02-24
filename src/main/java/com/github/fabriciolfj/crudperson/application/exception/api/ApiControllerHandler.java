package com.github.fabriciolfj.crudperson.application.exception.api;

import com.github.fabriciolfj.crudperson.application.exception.PersonNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;

@ControllerAdvice
public class ApiControllerHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<?> handlePersonNotFound(final PersonNotFoundException e, final WebRequest request) {
        var status = HttpStatus.NOT_FOUND;
        var problem = createProblemBuilder(status, e.getMessage());
        return handleExceptionInternal(e, problem, new HttpHeaders(), status, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    private Problem createProblemBuilder(HttpStatus status, String detail){
        return Problem.builder()
                .status(status.value())
                .userMessage(detail)
                .timestamp(OffsetDateTime.now())
                .build();
    }

}
