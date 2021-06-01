package com.example.buscacep.service;

import com.example.buscacep.client.ExternalClient;
import com.example.buscacep.domain.entity.Cep;
import com.example.buscacep.exceptions.CepException;
import com.example.buscacep.exceptions.ExceptionMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class CepService {

    private static final int tamanho = 8;

    @Autowired
    private ExternalClient externalClient;

    public Mono<Cep> busca(String cep) {
        log.info("service: buscar cep {}", cep);
        Mono<Cep> retornado = continuaBusca(cep);
        verificaCepNaoEncontrado(retornado);

        return retornado;
    }

    public String completaCep(String cep) {
        return completaComZeros(cep) + cep;
    }

    public String completaCepADireita(String cep) {
        return cep + completaComZeros(cep);
    }

    public Mono<Cep> continuaBusca(String cep) {
        Mono<Cep> retornado = null;
        for (int i = 0; i <= cep.length(); i++) {
            String cepNovo = cep.substring(0, cep.length() - i);
            String cepCompletado = completaCepADireita(cepNovo);
            log.info("service: continua busca {}", cepCompletado);
            if (cepCompletado == null) {
                break;
            }
            Mono<Cep> encontrado = this.buscaCep(cepCompletado);
            if (encontrado.block().getCep() != null) {
                retornado = encontrado;
                break;
            }
        }

        return retornado;
    }

    private String completaComZeros(String cep) {
        if (cep.trim().length() == tamanho)
            return "";
        int diferenca = tamanho - cep.length();
        String zeros = "";
        for (int i = 0; i < diferenca; i++) {
            zeros += "0";
        }
        return zeros;
    }

    private Mono<Cep> buscaCep(String cepCompletado) {
        return this.externalClient.getInstance().get().uri("/{cep}/json", cepCompletado).retrieve()
                .bodyToMono(Cep.class);
    }

    private void verificaCepNaoEncontrado(Mono<Cep> retornado) {
        if (retornado == null)
            throw new CepException(ExceptionMessage.CEP_NAO_ENCONTRADO);
        if (retornado.block().getCep() == null)
            throw new CepException(ExceptionMessage.CEP_NAO_ENCONTRADO);
    }

}
