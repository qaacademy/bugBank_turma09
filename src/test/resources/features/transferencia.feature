#language: pt
Funcionalidade: Transferencia de valores

  Cenario: Realizar transferencia com sucesso
    Dado que possua duas contas cadastradas com os dados
      | email                     | nome       | senha  | email_2                   | nome_2     | senha_2 |
      | teste_01@qaacademy.com.br | QA Academy | 123456 | teste_02@qaacademy.com.br | QA Academy | 123456  |
    E fazer login no bugbank com email:"teste_01@qaacademy.com.br" e a senha: "123456"
    Quando clicar no botao transferencia
    E preencher os dados da transferencia com valor: "500.00" e descrição: "QA Academy test"
    E clicar em transferir
    Entao validar se a transferencia foi feita com sucesso.