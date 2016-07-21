package tests;

import core.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.MainPage;

public class LogInTest extends BrowserFactory{

    @Test
    public void logIn() {
        MainPage mainPage = new MainPage();
        mainPage.login("danbravo1@mail.ru", "2342925dan");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='Kismia']")));
        Assert.assertEquals(mainPage.getUrl(), "https://kismia.com/u18332084?rg=4");
    }

}
