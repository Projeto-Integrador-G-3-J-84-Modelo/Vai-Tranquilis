# 🛡️ VaiTranquilis

### API REST para gerenciamento de seguros de vida

<div align="center">

![Status](https://img.shields.io/badge/status-em%20desenvolvimento-blue)
![Backend](https://img.shields.io/badge/backend-Java%20%7C%20Spring%20Boot-red)
![Banco de Dados](https://img.shields.io/badge/database-MySQL-orange)
![API](https://img.shields.io/badge/API-REST-green)
![Versionamento](https://img.shields.io/badge/versionamento-Git%20%26%20GitHub-black)

</div>

---

# 👥 Equipe do Projeto

<div align="center">

| Foto | Integrante | Função | LinkedIn | GitHub |
|:---:|---|---|:---:|:---:|
| <img src="https://github.com/Renanferrcun.png" width="96" /> | **Renan Ferreira** | Product Owner | [![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/renan-ferreira-cunha/) | [![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/Renanferrcun) |
| <img src="https://github.com/raissa-sf.png" width="96" /> | **Raissa Santos** | Scrum Master | [![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/raissa-santos-feitosa-73485b1a3/) | [![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/raissa-sf) |
| <img src="https://github.com/lunnie-porto.png" width="96" /> | **Luana Porto** | Desenvolvedora Backend | [![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/luanamoreiraporto/) | [![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/lunnie-porto) |
| <img src="https://github.com/Jessica-Aquino-hub.png" width="96" /> | **Jessica Aquino** | Desenvolvedora Backend | [![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/jessica-aquino-lobo-/) | [![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/Jessica-Aquino-hub) |
| <img src="https://github.com/xXAshbornXx.png" width="96" /> | **Igor Nascimento** | Desenvolvedor Backend | [![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/igornascimentodev/) | [![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/xXAshbornXx) |
| <img src="https://github.com/Day-Barbosa.png" width="96" /> | **Dayana Barbosa** | Desenvolvedora Backend | [![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/dayanabarbosa-devjava/) | [![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/Day-Barbosa) |
| <img src="https://github.com/CarolinaPerpetuo.png" width="96" /> | **Carolina Perpetuo** | Tester / QA | [![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/carolinaperpetuo/) | [![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/CarolinaPerpetuo) |

</div>

---

# 📌 Sobre o Projeto

O **VaiTranquilis** é uma API REST desenvolvida para auxiliar no gerenciamento de planos e contratos de seguro de vida.

A aplicação permite o cadastro e gerenciamento de planos de seguro, usuários e seguros contratados, oferecendo uma estrutura organizada para armazenar informações dos segurados e seus respectivos planos.

O projeto foi desenvolvido utilizando Java e Spring Boot, seguindo boas práticas de arquitetura em camadas e persistência de dados com MySQL.

---

# 🚀 Objetivos da Solução

<div align="center">

| 🎯 Objetivo                             | 📌 Benefício                       |
| --------------------------------------- | ---------------------------------- |
| Centralizar informações de seguros      | Organização dos dados              |
| Gerenciar planos de seguro              | Controle dos serviços oferecidos   |
| Automatizar validações de elegibilidade | Aplicação das regras de negócio    |
| Disponibilizar API REST                 | Integração entre sistemas          |
| Aplicar boas práticas de backend        | Código mais organizado e escalável |

</div>

---

# 🧩 Funcionalidades Principais

<div align="center">

| Funcionalidade               | Descrição                                              |
| ---------------------------- | ------------------------------------------------------ |
| ➕ Cadastrar Planos de Seguro | Permite adicionar novos planos ao sistema              |
| 📝 Atualizar Planos          | Possibilita alterar informações dos planos cadastrados |
| ❌ Excluir Planos             | Remove planos que não serão mais utilizados            |
| 📋 Listar Planos             | Exibe todos os planos disponíveis                      |
| 🔍 Buscar por Descrição            | Filtra planos de seguro com base na descrição informada
| ➕ Cadastrar Seguros de Vida  | Registra novos segurados                               |
| 📝 Atualizar Seguros         | Permite alterar informações do segurado                |
| ❌ Excluir Seguros            | Remove registros do sistema                            |
| 📋 Listar Seguros            | Consulta todos os seguros cadastrados                  |
| 🔍 Buscar por ID             | Localiza registros específicos                         |
| 🛡️ Verificar Elegibilidade  | Aplica a regra de negócio para contratação             |
| 🌐 API REST                  | Comunicação padronizada entre sistemas                 |

</div>

---

# ⚠️ Regra de Negócio Implementada

O sistema possui uma validação de elegibilidade para contratação de seguro de vida.

Caso a idade do segurado seja inferior a 18 anos, o sistema retorna:

```text
Não elegível para este tipo de seguro.
```

Esta funcionalidade foi implementada na camada Service, respeitando a separação de responsabilidades da arquitetura do projeto.

---

# ⚙️ Arquitetura do Projeto

```text
                +----------------------+
                |     Cliente/API      |
                +----------+-----------+
                           |
                 +---------+---------+
                 |    Controller     |
                 +---------+---------+
                           |
                 +---------+---------+
                 |      Service      |
                 +---------+---------+
                           |
                 +---------+---------+
                 |    Repository     |
                 +---------+---------+
                           |
                 +---------+---------+
                 |      MySQL        |
                 +-------------------+
```

---

# 🗂️ Modelo de Dados

## Usuario

* id
* nome
* email
* foto
* senha

## PlanoSeguro

* id
* nomePlano
* descricao
* coberturaMaxima

## SeguroVida

* id
* nomeSegurado
* idade
* valorCobertura
* valorMensalidade

---

# 🔗 Relacionamentos

```text
Usuario 1:N SeguroVida

PlanoSeguro 1:N SeguroVida
```

Um usuário pode possuir vários seguros cadastrados.

Um plano de seguro pode estar associado a diversos seguros de vida.

---

# 🛠️ Tecnologias Utilizadas

<div align="center">

| Categoria          | Tecnologias                 |
| ------------------ | --------------------------- |
| 💻 Linguagem       | Java                        |
| 🚀 Framework       | Spring Boot                 |
| 🗄️ Persistência   | Spring Data JPA / Hibernate |
| 🛢️ Banco de Dados | MySQL                       |
| 🔌 API             | REST API                    |
| 🧪 Testes          | Insomnia                    |
| 🛠️ Build          | Maven                       |
| 🌿 Versionamento   | Git e GitHub                |

</div>

---

# 🔄 Fluxo de Trabalho da Equipe

<div align="center">

| Etapa                                  | Responsável     |
| -------------------------------------- | --------------- |
| 📋 Planejamento das tarefas            | Product Owner   |
| 🌿 Organização das branches            | Scrum Master    |
| 💻 Desenvolvimento das funcionalidades | Desenvolvedores |
| 🧪 Testes e validações                 | Tester          |
| 🔀 Merge e integração                  | Scrum Master    |

</div>

---

# 📂 Estrutura do Projeto

```text
src
 ├── controller
 ├── service
 ├── repository
 └── model

evidencias
 ├── plano-seguro
 ├── seguro-vida
 ├── service
 └── relatorio-testes.md

docs
 └── der-vaitranquilis.png
```

---

# 🚀 Como Executar o Projeto

## 1️⃣ Clone o repositório

```bash
git clone https://github.com/Projeto-Integrador-G-3-J-84-Modelo/Vai-Tranquilis.git
```

## 2️⃣ Acesse a pasta do projeto

```bash
cd Vai-Tranquilis
```

## 3️⃣ Configure o banco de dados

Edite o arquivo:

```properties
application.properties
```

Configure:

```properties
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=
```

---

## 4️⃣ Execute a aplicação

```bash
./mvnw spring-boot:run
```

---

# 📈 Roadmap do Projeto

* [x] Estrutura inicial da API
* [x] Configuração do Spring Boot
* [x] Criação das entidades
* [x] Implementação dos relacionamentos
* [x] Implementação dos CRUDs
* [x] Implementação da regra de negócio
* [x] Testes com Insomnia
* [ ] Autenticação JWT
* [ ] Documentação Swagger
* [ ] Deploy da aplicação

---

# 📚 Boas Práticas Utilizadas

* ✅ Arquitetura em camadas
* ✅ Programação orientada a objetos
* ✅ Padronização REST
* ✅ Relacionamentos JPA
* ✅ Controle de versionamento com Git Flow
* ✅ Separação de responsabilidades
* ✅ Validação de regras de negócio na camada Service

---

<div align="center">

### 🛡️ VaiTranquilis © 2026

#### Segurança e tranquilidade para quem planeja o futuro.

</div>
