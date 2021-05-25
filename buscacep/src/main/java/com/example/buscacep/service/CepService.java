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


    @Autowired
    private ExternalClient externalClient;

    public Mono<Cep> busca(String cep){
        log.info("service: buscar cep {}", cep);

        String cepCompletado = this.completaCep(cep);
        log.info("service: cep completado {}", cep);
        
        Mono<Cep> retornado =  this.externalClient.getInstance().get().uri("/{cep}/json",cepCompletado).retrieve().bodyToMono(Cep.class);

        if(retornado.block().getCep() == null)
            throw new  CepException(ExceptionMessage.CEP_NAO_ENCONTRADO);

        return retornado;
    }

    public String completaCep(String cep){
        int tamanho = 8;
        if(cep.trim().length() == tamanho)
            return cep;
        int diferenca = tamanho - cep.length();
        String zeros = "";
        for (int i = 0; i < diferenca; i++) {
            zeros +="0";
        }

        return zeros + cep;
    }

}
