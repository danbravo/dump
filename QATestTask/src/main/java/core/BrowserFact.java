package core;

import api.PdfFillerApiCalls;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.MainPage;
import java.util.concurrent.TimeUnit;

public class BrowserFact extends MethodsFact{

    public MainPage mainPage = new MainPage();
    public PdfFillerApiCalls apiCalls = new PdfFillerApiCalls();

    @Parameters("browser")
    @BeforeTest
    public void setUp(@Optional("CH") String browser) {
        if (browser.equals("CH")) {
            driver = new ChromeDriver();
        } else if (browser.equals("FF")) {
            driver = new FirefoxDriver();
        } else if (browser.equals("OP")) {
            driver = new OperaDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(DEFAULT_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(DEFAULT_WAIT_TIME, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
