package com.zupproject.transacoes.entidades.acoplamentos;

import javax.persistence.Embeddable;

@Embeddable
public class Cartao {

    private String id;
    private String email;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
