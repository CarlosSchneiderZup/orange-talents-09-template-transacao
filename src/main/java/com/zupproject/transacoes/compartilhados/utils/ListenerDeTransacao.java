package com.zupproject.transacoes.compartilhados.utils;

import com.zupproject.transacoes.entidades.EventoDeTransacao;
import com.zupproject.transacoes.entidades.Transacao;
import com.zupproject.transacoes.repositorios.TransacaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ListenerDeTransacao {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TransacaoRepository transacaoRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transacao}")
    public void ouvir(EventoDeTransacao eventoDeTransacao) {
        try {
            Transacao transacao = Transacao.montaTransacao(eventoDeTransacao);
            transacaoRepository.save(transacao);
            logger.info("Transação de id " + eventoDeTransacao.getId() + " foi salva em " + LocalDateTime.now());

        } catch (Exception e) {
            logger.error("Não foi possivel efetivar a transação recebida. Erro: ");
            logger.error(e.getMessage());
            logger.error("Ocorrido em: " + LocalDateTime.now());
        }

    }
}
