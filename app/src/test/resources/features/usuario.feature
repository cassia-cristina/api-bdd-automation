#language: pt

Funcionalidade: Gerenciamento de um usuario na api PetStore

  Contexto:
    Dado que estou utilizando o servico http://localhost:12345/api/v3

  Cenario: Criar um usuario na loja
    Quando faco um POST para "/user" com os seguintes valores
      | id         | 11               |
      | username   | cassia           |
      | firstName  | Cassia           |
      | lastName   | Souza            |
      | email      | cassia@gmail.com |
      | password   | 12345            |
      | phone      | 32480000         |
      | userStatus | 1                |
    Entao ao fazer um GET para /user/cassia deve retornar o usuario criado

  Cenario: Criar um usuario na loja com a escrita facilitada
    Quando cadastro um usuario
    Entao o usuario e salvo no sistema




