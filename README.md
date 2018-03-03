# prova-rexturadvance
<h2>Prova que contempla o processo seletivo da empresa RexturAdvance.</h2>

<h3>O projeto foi divido em dois modulos:</h3>

<h3><b>Back-End</b></h3>

Onde está aplicado toda a lógica de negócio do sistema, disponibilizado em uma API desenvolvida utilizando a linguagem Java 8.
Foram usados os frameworks abaixo:

<ul>
  <li><b>Spring Boot:</b> Para facilitar o processo de configuração e publicação da aplicação.</li>
  <li><b>Spring MVC Web:</b> Para disponibilizar os recursos (URI) da aplicação, podendo utilizar a arquitetura REST.</li>
  <li><b>Spring Data JPA:</b> Para realizar a interface com o banco de dados H2 (Memória).</li>
  <li><b>H2 Memory Database:</b> Banco de dados em mémoria, geralmente utilizado para testes.</li>
  <li><b>Jackson:</b> Para disponibizar o resultado das requisições no formato JSON.</li>
  <li><b>Junit:</b> Para efetuar os testes unitários referente as regras de negócio.</li>
</ul>

<h3><b>Instruções para execução.</b></h3>

<ol type="1">
  <li>Usando uma IDE de sua preferência, importe o projeto Maven (diretório <b>agenda-tranferencia-bancaria-api</b>) e baixe as dependências necessárias.</li>
  <li>No diretório mencionado execute no prompt de comando: <b>mvnw clean install</b></li>
  <li>Ainda no prompt de comando acesse a pasta target e execute o comando: <b>java -jar agenda-transferencia-bancaria-api-0.0.1-SNAPSHOT.jar</b></li>
  <li>Aplicação estará em execução e os recursos estarão disponíveis através da URL <a>http://localhost:9090/v1/transferencias</a></li>
</ol>  

<h3><b>Front-End</b></h3>

O mesmo foi desenvolvido para exibir e cadastrar as transferências agendadas por meio de um navegador web.
Foram usados os frameworks abaixo:

<ul>
  <li><b>Angular 5:</b> Para manipular as informações recebidas do back-end.</li>
  <li><b>Angular CLI 1.7.1:</b> WebPack onde é gerada toda a infra-estrutura da aplicação.</li>
  <li><b>PrimeNG:</b> Diretivas do Angular para utilização de componentes visuais.</li>
</ul>

<h3><b>Instruções para execução..</b></h3>

<ol type="1">
  <li>Instale a ultima versão do NodeJS.</li>
  <li>Usando prompt de comando, acesse o diretório <b>agenda-tranferencia-bancaria-ui</b>.</li>
  <li>Execute o comando: <b>npm install</b></li>
  <li>Execute o comando: <b>npm start</b></li>
  <li>Usando navegador, acesse a tela através da URL <a>http://localhost:4200</a></b>.</li>
  <li>Aproveite :)</li>
</ol>
