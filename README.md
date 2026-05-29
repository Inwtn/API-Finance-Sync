# API de Lançamento Automático em Planilhas

## Sobre o Projeto

A **API de Lançamento Automático em Planilhas** foi desenvolvida para automatizar o processo de registro de transações financeiras em planilhas do Google Sheets em tempo real.

O sistema elimina tarefas manuais repetitivas, permitindo que aplicações enviem dados financeiros através de uma API REST, enquanto o backend valida as regras de negócio e registra automaticamente as informações em uma planilha inteligente na nuvem.

Este projeto demonstra conhecimentos em:

* Java
* Spring Boot
* APIs REST
* Integração com APIs externas
* Google Sheets API
* OAuth2 / Service Account
* Validação de regras de negócio
* Arquitetura backend
* Automação de processos

---

# Funcionalidades

* Cadastro de transações financeiras via API REST
* Integração automática com Google Sheets
* Inserção de dados em tempo real na planilha
* Validação de regras de negócio
* Estrutura preparada para escalabilidade
* Tratamento de erros e respostas padronizadas

---

# Tecnologias Utilizadas

* Java 21
* Spring Boot
* Spring Web
* Spring Validation
* Google Sheets API
* Maven
* Lombok
* Jackson

---

# Arquitetura da Aplicação

O fluxo da aplicação funciona da seguinte forma:

1. O cliente envia uma requisição para:

```http
POST /api/v1/transactions
```

2. A API recebe os dados da transação:

```json
{
  "type": "INCOME",
  "amount": 1500.00,
  "category": "Salário",
  "description": "Pagamento mensal",
  "date": "2026-05-29"
}
```

3. O sistema valida as regras de negócio:

* Receitas não podem possuir valor negativo
* Campos obrigatórios devem ser preenchidos
* Datas inválidas são rejeitadas

4. Após a validação:

* Os dados são formatados
* Uma nova linha é adicionada automaticamente no Google Sheets

---

# Estrutura do Projeto

```bash
src
 ┣ main
 ┃ ┣ java
 ┃ ┃ ┗ com.seuprojeto.transactions
 ┃ ┃ ┣ controller
 ┃ ┃ ┣ service
 ┃ ┃ ┣ dto
 ┃ ┃ ┣ validation
 ┃ ┃ ┣ integration
 ┃ ┃ ┗ config
 ┃ ┗ resources
 ┃   ┣ application.yml
 ┃   ┗ credentials.json
```

---

# Endpoint Principal

## Criar Transação

### Requisição

```http
POST /api/v1/transactions
```

### Body

```json
{
  "type": "EXPENSE",
  "amount": 250.75,
  "category": "Alimentação",
  "description": "Mercado",
  "date": "2026-05-29"
}
```

### Resposta de Sucesso

```json
{
  "message": "Transaction successfully registered in Google Sheets"
}
```

---

# Integração com Google Sheets

A aplicação utiliza a Google Sheets API para adicionar linhas automaticamente em uma planilha configurada.

## Configuração

### 1. Criar projeto no Google Cloud

* Acesse o Google Cloud Console
* Crie um novo projeto
* Ative a Google Sheets API

### 2. Criar credenciais

Você pode utilizar:

* OAuth2
  ou
* Service Account

### 3. Baixar o arquivo de credenciais

Renomeie para:

```bash
credentials.json
```

E coloque em:

```bash
src/main/resources/
```

### 4. Compartilhar a planilha

Compartilhe a planilha com o e-mail da Service Account.

---

# Variáveis de Ambiente

```env
GOOGLE_SHEET_ID=your_sheet_id
APPLICATION_NAME=transactions-api
```

---

# Executando o Projeto

## Clonar o repositório

```bash
git clone https://github.com/seuusuario/transactions-sheets-api.git
```

## Entrar na pasta

```bash
cd transactions-sheets-api
```

## Executar a aplicação

```bash
./mvnw spring-boot:run
```

---

# Melhorias Futuras

* Autenticação JWT
* Banco de dados PostgreSQL
* Dockerização
* Deploy em AWS
* Dashboard financeiro
* Webhooks
* Filas assíncronas com RabbitMQ
* Exportação em PDF

---

# Objetivo do Projeto

Este projeto foi criado com foco em:

* Demonstrar integração entre sistemas
* Automatizar tarefas repetitivas
* Simular cenários reais corporativos
* Fortalecer conhecimentos em backend Java
* Construir portfólio profissional

---

# Autor

Isaac Almeida

* Estudante de Análise e Desenvolvimento de Sistemas
* Desenvolvedor Backend Java
* Focado em automação, APIs REST e integração de sistemas
