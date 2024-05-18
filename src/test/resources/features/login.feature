#language: pt
  Funcionalidade: Funcionalidade de login no bugbank
    Cenario: Teste Saldo Inicial R$ 1.000,00
      Dado que eu possua cadastrado no bugbak o email: "teste.teste@gmail.com", nome: "Teste" e a senha: "QAACADEMY"
      E que eu esteja logado no bugbank com email:"teste.teste@gmail.com" e a senha: "QAACADEMY"
      Quando carregar a homepage
      Entao validar se o saldo é igual: "1.000,00"
