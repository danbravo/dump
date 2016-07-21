package Lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class Browser {

    public static WebDriver driver;

    public static void startFirefox() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    public static void startChrome() {
        //System.setProperty("webdriver.chrome.driver", "C:\\\\chromedriver\\\\chromedriver.exe");
        driver = new ChromeDriver();
        setImpWait(30, TimeUnit.SECONDS);
        pageLoad(30, TimeUnit.SECONDS);
        setScriptTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static void setImpWait(long time, TimeUnit unit) {
        driver.manage().timeouts().implicitlyWait(time, unit);
    }

    public static void setScriptTimeout(long time, TimeUnit unit) {
        driver.manage().timeouts().setScriptTimeout(time, unit);
    }

    public static void pageLoad(long time, TimeUnit unit) {
        driver.manage().timeouts().pageLoadTimeout(time, unit);
    }

    public static void goTo(String s) {
        driver.get(s);
    }

    public static String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public static String getAttribute(By locator, String atr) {
        return driver.findElement(locator).getAttribute(atr);
    }

    public static void type(By locator, String text) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public static void press(By locator){
        driver.findElement(locator).click();
    }

    public static void exitChrome() {
        driver.close();
        driver.quit();
    }

    public static void exitFirefox() {
        driver.close();
        driver.quit();
    }
}
