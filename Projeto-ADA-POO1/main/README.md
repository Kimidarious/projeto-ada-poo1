# Projeto: Catálogo de Animes (POO - Ada Tech / Mercado Livre)

Este projeto é um sistema de gerenciamento de animes desenvolvido durante o curso Desenvolva+ com o Mercado Livre, utilizando os princípios da Programação Orientada a Objetos (POO) em Java.

## Equipe e Divisão

O projeto foi desenvolvido por um grupo de 3 integrantes:

- Eliakim Simões – Modelagem e estrutura base (classes Pessoa, Diretor, Dublador, Estudio, Anime)
- Flávio Moraes – Controle e persistência de dados (CatalogoAnimes, GerenciadorDados)
- Roberto Luiz de Andrade Barreto – Interface via console e funcionalidades avançadas (InterfaceUsuario, SistemaBusca, Main, testes)

Obs: Não utilizamos JavaFX ou Swing por escolha do grupo. Toda a interação acontece via console.

## Conceitos de POO Aplicados

- Encapsulamento: Atributos privados com métodos de acesso público (get/set)
- Herança: Pessoa como classe base para Diretor e Dublador
- Polimorfismo: Métodos sobrescritos e uso de diferentes comportamentos
- Abstração: Separação clara entre modelo, controle e interface
- Modularização: Pacotes organizados por função (model, controller, sistema, interfaceusuario)

## Como Executar

1. Clone este repositório:
   git clone https://github.com/seu-usuario/projeto-ada-poo1.git

2. Abra no IntelliJ ou outra IDE Java.

3. Execute a classe Main no pacote raiz (src/Main.java).

4. O sistema será executado no console com menu interativo.

Os dados são salvos e carregados de arquivos .txt ou serializados via ObjectOutputStream.

## Estrutura de Pacotes

src/
├── model/              → Classes de domínio (Anime, Pessoa, etc.)  
├── controller/         → Lógica de controle e gerenciamento de dados  
├── sistema/            → Filtros, buscas e ordenações  
├── interfaceusuario/   → Interação via console  
├── Main.java           → Ponto de entrada da aplicação

## Funcionalidades

- Listar animes
- Buscar por nome (insensível a maiúsculas/minúsculas)
- Filtrar por gênero
- Ordenar por nota
- Visualizar estatísticas básicas
- Persistência dos dados em arquivo

## Requisitos Técnicos

- Java 17 ou superior
- IntelliJ IDEA ou outra IDE com suporte a projetos Java

Desenvolvido por estudantes da Ada Tech no bootcamp Desenvolva+ com o Mercado Livre.
