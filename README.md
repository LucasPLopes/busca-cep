

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
Abrir [Admin server](http://localhost:8081/):

![Admin Server](./imagens/admin-1.png "Admin Server")
![Admin Server](./imagens/admin-2.png "Admin Server")
![Admin Server](./imagens/admin-3.png "Admin Server")

### Busca CEP
```shell
cd ../buscacep
./mvnw
```
Abrir [Busca CEP](http://localhost:8080/swagger-ui/):

![Busca CEP](./imagens/swagger.png "Busca CEP")


## Testes

### Busca CEP 
```shell
cd ../buscacep
./mvnw test
```


## Copyright

Released under the Apache License 2.0. See the [LICENSE](https://github.com/LucasPLopes/busca-cep/blob/master/LICENSE) file.