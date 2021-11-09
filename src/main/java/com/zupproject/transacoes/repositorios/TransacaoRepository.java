package com.zupproject.transacoes.repositorios;

import com.zupproject.transacoes.entidades.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    List<Transacao> findTop10ByCartaoIdOrderByEfetivadaEmDesc(String cartao);
}
