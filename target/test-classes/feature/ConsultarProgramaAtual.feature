#language:pt
@consultarProgramaAtual
Funcionalidade: Consultar programa atual
  Eu como usuário quero selecionar a programacao
  que esta passando na hora atual para validar a consulta

  @FluxoBasico
  Cenario: Selecionar programa atual
    Dado que o usuario acesse o site da Sky
    Quando fechar a modal
    E clicar no menu programação
    E selecionar o botão passando agora
    E selecionar a programação atual
    Entao o sistema deve exibir uma modal com as informações da programacao


