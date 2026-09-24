# Sistema de Gestão de Patrimônio

Sistema desenvolvido em **Java** para gerenciamento de patrimônios de uma instituição de educação profissional, com persistência de dados em **MySQL**.

O projeto tem como objetivo centralizar o cadastro e o controle dos patrimônios da instituição, organizando informações relacionadas a patrimônios, movimentações, usuários, cursos, locais, categorias e baixas patrimoniais.

## 📋 Sobre o projeto

O sistema está sendo desenvolvido utilizando **Java** com acesso a banco de dados **MySQL**.

Durante o desenvolvimento, estão sendo aplicados princípios de **SOLID**, buscando manter o código organizado, modular, reutilizável e com responsabilidades bem definidas.

A estrutura do projeto foi separada em pacotes de acordo com a responsabilidade de cada componente:

- **POJO** — classes responsáveis pela representação dos dados e entidades do sistema.
- **DAU** — classes responsáveis pelo acesso e comunicação com o banco de dados.
- **Janelas** — interfaces gráficas e telas utilizadas pelo sistema.
- **Imagens** — recursos visuais utilizados pelas interfaces.

## 🎯 Objetivos

O projeto busca fornecer uma aplicação capaz de auxiliar uma instituição de educação profissional no controle de seus patrimônios.

Entre os objetivos do sistema estão:

- Cadastrar patrimônios;
- Organizar patrimônios por categorias;
- Associar patrimônios a cursos e locais;
- Registrar usuários responsáveis pelos cadastros;
- Registrar movimentações de patrimônios;
- Controlar informações relacionadas à baixa de patrimônios;
- Manter os dados armazenados em um banco de dados MySQL;
- Organizar o código seguindo princípios de orientação a objetos e SOLID.

## 🛠️ Tecnologias utilizadas

| Tecnologia | Utilização |
|---|---|
| Java | Desenvolvimento da aplicação |
| MySQL | Banco de dados |
| JDBC | Comunicação entre Java e MySQL |
| Git | Controle de versão |
| GitHub | Hospedagem e colaboração do código |
| Swing | Desenvolvimento das interfaces gráficas |

## 📁 Organização do projeto

A aplicação foi organizada em pacotes de acordo com a responsabilidade de cada parte do sistema:

```text
src/
└── br/
    └── com/
        └── exemplo/
            ├── pojo/
            ├── dau/
            ├── janelas/
            └── imagens/
```

### POJO

O pacote **POJO** contém as classes utilizadas para representar as entidades e os dados manipulados pelo sistema.

Essas classes representam os objetos utilizados pela aplicação e fazem a ligação entre os dados recebidos pelas interfaces e as operações realizadas no banco de dados.

### DAU

O pacote **DAU** concentra as classes responsáveis pelo acesso aos dados.

Essas classes realizam operações de comunicação com o MySQL, como:

- Inserção de registros;
- Consulta de registros;
- Atualização de registros;
- Exclusão de registros.

> **Observação:** o projeto utiliza a camada de acesso a dados para evitar que as regras de comunicação com o banco fiquem diretamente nas telas da aplicação.

### Janelas

O pacote **Janelas** contém as interfaces gráficas do sistema.

As telas são responsáveis pela interação com o usuário, permitindo realizar operações de cadastro, consulta e gerenciamento das informações.

### Imagens

O pacote **Imagens** contém os recursos gráficos utilizados pelas interfaces da aplicação.

## 🗄️ Banco de dados

O projeto utiliza **MySQL** como sistema gerenciador de banco de dados.

O banco de dados utilizado no projeto possui as seguintes tabelas:

| Tabela | Finalidade |
|---|---|
| `baixas_patrimoniais` | Armazenamento de informações relacionadas às baixas patrimoniais |
| `categorias` | Cadastro e organização das categorias |
| `cursos` | Cadastro dos cursos |
| `locais` | Cadastro dos locais |
| `movimentacoes` | Registro das movimentações dos patrimônios |
| `patrimonios` | Cadastro e gerenciamento dos patrimônios |
| `usuarios` | Cadastro dos usuários do sistema |


``` sql
CREATE DATABASE  IF NOT EXISTS `carcosadb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `carcosadb`;
-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: carcosadb
-- ------------------------------------------------------
-- Server version	26.7.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '4240655b-a144-11f1-8295-a617eb6261f0:1-50';

--
-- Table structure for table `baixas_patrimoniais`
--

