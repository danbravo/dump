package pageObject;

import core.AbstractLogIn;
import org.openqa.selenium.By;
import org.testng.Assert;

public class NewVkMainPage extends AbstractLogIn{

    @Override
    public void openPage() {
        driver.get("https://vk.com");
    }

    @Override
    public void typeEmail(String email) {
        type(By.xpath("//*[@id='quick_email']"), email);
    }

    @Override
    public void typePass(String pass) {
        type(By.xpath("//*[@id='quick_pass']"), pass);
    }

    @Override
    public void clickSubmit() {
        click(By.xpath("//*[@id='quick_login_button']"));
    }

    @Override
    public void verifyLogIn() {
        Assert.assertTrue(isElementPresent(By.xpath("//*[@id='myprofile']"), 3));
    }

}
