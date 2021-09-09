package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ProgramacaoPage {

    ChromeDriver browser = null;

    final String url = "https://www.sky.com.br/";
    final By btFecharPath = By.xpath("//div[@class='modal-header borderless']/button[@class='close']");
    final By btProgramacaoPath = By.xpath("//nav[@id='main-menu']//div/ul[@class='nav navbar-nav menu-link menu-link-top']/li/a/strong[text()='Programação']");
    final By btPassandoAgoraPath = By.xpath("//*[@id=\"schedules-container\"]/div/span[text()='Passando Agora']");
    final By tituloProgramaPath = By.xpath("//div[@class='progress-bar']/../div[@class='program-schedule-content']/h2");
    final By horaProgramaPath = By.xpath("//div[@class='progress-bar']/../div[@class='program-schedule-content']/h2//..//../div/div[@class='program-schedule-info']/div/p");
    final By conteudoProgramaPath = By.xpath("//div[@class='progress-bar']/../div[@class='program-schedule-content']");
    final By tituloModalPath = By.xpath("//*[@id='modal']//div//div[@class='sky-modal-container']//div[@class='sky-modal-program-title']/h2");
    final By horaModalPath = By.xpath("//*[@id='modal']//div//div[@class='sky-modal-container']//div[@class='sky-modal-program-date-time']/span");

    public ProgramacaoPage() {
    }

    public void abrirPagina() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get(url);
    }

    public void fecharModal() {
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.findElement(btFecharPath).click();
    }

    public void selecionarMenuProgramacao() {
        browser.findElement(btProgramacaoPath).click();
    }

    public void botaoPassandoAgora() throws InterruptedException {
        browser.findElement(btPassandoAgoraPath).click();
        Thread.sleep(2000);
    }

    public void selecionarProgramacaoAtual() {
        browser.findElement(conteudoProgramaPath).click();
    }

    public void comparaTextoModal() {
        String tituloPrograma = browser.findElement(tituloProgramaPath).getText();
        String horaPrograma = browser.findElement(horaProgramaPath).getText();
        String tituloModal = browser.findElement(tituloModalPath).getText();
        String horaModalText = browser.findElement(horaModalPath).getText();

        Assert.assertEquals(true, tituloPrograma.equals(tituloModal));
        Assert.assertEquals(true, horaPrograma.equals(horaModalText));
    }

    public void fecharPagina() {
        browser.quit();
    }
}
