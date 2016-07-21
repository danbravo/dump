package pageObject;

import core.MethodsFactory;
import org.openqa.selenium.By;

public class MainPage extends MethodsFactory {
    String link = "https://kismia.com/";
    By emailFld = By.xpath("//*[@id='user-email']");
    By passFld = By.xpath("//*[@id='user-password']");
    By submitBtn = By.xpath("//*[@id='sign-in-form']/button");
    By loginOption = By.xpath("//*[@id='form-log-in']");

    public MainPage() {
        driver.get(link);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void typeEmail(String email) {
        driver.findElement(emailFld).clear();
        driver.findElement(emailFld).sendKeys(email);
    }

    public void typePass(String pass) {
        driver.findElement(passFld).clear();
        driver.findElement(passFld).sendKeys(pass);
    }

    public void clickSubmit() {
        driver.findElement(submitBtn).click();
    }

    public void login(String email, String pass) {
        driver.findElement(loginOption).click();
        typeEmail(email);
        typePass(pass);
        clickSubmit();
    }
}
