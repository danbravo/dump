package Lesson10;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestLogin extends BrowserFact{

    By btn = By.xpath("//*[@id='loginbutton']");

    @Test(priority = 2)
    public void tryTest1() {
        System.out.println("executing test1 on "+currentBrowser);
        driver.get("https://google.com");
    }

    @Test(priority = 1)
    public void tryTest2() {
        System.out.println("executing test2 on "+currentBrowser);
        driver.get("https://www.facebook.com/");
        boolean isButtonPresent = ifElementIsPresent(btn, 5);
        if (isButtonPresent) {
            System.out.println("Element is present");
        } else {
            System.out.println("Element is not present");
        }
        System.out.println(isButtonPresent);
    }
}
