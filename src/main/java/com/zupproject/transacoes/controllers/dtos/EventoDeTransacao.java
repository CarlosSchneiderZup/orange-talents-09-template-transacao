package com.zupproject.transacoes.controllers.dtos;

import com.zupproject.transacoes.entidades.acoplamentos.Cartao;
import com.zupproject.transacoes.entidades.acoplamentos.Estabelecimento;

import java.math.BigDecimal;

public class EventoDeTransacao {

    private String id;
    private BigDecimal valor;
    private Estabelecimento estabelecimento;
    private Cartao cartao;
    private String efetivadaEm;

    public EventoDeTransacao(String id, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao, String efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public String getEfetivadaEm() {
        return efetivadaEm;
    }
}