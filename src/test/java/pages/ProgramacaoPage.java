package pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProgramacaoPage{
    ChromeDriver browser = new ChromeDriver();

    private String url = "https://www.sky.com.br/";
    final By btnclose = By.xpath("//div[@class='modal-header borderless']/button[@class='close']");
    final By btnProgramacao = By.xpath("//nav[@id='main-menu']//div/ul[@class='nav navbar-nav menu-link menu-link-top']/li/a/strong[text()='Programação']");
    private String body = null;

    public ProgramacaoPage() {

    }

    public void abrirPagina(){
        browser.manage().window().maximize();
        browser.get("https://www.sky.com.br/");
    }

    public void fecharModal() throws InterruptedException {

        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.findElement(btnclose).click();
    }
    public void selecionarMenuProgramacao() throws InterruptedException {
          browser.findElement(btnProgramacao).click();

    }
    public void verificandoProgramacaoAtual() throws InterruptedException  {
        List<WebElement> listTitle = browser.findElements(By.xpath("//div[@class='progress-bar']/../div[@class='program-schedule-content']/h2"));
        List<WebElement> listHora  = browser.findElements(By.xpath("//div[@class='progress-bar']/../div[@class='program-schedule-content']/h2//..//../div/div[@class='program-schedule-info']/div/p"));

        for(WebElement t : listTitle) {
            for(WebElement h : listHora) {
                System.out.println(t.getText());
                System.out.println(h.getText());
                System.out.println("-------------");
            }
        }

    }

    public void selecionarProgramacaoAtual() throws InterruptedException  {

        browser.findElement(By.xpath("//*[@id=\"schedules-container\"]/div/span[text()='Passando Agora']")).click();

        WebElement listTitleProg = browser.findElement(By.xpath("//div[@class='progress-bar']/../div[@class='program-schedule-content']/h2"));
        WebElement listHoraProg  = browser.findElement(By.xpath("//div[@class='progress-bar']/../div[@class='program-schedule-content']/h2//..//../div/div[@class='program-schedule-info']/div/p"));

        WebElement listTitleModal = browser.findElement(By.xpath("//*[@id='modal']//div//div[@class='sky-modal-container']//div[@class='sky-modal-program-title']/h2"));
        WebElement listHoraModal  = browser.findElement(By.xpath("//*[@id='modal']//div//div[@class='sky-modal-container']//div[@class='sky-modal-program-date-time']/span"));

        Thread.sleep(3000);
        System.out.println( listTitleProg.getText());
        listTitleProg.click();
        Thread.sleep(3000);
        System.out.println( listTitleModal.getText());
    }

    public void comparaTextoModal(){

        WebElement listTitleProg = browser.findElement(By.xpath("//div[@class='progress-bar']/../div[@class='program-schedule-content']/h2"));
        WebElement listHoraProg  = browser.findElement(By.xpath("//div[@class='progress-bar']/../div[@class='program-schedule-content']/h2//..//../div/div[@class='program-schedule-info']/div/p"));

        WebElement listTitleModal = browser.findElement(By.xpath("//*[@id='modal']//div//div[@class='sky-modal-container']//div[@class='sky-modal-program-title']/h2"));
        WebElement listHoraModal  = browser.findElement(By.xpath("//*[@id='modal']//div//div[@class='sky-modal-container']//div[@class='sky-modal-program-date-time']/span"));

        Assert.assertEquals(true,listTitleProg.equals(listTitleModal));
        Assert.assertEquals(true,listHoraProg.equals(listHoraModal));

    }

    public void fecharPagina(){
        browser.close();
    }

}


