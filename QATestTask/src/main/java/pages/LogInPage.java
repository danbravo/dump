package pages;

import core.MethodsFact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class LogInPage extends MethodsFact{
    private By emailFld = By.xpath("//*[@id='form-login-email']");
    private By passFld = By.xpath("//*[@id='form-login-password']");
    private By logInBtn = By.xpath("//*[@id='form-login-submit']");

    @Step("Typing email : {0}")
    public void typeEmail(String email) {
        type(emailFld, email);
    }

    @Step("Typing pass : {0}")
    public void typePass(String pass) {
        type(passFld, pass);
    }

    @Step("Pressing the login button")
    public void clickLogInBtn() {
        click(logInBtn);
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return d.findElements(By.xpath("//*[@id='fnamemy_docs']")).size() > 0;
            }
        });
    }
}
