package tests;

import core.BrowserFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pageObject.AkinatorMain;

import java.util.concurrent.TimeUnit;

public class AkinatorPlay extends BrowserFactory{

    public void playAkinator() {
        AkinatorMain akinator = new AkinatorMain();
        akinator.play();
    }

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        AkinatorMain akinator = new AkinatorMain();
        akinator.play();
        driver.close();
        driver.quit();
    }
}
