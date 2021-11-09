package com.zupproject.transacoes.controllers;

import com.zupproject.transacoes.compartilhados.exceptions.CartaoNaoEncontradoException;
import com.zupproject.transacoes.controllers.dtos.TransacaoDto;
import com.zupproject.transacoes.entidades.Transacao;
import com.zupproject.transacoes.repositorios.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @GetMapping("/cartoes/{idCartao}")
    public List<TransacaoDto> encontrarTransacoes(@PathVariable String idCartao) {
        List<Transacao> ultimasTransacoes = transacaoRepository.findTop10ByCartaoIdOrderByEfetivadaEmDesc(idCartao);

        if(ultimasTransacoes.isEmpty()) {
            throw new CartaoNaoEncontradoException("Não foram encontradas transações para o cartão informado", "idCartao", HttpStatus.NOT_FOUND);
        }

        return ultimasTransacoes.stream().map(Transacao::montaTransacaoDto).collect(Collectors.toList());
    }
}
