import pages.BrowserFactory;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Stories;

@Stories("Login with valid data")
public class LogInTest extends BrowserFactory{

    @Test(priority = 0)
    public void openMainPage() {
        mainPage.navMain();
    }

    @Parameters("email")
    @Test(priority = 1)
    public void typeEmail(@Optional("danbravo1@mail.ru") String email) {
        mainPage.typeEmail(email);
    }

    @Parameters("pass")
    @Test(priority = 2)
    public void typePass(@Optional("2342925dan") String pass) {
        mainPage.typePass(pass);
    }

    @Test(priority = 3)
    public void clickSubmitBtn() {
        mainPage.clickSubmit();
    }

}
