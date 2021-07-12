package steps;
import cucumber.api.Scenario;
import org.openqa.selenium.WebDriver;

public class BaseSteps {

    public static WebDriver browser;
    public static Scenario scenario;

    public static void OpenBrowser() throws Throwable {
        if (browser != null)
            return;
    }

    public static void CloseBrowser() throws Throwable {
        if (browser == null)
            return;
        browser.quit();
        browser = null;
        Thread.sleep(1500);
    }
}
