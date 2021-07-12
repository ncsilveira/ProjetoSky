package steps;

import cucumber.api.java.es.Dado;
import cucumber.api.java.it.E;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Entao;
import pages.ProgramacaoPage;

public class ConsultarProgramacaoAtualSteps {

    final ProgramacaoPage programacao = new ProgramacaoPage();

    @Dado("^que o usuario acesse o site da Sky$")
    public void acessarSiteSky() {
        programacao.abrirPagina();
    }

    @Quando("^fechar a modal$")
    public void fecharModal() {
        programacao.fecharModal();
    }

    @E("^clicar no menu programação$")
    public void clicarMenuProgramacao() {
        programacao.selecionarMenuProgramacao();
    }
    @Quando("^selecionar o botão passando agora$")
    public void selecionarBotaoPassandoAgora() throws InterruptedException {
        programacao.botaoPassandoAgora();
    }

    @Quando("^selecionar a programação atual$")
    public void selecionarProgramacaoAtual() {
        programacao.selecionarProgramacaoAtual();
    }

    @Entao("^o sistema deve exibir uma modal com as informações da programacao$")
    public void comparaDadosModaleProgramacaoAtual() {
        programacao.comparaTextoModal();
        programacao.fecharPagina();
    }
}
