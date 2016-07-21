package Lesson10;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestLoginAgain extends BrowserFact{


    @DataProvider(name = "strings")
    public Object[][] strings() {
        return new Object[][] {
                {"1"},
                {"2"},
                {"3"},
                {"4"}
        };
    }

    @DataProvider(name = "loginPages")
    public Object[][] loginPages() {
        return new Object[][] {
                {new VkLogin()},
                {new FacebookLogin()}
        };
    }

    @Test(dataProvider = "loginPages")
    public void tryLoginPages(AbstractLogin login) {
        login.login("user", "pass");
    }

    @Test
    public void tryLogin() {
        AbstractLogin login = new VkLogin();
        login.login("Jack", "ILoveJustinBieber");
    }

    public void loginAnySite(AbstractLogin login) {
        login.login("name", "pass");
    }
}
