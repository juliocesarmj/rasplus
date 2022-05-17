package com.client.ws.exceptions.handlers;

import com.client.ws.dto.error.ErrorResponseDTO;
import com.client.ws.exceptions.BadRequestException;
import com.client.ws.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
}
