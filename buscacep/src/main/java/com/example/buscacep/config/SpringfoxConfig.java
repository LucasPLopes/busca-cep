package com.example.buscacep.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringfoxConfig {

    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)                                 
            .select()                                       
            .apis(RequestHandlerSelectors.basePackage("com.example"))
            .paths(PathSelectors.any())                     
            .build()
            .apiInfo(apiInfo());                                          
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
          "Busca CEP API", 
          "Serviço de busca de CEP", 
          "", 
          "", 
          null, 
          "",
          "",
          Collections.emptyList());
    }
}