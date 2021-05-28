package com.example.buscacep.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CepServiceTest {

    @Autowired
    private CepService service;

    @Test
    public void verificaSeUmCEPCorretoERetornado() {
        String cep = "71882157";
        String resultado = this.service.completaCep(cep);
        assertEquals(cep, resultado);
    }


    @Test
    public void transformaUmCep() {
        String cep = "100150";
        String resultado = this.service.completaCep(cep);
        assertEquals("00100150", resultado);
    }

    @Test
    public void transformaUmCep2() {
        String cep = "1100150";
        String resultado = this.service.completaCep(cep);
        assertEquals("01100150", resultado);
    }
}
