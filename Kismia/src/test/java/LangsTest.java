import pages.BrowserFactory;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Stories;

@Stories("Changing an verifying all language option buttons")
public class LangsTest extends BrowserFactory{

    @Test(priority = 0)
    public void openMainPage() {
        mainPage.navMain();
    }

    @Test(priority = 1)
    public void verEngLangBtn() {
        footerBlock.clickEnglishLangBtn();
    }

    @Test(priority = 2)
    public void verPortLangBtn() {
        footerBlock.clickPortugLangBtn();
    }

    @Test(priority = 3)
    public void verEspLangBtn() {
        footerBlock.clickEspanLangBtn();
    }

    @Test(priority = 4)
    public void verFrLangBtn() {
        footerBlock.clickFrenchLangBtn();
    }

    @Test(priority = 5)
    public void verRusLangBtn() {
        footerBlock.clickRussianLangBtn();
    }
}
