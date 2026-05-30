# Finance Sync API

## Descricao
Uma API REST desenvolvida em Java com Spring Boot para automatizar processos de fluxo de caixa. O sistema atua como um middleware de integracao, recebendo dados de transacoes financeiras via requisicoes HTTP e realizando o lancamento automatico e em tempo real em planilhas de controle gerencial do Google Sheets.

Este projeto resolve problemas de gargalos operacionais e erros de digitacao em fluxos corporativos com alto volume de transacoes, eliminando o trabalho manual de fechamento de caixa.

## Tecnologias Utilizadas
* Java 17
* Spring Boot (Web)
* Lombok
* Google Sheets API v4
* Google Auth Library (Service Accounts)
* Maven

## Arquitetura
O projeto segue o padrao de arquitetura em camadas:
* Controller: Gerenciamento dos endpoints REST e recepcao de payloads JSON.
* Service: Regras de negocio, autenticacao OAuth2/Service Account e integracao com APIs externas.
* DTO: Padronizacao do contrato de dados recebidos.

## Como Executar

### Pre-requisitos
1. Uma conta no Google Cloud Platform.
2. Ativar a Google Sheets API e criar uma Service Account.
3. Fazer o download da chave JSON da Service Account.

### Configuracao
1. Clone este repositorio.
2. Coloque o arquivo de credenciais do Google na pasta `src/main/resources/` com o nome `google-credentials.json`.
3. No arquivo `src/main/resources/application.properties`, adicione o ID da sua planilha:
   `google.sheets.id=SEU_ID_DA_PLANILHA`
4. De permissao de "Editor" na sua planilha para o e-mail da sua Service Account.
5. Execute o projeto na sua IDE ou via terminal com `mvn spring-boot:run`.

### Exemplo de Requisicao (POST)
Endpoint: `http://localhost:8080/api/v1/transactions`

```json
{
  "data": "30/05/2026",
  "tipo": "DESPESA",
  "categoria": "Licenca de Software",
  "descricao": "Pagamento de Ferramentas Cloud",
  "valor": 150.50
}
