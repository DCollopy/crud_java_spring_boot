# Projeto cadastro filmes

    - Arquitetura usada
        - Java 11
        - Spring boot
        - Thymeleaf
        - JPA data
        - banco mysql
        - bootstrap

    - Padrão de projeto
        - Design Patterns  DTO - Objeto de Transferencia de Dados
            A sua função é obter e armazenar dados. Quando estamos trabalhando com uma interface remota, 
            cada chamada ao servidor pode custar muito tempo de processamento, a depender da quantidade 
            de dados. Com o DTO, podemos filtrar quais dados serão transmitidos e assim reduzir esse problema.
            O DTO é bastante utilizado também quando não queremos expor todos os dados da nossa camada de 
            persistência mas precisamos exibir ao nosso cliente estes mesmos dados.
        - POO - orientado a objetos
        - Value Objects DDD
