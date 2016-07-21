package pageObject;

import core.AbstractLogIn;
import org.openqa.selenium.By;
import org.testng.Assert;

public class NewFbMainPage extends AbstractLogIn{

    @Override
    public void openPage() {
        driver.get("https://www.facebook.com/");
    }

    @Override
    public void typeEmail(String email) {
        type(By.xpath("//*[@id='email']"), email);
    }

    @Override
    public void typePass(String pass) {
        type(By.xpath("//*[@id='pass']"), pass);
    }

    @Override
    public void clickSubmit() {
        click(By.xpath("//*[@id='loginbutton']"));
    }

    @Override
    public void verifyLogIn() {
        Assert.assertTrue(isElementPresent(By.xpath("//*[@id='userNavigationLabel']"), 3));
    }

}
