package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class MainPage extends MethodsFactory {
    String link = "https://kismia.com/";
    By emailFld = By.xpath("//*[@id='user-email']");
    By passFld = By.xpath("//*[@id='user-password']");
    By submitBtn = By.xpath("//*[@id='sign-in-form']/button");

    @Step("Opening main page")
    public void navMain() {
        driver.get(link);
    }

    @Step("Typing email in: {0}")
    public void typeEmail(String email) {
        driver.findElement(emailFld).clear();
        driver.findElement(emailFld).sendKeys(email);
    }

    @Step("Typing password in: {0}")
    public void typePass(String pass) {
        driver.findElement(passFld).clear();
        driver.findElement(passFld).sendKeys(pass);
    }

    @Step("Clicking submit button")
    public void clickSubmit() {
        driver.findElement(submitBtn).click();
        new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return webDriver.findElements(By.xpath("//*[@id='right_head']/a")).size() > 0;
            }
        });
    }
}
