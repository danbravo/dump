package pageObject;

import core.AbstractLogIn;
import org.openqa.selenium.By;
import org.testng.Assert;

public class NewSchoolMainPage extends AbstractLogIn {

    @Override
    public void openPage() {
        driver.get("https://app.schoology.com/login");
    }

    @Override
    public void typeEmail(String email) {
        type(By.xpath("//*[@id='edit-mail']"), email);
    }

    @Override
    public void typePass(String pass) {
        type(By.xpath("//*[@id='edit-pass']"), pass);
    }

    @Override
    public void clickSubmit() {
        click(By.xpath("//*[@id='edit-submit']"));
    }

    @Override
    public void verifyLogIn() {
        Assert.assertTrue(isElementPresent(By.xpath("//*[@id='profile']"), 3));
    }

}
