package pages;

import api.PdfFillerApiCalls;
import core.MethodsFact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class MainPage extends MethodsFact{
    public LogInPage logInPage = new LogInPage();
    public FormsPage formsPage = new FormsPage();

    private String url = "https://www.pdffiller.com";
    private By logInPageBtn = By.xpath("//nav[@class='h-nav']/a[5]");

    @Step("Opening main page")
    public void openMainPage() {
        driver.get(url);
    }

    @Step("Opening login page")
    public void openLogInPage() {
        click(logInPageBtn);
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return d.findElements(By.xpath("//*[@id='form-login-submit']")).size() > 0;
            }
        });
    }
}
