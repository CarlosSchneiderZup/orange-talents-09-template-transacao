package com.zupproject.transacoes.controllers.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoDto {

    private String idTransacao;
    private BigDecimal valor;
    private String estabelecimento;
    private LocalDateTime efetivadaEm;

    public TransacaoDto(String idTransacao, BigDecimal valor, String estabelecimento, LocalDateTime efetivadaEm) {
        this.idTransacao = idTransacao;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.efetivadaEm = efetivadaEm;
    }

    public String getIdTransacao() {
        return idTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getEstabelecimento() {
        return estabelecimento;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
