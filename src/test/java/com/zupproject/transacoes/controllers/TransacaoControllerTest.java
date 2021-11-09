package com.zupproject.transacoes.controllers;

import com.zupproject.transacoes.controllers.dtos.EventoDeTransacao;
import com.zupproject.transacoes.controllers.dtos.TransacaoDto;
import com.zupproject.transacoes.entidades.Transacao;
import com.zupproject.transacoes.entidades.acoplamentos.Cartao;
import com.zupproject.transacoes.entidades.acoplamentos.Estabelecimento;
import com.zupproject.transacoes.repositorios.TransacaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class TransacaoControllerTest {

    private String uri = "/transacoes";
    private TransacaoDto transacaoDto;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        Estabelecimento estabelecimento = new Estabelecimento("Casa da vovó", "Pedras altas", "RS 239, km 77");
        Cartao cartao = new Cartao("4080-1010-5011-9999", "usuarioSecreto@email.com.br");
        EventoDeTransacao eventoDeTransacao = new EventoDeTransacao("512a2a3f-84b6-4cb0-bc76-243edf2cba9b", new BigDecimal("316.99"), estabelecimento, cartao, LocalDateTime.now().toString());

        Transacao transacao = Transacao.montaTransacao(eventoDeTransacao);
        transacaoRepository.save(transacao);
        transacaoDto = transacao.montaTransacaoDto();
    }

    @Test
    void deveEncontrarAsTransacoesDeUmCartaoERetornarSuaListaComStatus200() throws Exception {

        mockMvc.perform((MockMvcRequestBuilders.get(uri + "/cartoes/4080-1010-5011-9999"))
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void naoDeveEncontrarAsTransacoesDeUmCartaoSemTransacaoERetornarStatus404() throws Exception {

        mockMvc.perform((MockMvcRequestBuilders.get(uri + "/cartoes/1103-2189-0093-5626"))
        ).andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}