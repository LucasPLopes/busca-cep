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
        String resultado = this.service.completaCepADireita(cep);
        assertEquals(cep, resultado);
    }


    @Test
    public void transformaUmCep() {
        String cep = "100150";
        String resultado = this.service.completaCepADireita(cep);
        assertEquals("10015000", resultado);
    }

    @Test
    public void transformaUmCep2() {
        String cep = "1100150";
        String resultado = this.service.completaCepADireita(cep);
        assertEquals("11001500", resultado);
    }

    @Test
    public void transformaUmCep3() {
        String cep = "";
        String resultado = this.service.completaCepADireita(cep);
        assertEquals("00000000", resultado);
    }
}
