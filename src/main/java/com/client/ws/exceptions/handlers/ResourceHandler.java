package com.client.ws.exceptions.handlers;

import com.client.ws.dto.error.ErrorResponseDTO;
import com.client.ws.exceptions.BadRequestException;
import com.client.ws.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ResourceHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> notFoundException(NotFoundException n) {
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        return ResponseEntity.status(notFound).body(ErrorResponseDTO.builder()
                .message(n.getMessage())
                .httpStatus(notFound)
                .statusCode(notFound.value())
                .build());
    }
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponseDTO> badRequestException(BadRequestException n) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(badRequest).body(ErrorResponseDTO.builder()
                .message(n.getMessage())
                .httpStatus(badRequest)
                .statusCode(badRequest.value())
                .build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> methodArgumentNotValidException(MethodArgumentNotValidException m) {

        Map<String, String> mapa = new HashMap<>();

        m.getBindingResult().getAllErrors().forEach(error -> {
            String field = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            mapa.put(field, message);
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponseDTO.builder()
                .message(Arrays.toString(mapa.entrySet().toArray()))
                .httpStatus(HttpStatus.BAD_REQUEST)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .build());
    }
}
