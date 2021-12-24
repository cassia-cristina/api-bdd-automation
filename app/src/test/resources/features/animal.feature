#language: pt

Funcionalidade: Gerencimento de um animal da loja

  Cenario: Lista somente animais disponiveis para venda
    Dado que eu possua animais available
    Quando eu pesquiso por todos os animais available
    Entao eu recebo a lista de animais available
    # Utilizando coleções groovy:
    E 2 animais possuem o nome Cat

  Cenario: Lista somente animais pendentes para venda
    Dado que eu possua animais pending
    Quando eu pesquiso por todos os animais pending
    Entao eu recebo a lista com 2 animais

  Cenario: Lista somente animais vendidos
    Dado que eu possua animais sold
    Quando eu pesquiso por todos os animais sold
    Entao eu recebo a lista com 1 animal

  Cenario: Nao lista nenhum animal
    Dado que eu nao possua animais sold
    Quando eu pesquiso por todos os animais sold
    Entao eu recebo a lista com 0 animais

  Esquema do Cenario: Lista animais pelo seu estado de venda
    Dado que eu nao possua animais sold
    Quando eu pesquiso por todos os animais <estado>
    Entao eu recebo a lista com <quantidade> animais
    Exemplos: Animais em estoque
      | estado    | quantidade |
      | available | 7          |
      | pending   | 2          |
    Exemplos: Animais sem estoque
      | estado | quantidade |
      | sold   | 0          |