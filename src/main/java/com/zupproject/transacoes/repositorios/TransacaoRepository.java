package com.zupproject.transacoes.repositorios;

import com.zupproject.transacoes.entidades.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
