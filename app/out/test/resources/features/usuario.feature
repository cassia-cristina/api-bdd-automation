#language: pt

Funcionalidade: Gerenciamento de um usuario na api PetStore
  Deve ser possível realizar um cadastro de usuario
  na loja PetStore com sucesso.

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
    Entao ao fazer um GET para "/user/cassia" deve retornar o usuario criado


  Cenario: Criar um usuario na loja com escrita voltada ao negocio
    Quando realizo o cadastro de um usuario
    Entao o usuario deve ser salvo




