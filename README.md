# Clean Architecture com Java e Spring Boot

Este projeto demonstra a aplicação dos princípios da Clean Architecture em uma aplicação Java utilizando Spring Boot. A estrutura do projeto visa promover uma separação clara de responsabilidades, facilitando a manutenção, escalabilidade e testabilidade do código.

## 📁 Estrutura do Projeto

A organização do projeto segue os seguintes pacotes principais:

- **domain**: Contém as entidades de negócio e interfaces dos casos de uso.
- **application**: Implementa os casos de uso definidos no domínio.
- **infrastructure**: Responsável pela implementação dos adaptadores externos, como repositórios, serviços externos, etc.
- **interface**: Contém os controladores e configurações relacionadas à interface com o usuário ou APIs.

## 🚀 Tecnologias Utilizadas

- Java 17
- Spring Boot 3.x
- Maven
- Docker / Docker Compose
- JPA / Hibernate
- Banco de Dados Relacional (ex: PostgreSQL)

## ⚙️ Como Executar o Projeto

### 1. Clone o repositório:

```bash
git clone https://github.com/dougaandrade/Clean_Architecture.git
cd Clean_Architecture