DROP TABLE IF EXISTS `baixas_patrimoniais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `baixas_patrimoniais` (
  `id` int NOT NULL AUTO_INCREMENT,
  `patrimonio_id` int NOT NULL,
  `usuario_registro_id` int NOT NULL,
  `tipo_baixa` enum('Descarte','Venda','Doação','Furto/Roubo','Extravio') NOT NULL,
  `motivo` text NOT NULL,
  `valor_recuperado` decimal(10,2) DEFAULT '0.00',
  `documento_comprobatorio` varchar(100) DEFAULT NULL,
  `data_baixa` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `patrimonio_id` (`patrimonio_id`),
  KEY `usuario_registro_id` (`usuario_registro_id`),
  CONSTRAINT `baixas_patrimoniais_ibfk_1` FOREIGN KEY (`patrimonio_id`) REFERENCES `patrimonios` (`id`) ON DELETE RESTRICT,
  CONSTRAINT `baixas_patrimoniais_ibfk_2` FOREIGN KEY (`usuario_registro_id`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baixas_patrimoniais`
--

LOCK TABLES `baixas_patrimoniais` WRITE;
/*!40000 ALTER TABLE `baixas_patrimoniais` DISABLE KEYS */;
INSERT INTO `baixas_patrimoniais` VALUES (1,2,1,'Descarte','suada dmss',10.00,'490123902431',NULL);
/*!40000 ALTER TABLE `baixas_patrimoniais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=154 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'Conhecimento','Saber Tudo'),(52,'Dança','dança eba'),(103,'salvar vidas pog','muito util');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursos`
--

DROP TABLE IF EXISTS `cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cursos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `sigla` varchar(10) NOT NULL,
  `criado_por` int DEFAULT NULL,
  `criado_em` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `criado_por` (`criado_por`),
  CONSTRAINT `cursos_ibfk_1` FOREIGN KEY (`criado_por`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=154 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursos`
--

LOCK TABLES `cursos` WRITE;
/*!40000 ALTER TABLE `cursos` DISABLE KEYS */;
INSERT INTO `cursos` VALUES (52,'Técnico em Informática','TI',2,'2026-09-09 12:56:14'),(53,'Estética','Es',53,'2026-09-09 13:05:30'),(56,'Odonto','OD',1,'2026-09-09 13:11:24'),(103,'Bombeiro','bombeiro',103,'2026-09-16 12:57:52');
/*!40000 ALTER TABLE `cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locais`
--

DROP TABLE IF EXISTS `locais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locais` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `criado_por` int DEFAULT NULL,
  `criado_em` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `criado_por` (`criado_por`),
  CONSTRAINT `locais_ibfk_1` FOREIGN KEY (`criado_por`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=154 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locais`
--

LOCK TABLES `locais` WRITE;
/*!40000 ALTER TABLE `locais` DISABLE KEYS */;
INSERT INTO `locais` VALUES (1,'Teatro','Teatro grandao irado',1,'2026-08-26 14:39:59'),(2,'Sala','SALA.',1,'2026-08-26 14:40:25'),(52,'Capela','amém',1,'2026-09-10 11:55:12'),(55,'Lago Hilia','.',1,'2026-09-10 11:59:04'),(58,'Híades','?',1,'2026-09-10 12:02:06'),(103,'Praça','praça',2,'2026-09-16 12:42:27');
/*!40000 ALTER TABLE `locais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimentacoes`
--

DROP TABLE IF EXISTS `movimentacoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movimentacoes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `patrimonio_id` int NOT NULL,
  `usuario_registro_id` int NOT NULL,
  `tipo_movimentacao` enum('Empréstimo','Devolução','Envio Manutenção','Retorno Manutenção','Transferência de Local','Baixa') NOT NULL,
  `responsavel_destino` varchar(150) DEFAULT NULL,
  `documento_responsavel` varchar(50) DEFAULT NULL,
  `data_saida` datetime DEFAULT CURRENT_TIMESTAMP,
  `data_prevista_retorno` datetime DEFAULT NULL,
  `data_retorno_efetivo` datetime DEFAULT NULL,
  `observacoes` text,
  PRIMARY KEY (`id`),
  KEY `patrimonio_id` (`patrimonio_id`),
  KEY `usuario_registro_id` (`usuario_registro_id`),
  CONSTRAINT `movimentacoes_ibfk_1` FOREIGN KEY (`patrimonio_id`) REFERENCES `patrimonios` (`id`) ON DELETE CASCADE,
  CONSTRAINT `movimentacoes_ibfk_2` FOREIGN KEY (`usuario_registro_id`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimentacoes`
--

LOCK TABLES `movimentacoes` WRITE;
/*!40000 ALTER TABLE `movimentacoes` DISABLE KEYS */;
INSERT INTO `movimentacoes` VALUES (1,1,1,'Empréstimo','wdaadwadw','sdadwadwa',NULL,'2027-10-10 00:00:00',NULL,'awddawdaw'),(2,3,1,'Empréstimo','frawa','48123941282',NULL,'2029-10-10 00:00:00',NULL,'legal');
/*!40000 ALTER TABLE `movimentacoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patrimonios`
--

DROP TABLE IF EXISTS `patrimonios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patrimonios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numero_tombamento` varchar(50) NOT NULL,
  `nome` varchar(150) NOT NULL,
  `descricao` text,
  `curso_id` int DEFAULT NULL,
  `local_id` int DEFAULT NULL,
  `categoria_id` int DEFAULT NULL,
  `status` enum('Disponível','Emprestado','Em Manutenção','Baixado/Inativo') DEFAULT 'Disponível',
  `valor_aquisicao` decimal(10,2) DEFAULT NULL,
  `data_aquisicao` date DEFAULT NULL,
  `criado_por` int NOT NULL,
  `atualizado_por` int DEFAULT NULL,
  `criado_em` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `atualizado_em` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `numero_tombamento` (`numero_tombamento`),
  KEY `curso_id` (`curso_id`),
  KEY `local_id` (`local_id`),
  KEY `categoria_id` (`categoria_id`),
  KEY `criado_por` (`criado_por`),
  KEY `atualizado_por` (`atualizado_por`),
  CONSTRAINT `patrimonios_ibfk_1` FOREIGN KEY (`curso_id`) REFERENCES `cursos` (`id`) ON DELETE SET NULL,
  CONSTRAINT `patrimonios_ibfk_2` FOREIGN KEY (`local_id`) REFERENCES `locais` (`id`) ON DELETE SET NULL,
  CONSTRAINT `patrimonios_ibfk_3` FOREIGN KEY (`categoria_id`) REFERENCES `categorias` (`id`) ON DELETE SET NULL,
  CONSTRAINT `patrimonios_ibfk_4` FOREIGN KEY (`criado_por`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `patrimonios_ibfk_5` FOREIGN KEY (`atualizado_por`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patrimonios`
--

LOCK TABLES `patrimonios` WRITE;
/*!40000 ALTER TABLE `patrimonios` DISABLE KEYS */;
INSERT INTO `patrimonios` VALUES (1,'2131','awdad','',52,1,1,'Disponível',1.00,'2020-10-10',1,NULL,'2026-09-16 12:55:02','2026-09-16 12:55:02'),(2,'123123','Meia Suada','muito suada',52,1,1,'Disponível',492.00,'2019-10-01',1,NULL,'2026-09-16 12:56:24','2026-09-16 12:56:24'),(3,'481298421','Extintor','de incêndio',103,52,103,'Emprestado',2341.00,'2000-10-10',103,NULL,'2026-09-16 12:58:49','2026-09-16 12:58:49');
/*!40000 ALTER TABLE `patrimonios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `senha_hash` varchar(255) NOT NULL,
  `perfil` enum('Administrador','Coordenador','Assistente') DEFAULT 'Assistente',
  `ativo` tinyint(1) DEFAULT '1',
  `criado_em` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `atualizado_em` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=154 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Julio','Julio@email.com','123@Senac','Assistente',1,'2026-08-26 13:44:15','2026-08-26 13:44:15'),(2,'Alex','redninja@email.com','123@Senac','Assistente',1,'2026-08-26 13:45:28','2026-08-26 13:45:28'),(52,'matheus','matheusfodao@email.com','prometheus','Administrador',0,'2026-09-04 12:37:14','2026-09-04 12:37:14'),(53,'gabriel','emailelgal','123123','Administrador',1,'2026-09-04 13:45:59','2026-09-04 13:45:59'),(103,'Guilherme','guilherme@email.com','123321321','Administrador',1,'2026-09-16 12:42:55','2026-09-16 12:42:55');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-09-24  9:32:10

```


### Modelo geral dos dados

As principais entidades do sistema estão relacionadas ao gerenciamento do ciclo de vida dos patrimônios.

De forma geral:

```text
                    ┌──────────────┐
                    │   USUÁRIOS   │
                    └──────┬───────┘
                           │
                           │
        ┌──────────────────┼──────────────────┐
        │                  │                  │
        ▼                  ▼                  ▼
   ┌──────────┐      ┌───────────────┐   ┌─────────────┐
   │  CURSOS  │      │  MOVIMENTAÇÕES│   │   BAIXAS    │
   └────┬─────┘      └───────┬───────┘   │ PATRIMONIAIS│
        │                     │            └──────┬──────┘
        │                     │                   │
        └────────────┬────────┴───────────────────┘
                     ▼
              ┌─────────────┐
              │ PATRIMÔNIOS │
              └──────┬──────┘
                     │
              ┌──────┴──────┐
              ▼             ▼
        ┌───────────┐   ┌────────┐
        │ CATEGORIAS│   │ LOCAIS │
        └───────────┘   └────────┘
```

> O diagrama acima representa a organização conceitual das entidades com base nas tabelas apresentadas no projeto. Os relacionamentos específicos e suas cardinalidades dependem da definição completa das chaves e restrições do banco de dados.

## 🧱 Arquitetura e organização

A separação das responsabilidades é uma parte importante do projeto.

A aplicação procura manter uma divisão entre:

```text
Interface gráfica
       │
       ▼
Objetos / POJOs
       │
       ▼
Camada de acesso a dados (DAU)
       │
       ▼
     MySQL
```

Essa organização facilita a manutenção do sistema e evita concentrar toda a lógica em uma única classe.

## 🧩 Princípios SOLID

O desenvolvimento do projeto considera os princípios **SOLID** como referência para organização e evolução do código.

### S — Single Responsibility Principle

Cada classe deve possuir uma responsabilidade bem definida.

Por exemplo, as classes de acesso a dados ficam responsáveis pelas operações relacionadas ao banco, enquanto as janelas ficam responsáveis pela interface gráfica.

### O — Open/Closed Principle

As estruturas do sistema devem buscar permitir extensão sem exigir alterações desnecessárias em código já existente.

### L — Liskov Substitution Principle

As implementações devem respeitar os contratos definidos pelas abstrações e interfaces utilizadas no projeto.

### I — Interface Segregation Principle

As interfaces devem evitar obrigar as classes a implementar funcionalidades que não sejam necessárias para suas responsabilidades.

### D — Dependency Inversion Principle

O projeto busca reduzir o acoplamento entre as diferentes partes da aplicação, favorecendo o uso de abstrações e separação de responsabilidades.

> Os princípios SOLID estão sendo utilizados como orientação de projeto e podem ser aprimorados conforme o desenvolvimento da aplicação evolui.

## 🔄 Operações de acesso aos dados

As classes de acesso aos dados seguem uma estrutura baseada em operações CRUD:

```text
C — Create  → Cadastrar
R — Read    → Listar / Consultar
U — Update  → Atualizar
D — Delete  → Deletar
```

Essa abordagem permite padronizar as operações realizadas pelas diferentes entidades do sistema.

## 💻 Pré-requisitos

Para executar e desenvolver o projeto, são necessários:

- Java instalado;
- MySQL instalado e configurado;
- Uma IDE compatível com Java;
- Driver JDBC para conexão com MySQL;
- Git, caso o projeto seja obtido através do GitHub.

## 🚀 Como executar o projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/JulioSalamoni/patrimoniojava.git
```

Depois:

```bash
cd patrimoniojava
```

### 2. Configurar o banco de dados

Crie o banco de dados MySQL utilizado pelo projeto e configure as tabelas necessárias.

A conexão com o banco deve ser configurada de acordo com os parâmetros utilizados pela aplicação:

```text
Host
Porta
Usuário
Senha
Banco de dados
```

### 3. Configurar a conexão Java/MySQL

Verifique a classe responsável pela conexão com o banco e configure os dados de acesso do ambiente local.

Exemplo conceitual:

```java
String url = "jdbc:mysql://localhost:3306/nome_do_banco";
String usuario = "root";
String senha = "sua_senha";
```

Os valores devem ser adaptados para o ambiente em que o projeto será executado.

### 4. Executar a aplicação

Abra o projeto na IDE utilizada, verifique as dependências e execute a classe principal da aplicação.

## 🔐 Boas práticas

Durante o desenvolvimento, algumas práticas são consideradas importantes:

- Separação de responsabilidades;
- Uso de classes POJO para representação dos dados;
- Utilização de uma camada específica para acesso ao banco;
- Uso de `PreparedStatement` nas operações SQL;
- Evitar lógica de banco de dados diretamente nas interfaces;
- Reutilização de estruturas comuns através de interfaces e classes;
- Organização do código por responsabilidade.

## 📌 Status do projeto

🚧 **Em desenvolvimento**

O sistema está sendo desenvolvido e novas funcionalidades, melhorias de interface, validações e operações de banco de dados podem ser adicionadas ao longo do projeto.

## 👨‍💻 Autor

**Julio Salamoni**

Projeto desenvolvido para fins de estudo e desenvolvimento de uma solução de gerenciamento patrimonial para uma instituição de educação profissional.

## 📄 Licença

Este projeto ainda não possui uma licença definida.

Caso o projeto seja disponibilizado publicamente para uso ou distribuição, recomenda-se definir uma licença apropriada.
