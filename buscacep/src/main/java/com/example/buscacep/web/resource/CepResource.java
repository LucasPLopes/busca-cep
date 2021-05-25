package com.example.buscacep.web.resource;

import com.example.buscacep.domain.entity.Cep;
import com.example.buscacep.service.CepService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cep")
public class CepResource {
    

    @Autowired
    private CepService service;

    @GetMapping("/{cep}")
    public ResponseEntity<Cep> busca(@PathVariable String cep){
        Mono<Cep> busca = this.service.busca(cep);

        return ResponseEntity.ok(busca.block());
    }
}
