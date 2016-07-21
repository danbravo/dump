package Lesson10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MethodsFact {

    public static WebDriver driver;
    public static final int DEFAULT_WAIT_TIME = 30;
    public String currentBrowser;

    public boolean ifElementIsPresent(By by, int sec) {
        driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
        List<WebElement> elementList = driver.findElements(by);
        driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_TIME, TimeUnit.SECONDS);
        return elementList.size() > 0;
    }

    public void type(By locator, String text) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBe(locator, text));
    }
}
