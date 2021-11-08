package com.zupproject.transacoes.entidades;

import com.zupproject.transacoes.entidades.acoplamentos.Cartao;
import com.zupproject.transacoes.entidades.acoplamentos.Estabelecimento;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBanco;
    private String idTransacao;
    private BigDecimal valor;
    @Embedded
    private Estabelecimento estabelecimento;
    @Embedded
    private Cartao cartao;
    private LocalDateTime efetivadaEm;

    @Deprecated
    public Transacao() {}

    private Transacao(EventoDeTransacao evento) {
        this.idTransacao = evento.getId();
        this.valor = evento.getValor();
        this.estabelecimento = evento.getEstabelecimento();
        this.cartao = evento.getCartao();
        this.efetivadaEm = LocalDateTime.parse(evento.getEfetivadaEm());
    }

    public static Transacao montaTransacao(EventoDeTransacao eventoDeTransacao) {
        return new Transacao(eventoDeTransacao);
    }
}
