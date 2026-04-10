# Módulo de Persistência Acadêmica

Atividade prática da disciplina de **Programação Orientada a Objetos** — UNIPAC Barbacena  
Professor: Felipe Roncalli de Paula Carneiro | Data: 10/04/2026

---

## Sobre o projeto

Sistema desenvolvido para automatizar o registro de membros da faculdade (Alunos e Professores) em um banco de dados MySQL, aplicando os conceitos de **abstração**, **herança**, **polimorfismo** e o padrão de projeto **DAO**.

---

## Conceitos aplicados

| Conceito | Onde foi aplicado |
|---|---|
| Classe Abstrata | `Pessoa.java` — contém os atributos comuns e o método abstrato `exibirIdentificacao()` |
| Herança | `Aluno` e `Professor` herdam de `Pessoa` |
| Polimorfismo | O método `exibirIdentificacao()` é chamado sem conhecer o tipo exato do objeto |
| Padrão DAO | `AcademicoDAO.java` encapsula toda a lógica JDBC (conexão, INSERT, SELECT) |
| `instanceof` | Usado no `salvarPessoa()` para identificar o tipo e direcionar ao INSERT correto |

---

## Estrutura do projeto

```
src/
├── Pessoa.java          # Classe abstrata base
├── Aluno.java           # Herda de Pessoa, implementa exibirIdentificacao()
├── Professor.java       # Herda de Pessoa, implementa exibirIdentificacao()
├── AcademicoDAO.java    # Toda a lógica JDBC (conexão, salvar, listar)
└── Main.java            # Classe de teste e validação
```

---

## Banco de dados

- **SGBD:** MySQL via XAMPP
- **Banco:** `unipac_academico`
- **Tabelas:** `alunos` e `professores`

Script de criação das tabelas:

```sql
CREATE TABLE IF NOT EXISTS alunos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    matricula VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS professores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    registro_funcional VARCHAR(20) NOT NULL,
    disciplina_principal VARCHAR(100) NOT NULL
);
```

---

## Como executar

1. Inicie o **XAMPP** e ative o módulo **MySQL**
2. No phpMyAdmin, crie o banco `unipac_academico` e execute o script SQL acima
3. Abra o projeto no **IntelliJ IDEA**
4. Adicione o driver MySQL via Maven: `mysql:mysql-connector-java:8.0.33`
5. Execute a classe `Main.java`

---

## Saída esperada no console

```
=== Identificações ===
ALUNO     | Nome: Carlos Silva | CPF: 111.222.333-44 | Matrícula: 2026001
PROFESSOR | Nome: Ana Souza    | CPF: 555.666.777-88 | RF: RF-2024 | Disciplina: Programação Orientada a Objetos

=== Salvando no banco... ===
Aluno salvo com sucesso!
Professor salvo com sucesso!

=== Dados recuperados do banco ===
ALUNO     | Nome: Carlos Silva | CPF: 111.222.333-44 | Matrícula: 2026001
PROFESSOR | Nome: Ana Souza    | CPF: 555.666.777-88 | RF: RF-2024 | Disciplina: Programação Orientada a Objetos
```
