package Lesson13New;

import Lesson10.BrowserFact;
import org.testng.annotations.Test;

public class TestLogin extends BrowserFact {

    @Test
    public void testLog() {
        page.openPage();
        page.typeEmail("LolikTest1@mail.ru");
        page.typePass("qwe1rty2");
        page.clickLoginBtn();
    }
}
