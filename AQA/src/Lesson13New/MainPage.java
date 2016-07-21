package Lesson13New;

import Lesson10.MethodsFact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends MethodsFact{
    private By passwordFld = By.id("user-password");
    private By emailFld = By.id("user-email");
    private By loginBtn = By.cssSelector(".submit");

    public void clickLoginBtn() {
        driver.findElement(loginBtn).click();
    }

    public void typeEmail(String emailText) {
        type(emailFld, emailText);
    }

    public void typePass(String passText) {
        type(passwordFld, passText);
    }

    public void openPage() {
        driver.get("https://kismia.com");
    }



}
