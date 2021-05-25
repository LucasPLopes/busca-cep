package com.example.buscacep.web.resource;

import com.example.buscacep.domain.entity.Cep;
import com.example.buscacep.exceptions.CepException;
import com.example.buscacep.exceptions.handler.ApiError;
import com.example.buscacep.service.CepService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cep")
@Slf4j
public class CepResource {

    @Autowired
    private CepService service;

    @GetMapping("/{cep}")
    public ResponseEntity<Cep> busca(@PathVariable String cep) {
        log.info("GET /cep/{}", cep);

        Mono<Cep> busca = this.service.busca(cep);
        Cep retornado = busca.block();

        log.info("CepResource: resultado {}", retornado);
        return ResponseEntity.ok(retornado);
    }

    @ExceptionHandler(CepException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiError> handlerException(CepException exception) {
        log.error("CepException: {}", exception.getMessage());

        ApiError error = ApiError.builder().status(HttpStatus.NOT_FOUND).mensagem(exception.getMessage()).build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
