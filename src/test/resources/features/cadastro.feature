#language: pt
Funcionalidade: Validar email com erro
  Cenario: Validar mensagem de erro ao digitar um email invalido
    Dado que eu esteja na pagina de cadastro
    Quando eu preencha o campo email:"contato.qaacademy.com.br"
    Entao valido que a mensagem: "Formato inválido" foi exibida