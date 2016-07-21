package FbAndVk;

import Lesson1.Browser;
import org.openqa.selenium.By;

public class FbLogIn extends Browser {
    private static final String EMAIL = "dan.dudelife.bravo@gmail.com";
    private static final String PASS = "2342925bravo";
    static String FbLink = "https://www.facebook.com/";
    static By emailField = By.xpath("//*[@id='email']");
    static By passField = By.xpath("//*[@id='pass']");
    static By logBtn = By.xpath("//*[@id='loginbutton']");

    public static void logIn() {
        goTo(FbLink);
        type(emailField, EMAIL);
        type(passField, PASS);
        press(logBtn);
    }

    public static void main(String[] args) {
        startChrome();
        logIn();
        exitChrome();
    }
}
