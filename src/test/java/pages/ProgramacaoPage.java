package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ProgramacaoPage {
    ChromeDriver browser = new ChromeDriver();

    final String url = "https://www.sky.com.br/";
    final By btnclose = By.xpath("//div[@class='modal-header borderless']/button[@class='close']");
    final By btnProgramacao = By.xpath("//nav[@id='main-menu']//div/ul[@class='nav navbar-nav menu-link menu-link-top']/li/a/strong[text()='Programação']");
    final By btnPrassandoAgora = By.xpath("//*[@id=\"schedules-container\"]/div/span[text()='Passando Agora']");
    final By titleProg = By.xpath("//div[@class='progress-bar']/../div[@class='program-schedule-content']/h2");
    final By horaProg = By.xpath("//div[@class='progress-bar']/../div[@class='program-schedule-content']/h2//..//../div/div[@class='program-schedule-info']/div/p");
    final By contentProgram = By.xpath("//div[@class='progress-bar']/../div[@class='program-schedule-content']");
    final By titlemodal = By.xpath("//*[@id='modal']//div//div[@class='sky-modal-container']//div[@class='sky-modal-program-title']/h2");
    final By horaModal = By.xpath("//*[@id='modal']//div//div[@class='sky-modal-container']//div[@class='sky-modal-program-date-time']/span");

    public ProgramacaoPage() {
    }

    public void abrirPagina() {
        browser.manage().window().maximize();
        browser.get(url);
    }

    public void fecharModal() {
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.findElement(btnclose).click();
    }

    public void selecionarMenuProgramacao() {
        browser.findElement(btnProgramacao).click();
    }

    public void botaoPassandoAgora() throws InterruptedException {
        browser.findElement(btnPrassandoAgora).click();
        Thread.sleep(2000);
    }

    public void selecionarProgramacaoAtual() {
        browser.findElement(contentProgram).click();
    }

    public void comparaTextoModal() {
        String titleprogramText = browser.findElement(titleProg).getText();
        String horaProgText = browser.findElement(horaProg).getText();
        String titlemodalText = browser.findElement(titlemodal).getText();
        String horaModalText = browser.findElement(horaModal).getText();

        Assert.assertEquals(true, titleprogramText.equals(titlemodalText));
        Assert.assertEquals(true, horaProgText.equals(horaModalText));
    }

    public void fecharPagina() {
        browser.close();
    }

}
