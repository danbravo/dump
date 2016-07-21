package pages;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BrowserFactory extends MethodsFactory {

    public MainPage mainPage = new MainPage();
    public FooterBlock footerBlock = new FooterBlock();

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
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
