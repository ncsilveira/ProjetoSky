package steps;
import cucumber.api.java.es.Dado;
import cucumber.api.java.it.E;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Entao;
import pages.ProgramacaoPage;

public class ConsultarProgramacaoAtualSteps {

    private ProgramacaoPage programacao = new ProgramacaoPage();

    @Dado("^que o usuario acesse o site da Sky$")
    public void que_o_usuario_acesse_o_site_da_Sky() throws Throwable {
        programacao.abrirPagina();
    }
    @Quando("^fechar a modal$")
    public void fechar_a_modal() throws Throwable {
        programacao.fecharModal();
    }
    @E("^clicar no menu programação$")
    public void clicar_no_menu_programação() throws Throwable {
        programacao.selecionarMenuProgramacao();
    }
    @Quando("^selecionar a programação atual$")
    public void selecionar_a_programação_atual() throws Throwable {
       // programacao.selecionarProgramacaoAtual();
        programacao.verificandoProgramacaoAtual();
    }
    @Entao("^o sistema deve exibir uma modal com as informações da programacao$")
    public void compara_dados_da_programacao_atual() throws Throwable {
        programacao.comparaTextoModal();
        programacao.fecharPagina();
    }
}
