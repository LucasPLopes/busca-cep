

# Sistema de buscar CEP

[![Build Status](https://travis-ci.org/codecentric/springboot-sample-app.svg?branch=master)](https://travis-ci.org/codecentric/springboot-sample-app)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)


Esse projeto possui  dois projetos base que são um projeto de administração e monitoramente de microserviços usando o **Spring Boot Admin Server** e **Spring Boot Admin Client**, respectivamente, **adminserver**  e  **buscacep**
## Requisitos

* JDK 11
* Maven 3.6.3


## Arquitetura 

Utilizamos uma arquitura de microserviços com o microserviço **buscacep** e sendo monitorado pelo serviço **adminserver**

### Busca CEP 

A estrutura de pastas para o microserviço **buscacep** tende adotar uma arquitetura limpa.

![Estrutura de pastas](./imagens/src-buscacep.png "Estrutura de pastas")


## Subir aplicação


### Admin Server
```shell
cd ../adminserver
./mvnw
```

### Busca CEP
```shell
cd ../buscacep
./mvnw
```

## Testes

### Busca CEP 
```shell
cd ../buscacep
./mvnw test
```


![Alt text](relative/path/to/img.jpg?raw=true "Title")