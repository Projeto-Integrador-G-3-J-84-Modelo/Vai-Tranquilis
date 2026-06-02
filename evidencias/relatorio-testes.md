# Relatório de Testes

## Informações Gerais

**Projeto:** VaiTranquilis

**Tester:** Carolina Perpetuo

**Data:** 02/06/2026

**Ferramenta:** Insomnia

---

# Testes da Entidade PlanoSeguro

## CT001 - Criar Plano de Seguro

### Requisição

POST /planos

### Dados enviados

```json
{
    "nomePlano": "Seguro Vida familiar",
    "descricao": "Cobertura completa para toda a família em casos de acidentes",
    "coberturaMaxima": 150000.00
}
```

### Resultado Esperado

Status 201 Created.

Plano cadastrado com sucesso.

### Resultado Obtido

Status 201 Created.

Plano cadastrado com sucesso e retornado pela API conforme esperado.

### Evidência

![CT001](plano-seguro/plano-post.png)

### Status

Aprovado

---

## CT002 - Buscar Todos os Planos

### Requisição

GET /planos

### Resultado Esperado

Retornar lista de planos cadastrados.

### Resultado Obtido

Status 200 OK.

Lista de planos retornada com sucesso contendo os registros cadastrados.

### Evidência

![CT002](plano-seguro/plano-get-all.png)

### Status

Aprovado

---

## CT003 - Buscar Plano por ID

### Requisição

GET /planos/{id}

### Resultado Esperado

Retornar os dados do plano solicitado.

### Resultado Obtido

Status 200 OK.

Plano localizado e retornado corretamente com os dados cadastrados.

### Evidência

![CT003](plano-seguro/plano-get-id.png)

### Status

Aprovado

---

## CT004 - Atualizar Plano

### Requisição

PUT /planos

### Resultado Esperado

Plano atualizado com sucesso.

### Resultado Obtido

Status 200 OK.

Plano atualizado com sucesso e alterações persistidas no banco de dados.

### Evidência

![CT004](plano-seguro/plano-put.png)

### Status

Aprovado

---

## CT005 - Buscar por Descrição

### Requisição

GET /planos/descricao/{descricao}

### Resultado Esperado

Plano encontrado com sucesso.

### Resultado Obtido

Status 200 OK.

Plano encontrado com sucesso através da descrição informada.

### Evidência

![CT005](plano-seguro/plano-get-descricao.png)

### Status

Aprovado

---

## CT006 - Excluir Plano

### Requisição

DELETE /planos/{id}

### Resultado Esperado

Plano removido com sucesso.

### Resultado Obtido

Status 204 No Content.

Plano removido com sucesso da base de dados.

### Evidência

![CT006](plano-seguro/plano-delete.png)

### Status

Aprovado

---

# Testes da Entidade SeguroVida

## CT007 - Criar Seguro de Vida

### Requisição

POST /seguros

### Dados enviados

```json
{
    "nomeSegurado": "Fernando",
    "idade": 18,
    "valorCobertura": 50000.00,
    "valorMensalidade": 30000.00
}
```

### Resultado Esperado

Status 201 Created.

Seguro cadastrado com sucesso.

### Resultado Obtido

Status 201 Created.

Seguro de vida cadastrado com sucesso e retornado pela API.

### Evidência

![CT007](seguro-vida/seguro-post.png)

### Status

Aprovado

---

## CT008 - Buscar Todos os Seguros

### Requisição

GET /seguros

### Resultado Esperado

Retornar lista de seguros cadastrados.

### Resultado Obtido

Status 200 OK.

Lista de seguros retornada com sucesso contendo os registros cadastrados.

### Evidência

![CT008](seguro-vida/seguro-get-all.png)

### Status

Aprovado

---

## CT009 - Buscar Seguro por ID

### Requisição

GET /seguros/{id}

### Resultado Esperado

Retornar os dados do seguro solicitado.

### Resultado Obtido

Status 200 OK.

Seguro localizado e retornado corretamente.

### Evidência

![CT009](seguro-vida/seguro-get-id.png)

### Status

Aprovado

---

## CT010 - Atualizar Seguro

### Requisição

PUT /seguros

### Resultado Esperado

Seguro atualizado com sucesso.

### Resultado Obtido

Status 200 OK.

Seguro atualizado com sucesso e alterações persistidas.

### Evidência

![CT010](seguro-vida/seguro-put.png)

### Status

Aprovado

---

## CT011 - Excluir Seguro

### Requisição

DELETE /seguros/{id}

### Resultado Esperado

Seguro removido com sucesso.

### Resultado Obtido

Status 204 No Content.

Seguro removido com sucesso da base de dados.

### Evidência

![CT011](seguro-vida/seguro-delete.png)

### Status

Aprovado

---

# Teste da Regra de Negócio

## CT012 - Elegibilidade para Contratação (Menor de 18 anos)

### Cenário

Cadastrar ou consultar um segurado com idade inferior a 18 anos.

### Resultado Esperado

Mensagem:

```text
Não elegível para este tipo de seguro.
```

### Resultado Obtido

Status 200 OK.

A API retornou a mensagem "Não elegível para este tipo de seguro.", conforme esperado para segurado menor de 18 anos.

### Evidência

![CT012](seguro-vida/elegibilidade-menor-idade.png)

### Status

Aprovado

---

## CT013 - Elegibilidade para Contratação (Maior ou Igual a 18 anos)

### Cenário

Cadastrar ou consultar um segurado com idade igual ou superior a 18 anos.

### Resultado Esperado

Segurado considerado elegível para contratação.

### Resultado Obtido

Status 200 OK.

A API retornou a mensagem informando que o segurado é elegível para contratação, conforme esperado.

### Evidência

![CT013](seguro-vida/elegibilidade-maior-idade.png)

### Status

Aprovado

---

# Bugs Encontrados

Nenhum bug encontrado durante a execução dos testes.

---

# Resultado Final

**Total de Casos de Teste:** 13

**Aprovados:** 13

**Reprovados:** 0

**Taxa de Sucesso:** 100%

**Status Final:** APROVADO
