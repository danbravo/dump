import pages.BrowserFactory;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Stories;

@Stories("Verifying all footer block option buttons")
public class FooterTest extends BrowserFactory{

    @Test(priority = 0)
    public void openMainPage() {
        mainPage.navMain();
    }

    @Test(priority = 1)
    public void clickAboutBtn() {
        footerBlock.clickAboutBtn();
    }

    @Test(priority = 2)
    public void clickSupportBtn() {
        footerBlock.clickSupportBtn();
    }

    @Test(priority = 3)
    public void clickTipsBtn() {
        footerBlock.clickTipsBtn();
    }

    @Test(priority = 4)
    public void clickStoriesBtn() {
        footerBlock.clickStoriesBtn();
    }

    @Test(priority = 5)
    public void clickContactsBtn() {
        footerBlock.clickContactsBtn();
    }

    @Test(priority = 6)
    public void clickPrivacyBtn() {
        footerBlock.clickPrivacyBtn();
    }

    @Test(priority = 7)
    public void clickPartnersBtn() {
        footerBlock.clickPartnersBtn();
    }
}
