package Lesson10;

import Lesson13New.MainPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BrowserFact extends MethodsFact{

    public MainPage page = new MainPage();

    @BeforeTest
    public void setUpBrowser() {
        driver = new ChromeDriver();
        currentBrowser = "Chrome";
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(DEFAULT_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_TIME, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
