# TSS Auth
## Autorizador e Autenticador JWT

## Descrição

API para separar o parte de geração e autencitação jwt. Após a geração uma aplicação cliente poderá guardar esse token em seu storage de preferência e usar para consumir outros recursos que estejam protegidos. Após a expiração, basta gerar novamente um novo token e repetir o processo.

## Tech

- [JAVA 11] - Linguagem de programação
- [Spring boot] - Framework
- [Spring Security] - Para tratar da seguraça da API.
- [JJWT] - Boblioteca para auxiliar nas operações com o Token.

## Recursos para testar

Segue os recursos para testar.

Descrição | Recurso

| Cadastrar Usuário | [URL][/users] |

| Gerar Token | [URL][/users] |

| Recurso Protegido | [URL][/resource-protected] |
