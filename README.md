# 📱 Mensagens SMS API

API REST desenvolvida em Java com Spring Boot para gerenciamento de mensagens SMS, permitindo registrar mensagens, atualizar seus status e consultar relatórios de envio.

## 🚀 Tecnologias utilizadas

- **Java 25**
- **Spring Boot 4.1.2**
- **Spring Data JPA**
- **Spring Web MVC**
- **Bean Validation**
- **MySQL**
- **Gradle**
- **Lombok**

## 🎯 Funcionalidades

- Cadastro de mensagens SMS.
- Registro do número de telefone, conteúdo da mensagem e data de envio.
- Definição automática do status inicial como `ENVIADO`.
- Atualização do status de uma mensagem.
- Consulta de relatório de mensagens por status nas últimas 24 horas.
- Persistência dos dados utilizando MySQL.
- Tratamento de exceções por meio de um `GlobalExceptionHandler`.


### Responsabilidades das camadas

- **Controller:** recebe e encaminha as requisições HTTP.
- **Service:** concentra as regras de negócio.
- **DTO:** define os dados de entrada e saída da API.
- **Converter:** realiza a conversão entre DTOs e entidades.
- **Entity:** representa a tabela de mensagens no banco de dados.
- **Repository:** realiza as operações de persistência.
- **Exceptions:** centraliza o tratamento de exceções.

## ⚙️ Configuração do ambiente

### Pré-requisitos

Antes de executar o projeto, é necessário ter instalado:

- Java JDK 25.
- MySQL 8 ou superior.
- IntelliJ IDEA ou outra IDE de sua preferência.


## 📡 Endpoints da API

### 1. Cadastrar mensagem SMS

**POST** `/sms`

Registra uma nova mensagem SMS.

Exemplo de requisição:

```json
{
  "numeroTelefone": "48999999999",
  "mensagem": "Sua tarefa está agendada!",
  "dataEnvio": "13-11-2026 17:30:00"
}
```

O status inicial é definido automaticamente pela aplicação como `ENVIADO`.

Resposta esperada: `201 Created`.

### 2. Atualizar status da mensagem

**PUT** `/sms/{id}/status`

Atualiza o status de uma mensagem cadastrada.

Exemplo:

```http
PUT /sms/1/status?status=RECEBIDO
```

Status disponíveis:

- `ENVIADO`
- `RECEBIDO`
- `ERRO_DE_ENVIO`

Resposta esperada: `200 OK`.

### 3. Gerar relatório de mensagens

**GET** `/sms/relatorio?status=ENVIADO`

Retorna as mensagens correspondentes ao status informado, considerando o período das últimas 24 horas.

Exemplo:

```http
GET /sms/relatorio?status=RECEBIDO
```

Resposta esperada: `200 OK`.

## 📊 Status das mensagens

| Status | Descrição |
|---|---|
| ENVIADO | Mensagem registrada com status inicial de envio |
| RECEBIDO | Mensagem marcada como recebida |
| ERRO_DE_ENVIO | Mensagem marcada com erro de envio |

**Observação:** o projeto ainda não possui integração com um gateway ou operadora de SMS. Os status são controlados pela própria API.


## 📌 Objetivo do projeto

Este projeto foi desenvolvido com o objetivo de praticar o desenvolvimento de APIs REST utilizando Java e Spring Boot, aplicando conceitos de arquitetura em camadas, persistência de dados, DTOs, tratamento de exceções e operações HTTP.

---

**Desenvolvido por Bruno De Souza**

Java | Spring Boot | MySQL | APIs REST
