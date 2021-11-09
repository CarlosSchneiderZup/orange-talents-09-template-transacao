package com.zupproject.transacoes.compartilhados.erros;

import com.zupproject.transacoes.compartilhados.exceptions.CartaoNaoEncontradoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExcecaoHandler {

    @ExceptionHandler(CartaoNaoEncontradoException.class)
    public ResponseEntity<ErroPadrao> tratamentoApiError(CartaoNaoEncontradoException exception) {
        LocalDateTime hora = LocalDateTime.now();
        ErroPadrao erro = new ErroPadrao(exception.getCampo(), exception.getMessage(), hora);
        return ResponseEntity.status(exception.getHttpStatus()).body(erro);
    }

}