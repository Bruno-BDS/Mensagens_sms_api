package com.bruno.mensagens_sms_api.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SmsNaoEncontradoException.class)
    public ResponseEntity<String> tratarSmsNaoEncontrado(SmsNaoEncontradoException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> tratarValidacao(
            MethodArgumentNotValidException e) {

        String mensagem = e.getBindingResult()
                .getFieldErrors()
                .get(0)
                .getDefaultMessage();

        return ResponseEntity
                .badRequest()
                .body(mensagem);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> tratarArgumentoInvalido(MethodArgumentTypeMismatchException e) {
        return ResponseEntity
                .badRequest()
                .body("Parâmetro inválido: " + e.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> tratarJsonInvalido(
            HttpMessageNotReadableException e) {

        return ResponseEntity
                .badRequest()
                .body("JSON inválido ou data em formato incorreto");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> tratarErroGeralNoServidor(Exception e) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Erro interno no servidor");
    }
}