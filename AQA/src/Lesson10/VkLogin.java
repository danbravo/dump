package Lesson10;

import org.openqa.selenium.By;
import org.testng.Assert;

public class VkLogin extends AbstractLogin {

    @Override
    public void openPage() {
        driver.get("https://vk.com");
    }


    public void verifyLogo() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='top_home_link']")).isDisplayed());
    }

    @Override
    public void typeLogin(String login) {

    }

    @Override
    public void typePassword(String pass) {

    }

    @Override
    public void clickSubmit() {

    }
}
