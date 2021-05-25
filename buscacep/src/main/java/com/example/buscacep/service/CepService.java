package com.example.buscacep.service;

import java.net.URI;

import com.example.buscacep.client.ExternalClient;
import com.example.buscacep.domain.entity.Cep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import reactor.core.publisher.Mono;

@Component
public class CepService {

    @Autowired
    private ExternalClient externalClient;

    public Mono<Cep> busca(String cep){

        String cepCompletado = this.completaCep(cep);
        return 
            this.externalClient.getInstance().get().uri("/{cep}/json",cepCompletado).retrieve().bodyToMono(Cep.class);
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
