package tests;

import core.BrowserFactory;
import org.testng.annotations.Test;
import pageObject.VkMainPage;

public class VkTest extends BrowserFactory{

    @Test
    public void sendBirthdayMsg() {
        VkMainPage vk = new VkMainPage();
        vk.logIn("mrbravo@bigmir.net", "2342925bravo");
        vk.sendBdayMsg();
    }

    @Test
    public void showMessages() throws InterruptedException {
        VkMainPage vk = new VkMainPage();
        vk.logIn("dan.dudelife.bravo@gmail.com", "4ezahuin9");
        vk.openMessages();
        Thread.sleep(3000);
    }
}
