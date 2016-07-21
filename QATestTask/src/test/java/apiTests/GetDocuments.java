package apiTests;

import core.BrowserFact;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import java.util.ArrayList;
import java.util.List;

@Features({"GET API request"})
@Stories({"Getting docs (API call), verifying the doc quantity (Web)"})
public class GetDocuments extends BrowserFact{
    private List<Integer> docIds = new ArrayList<>();

    @Test(priority = 0)
    public void getDocs() {
        docIds = apiCalls.getDocuments();
    }

    @Test(priority = 1)
    public void openMainPage() {
        mainPage.openMainPage();
    }

    @Test(priority = 2)
    public void openLogInPage() {
        mainPage.openLogInPage();
    }

    @Parameters({"email"})
    @Test(priority = 3)
    public void typeEmail(@Optional("testtask@test.test") String email) {
        mainPage.logInPage.typeEmail(email);
    }

    @Parameters({"pass"})
    @Test(priority = 4)
    public void typePass(@Optional("qwe1rty2") String pass) {
        mainPage.logInPage.typePass(pass);
    }

    @Test(priority = 5)
    public void clickLogInBtn() {
        mainPage.logInPage.clickLogInBtn();
    }

    @Test(priority = 6)
    public void clickAllDocsMenu() {
        mainPage.formsPage.clickAllDocsMenuBtn();
    }

    @Test(priority = 7)
    public void verifyDocs() {
        Assert.assertTrue(docIds.size()==mainPage.formsPage.getAllDocsSize());
    }
}
