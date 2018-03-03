# prova-rexturadvance
Prova que contempla o processo seletivo da empresa RexturAdvance

O projeto foi divido em dois modulos:

<b>Back-End</b>

Onde está aplicado toda a lógica de negócio do sistema, disponibilizado em uma API desenvolvida utilizando a linguagem Java 8.
Foram usados os frameworks abaixo:

Spring Boot: Para facilitar o processo de configuração e publicação da aplicação.
Spring MVC Web: Para disponibilizar os recursos (URI) da aplicação, podendo utilizar a arquitetura REST.  
Spring Data JPA: Para realizar a interface com o banco de dados H2 (Memória).
H2 Memory Database: Banco de dados em mémoria, geralmente utilizado para testes.
Jackson: Para disponibizar o resultado das requisições no formato JSON.

Instruções para execução.

01 - Usando uma IDE de sua preferência, importe o projeto Maven (diretório <b>agenda-tranferencia-bancaria-api</b>) e baixe as dependências necessárias.
02 - No diretório mencionado execute no prompt de comando <b>mvnw clean install</b>.
03 - Ainda no prompt de comando acesse a pasta target e execute o comando <b>java -jar agenda-transferencia-bancaria-api-0.0.1-SNAPSHOT.jar</b>.
04 - Aplicação estará em execução e os recursos estarão disponíveis através da URL http://localhost:9090/v1/tranferencias 

<b>Front-End</b>

O mesmo foi desenvolvido para exibir e cadastrar as transferências agendadas por meio de um navegador web.
Foram usados os frameworks abaixo:

Angular 5: Para manipular as informações recebidas do back-end.
Angular CLI 1.7.1: WebPack onde é gerada toda a infra-estrutura da aplicação. 
PrimeNG: Diretivas do Angular para utilização de componentes visuais.

Instruções para execução.

01 - Instale a ultima versão do NodeJS.
02 - Usando prompt de comando, acesse o diretório <b>agenda-tranferencia-bancaria-ui</b>.
03 - Execute o comando <b>npm install</b>.
04 - Execute o comando <b>npm start</b>.
05 - Usando navegador, acesse a tela através da URL http://localhost:4200
06 - Aproveite :)

