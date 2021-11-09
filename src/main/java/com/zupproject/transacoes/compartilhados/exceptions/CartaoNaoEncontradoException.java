package com.zupproject.transacoes.compartilhados.exceptions;

import org.springframework.http.HttpStatus;

public class CartaoNaoEncontradoException extends RuntimeException {

    private String campo;
    private HttpStatus status;

    public CartaoNaoEncontradoException(String mensagem, String campo, HttpStatus status) {
        super(mensagem);
        this.campo = campo;
        this.status = status;
    }

    public String getCampo() {
        return campo;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public int getHttpStatus() {
        return status.value();
    }
}
