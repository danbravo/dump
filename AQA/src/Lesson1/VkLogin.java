package Lesson1;

import org.openqa.selenium.By;

public class VkLogin extends Browser {

    static By emailFld = By.id("quick_email");
    static By passwordFld = By.id("quick_pass");
    static By loginBtn = By.id("quick_login_button");

    public static void main(String[] args) throws InterruptedException {
        startChrome();
        goTo("http://vk.com");
        type(emailFld, "lalal@gmail.com");
        type(passwordFld, "somePASS123");
        press(loginBtn);

        Thread.sleep(2000);

    }
}
