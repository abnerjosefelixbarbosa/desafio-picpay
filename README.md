# desafio-picpay

## Sobre

Desafio simplificado picpay.

## Requisitos

- Para ambos tipos de usuário, precisamos do Nome Completo, CPF, e-mail e Senha. CPF/CNPJ e e-mails devem ser únicos no sistema. Sendo assim, seu sistema deve permitir apenas um cadastro com o mesmo CPF ou endereço de e-mail.
- Usuários podem enviar dinheiro (efetuar transferência) para lojistas e entre usuários.
- Lojistas só recebem transferências, não enviam dinheiro para ninguém.
- Validar se o usuário tem saldo antes da transferência.
- Antes de finalizar a transferência, deve-se consultar um serviço autorizador externo, use este mock para simular (https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc).
- A operação de transferência deve ser uma transação (ou seja, revertida em qualquer caso de inconsistência) e o dinheiro deve voltar para a carteira do usuário que envia.
- No recebimento de pagamento, o usuário ou lojista precisa receber notificação (envio de email, sms) enviada por um serviço de terceiro e eventualmente este serviço pode estar indisponível/instável. Use este mock para simular o envio (https://run.mocky.io/v3/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6).
- Este serviço deve ser RESTFul.

# Backend

## Tecnologias

- Java 17.
- Lombok.
- SOLID.
- MVC.
- H2 DataBase.
- Swwgger.
- Validation.

## End Points

### Transference

```JSON
POST
api/transferences/transfer-value
Content-Type: application/json

{
  "value": 0,
  "payer": 0,
  "payee": 0
}

GET
/api/transferences/list-transference-by-player?payer=1&&number=0&&size=5
```
### Users

```JSON
GET
/api/users/list-user
```

### Wallets

```JSON
POST
/api/wallets/create-wallet
Content-Type: application/json
typeUser: "COMMOM" || "MERCHANT"

{
  "fullNameUser": "",
	"docmentUser": "",
	"emailUser": "",
	"passwordUser": "",
	"typeUser": ""
}
```

## Execução

- Copie o repositório.
- Importe o projeto em uma IDE Java.
- Acesse o sweeger [Documento](http://localhost:8080/swagger-ui/index.html) ou use um plataforma para testa API.

```PRONPT
git clone 
```
