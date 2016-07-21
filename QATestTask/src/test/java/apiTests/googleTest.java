package apiTests;

import core.BrowserFact;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class googleTest extends BrowserFact{

    @Test
    public void logoVerify() {
        driver.get("https://www.google.com.ua/");
        boolean hplogo = driver.findElements(By.id("hplogo")).size() > 0;
        Assert.assertTrue(hplogo);
    }
}
