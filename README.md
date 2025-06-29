# 📦 Gestão de Produtos - API REST

Este projeto consiste em uma API REST simples para o gerenciamento de produtos e categorias de um estoque. A aplicação permite realizar as operações básicas de **CRUD (Criar, Ler, Atualizar, Deletar)** tanto para produtos quanto para categorias, utilizando uma arquitetura de relacionamento entre entidades.

## 🚀 Objetivo

Facilitar o gerenciamento de produtos e suas respectivas categorias para que sistemas front-end (como Angular ou React) possam consumir os dados de forma eficiente e segura.

## 🛠️ Tecnologias Utilizadas

- Java + Spring Boot (Backend)
- Spring Data JPA + Hibernate (Persistência)
- MySQL ou H2 Database (Banco de Dados)
- Postman ou Swagger (Para testes)
- Maven (Gerenciamento de dependências)

---

## 🗃️ Estrutura do Banco de Dados

### Entidade: Categoria

| Campo  | Tipo   | Descrição                    |
|--------|--------|------------------------------|
| id     | Long   | Identificador da categoria   |
| nome   | String | Nome da categoria            |

### Entidade: Produto

| Campo     | Tipo      | Descrição                        |
|-----------|-----------|----------------------------------|
| id        | Long      | Identificador do produto         |
| nome      | String    | Nome do produto                  |
| preco     | Double    | Preço do produto                 |
| categoria | Categoria | Categoria associada ao produto   |

**Relacionamento:**

- Um produto pertence a **uma única categoria**.  
- Uma categoria pode conter **vários produtos** (relação OneToMany).

---

## 🧪 Endpoints Disponíveis

### 📁 Categoria

| Método | Endpoint           | Ação                        |
|--------|--------------------|-----------------------------|
| POST   | `/categorias`      | Criar nova categoria        |
| GET    | `/categorias`      | Listar todas as categorias  |
| PUT    | `/categorias/{id}` | Atualizar categoria         |
| DELETE | `/categorias/{id}` | Remover categoria           |

### 📦 Produto

| Método | Endpoint          | Ação                        |
|--------|-------------------|-----------------------------|
| POST   | `/produtos`       | Criar novo produto          |
| GET    | `/produtos`       | Listar todos os produtos    |
| PUT    | `/produtos/{id}`  | Atualizar produto           |
| DELETE | `/produtos/{id}`  | Remover produto             |

---

## 🧰 Configuração do Projeto

1. Clone o repositório:

```bash
git clone https://github.com/yarazip/GestaoProdutos.git
