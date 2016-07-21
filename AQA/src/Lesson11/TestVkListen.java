package Lesson11;

import Lesson10.BrowserFact;
import Lesson10.VkLogin;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


@Listeners({MyTestListener.class})
public class TestVkListen extends BrowserFact{

    @Test(priority = 1)
    public void loginVk() {
        VkLogin log = new VkLogin();
        log.openPage();
        log.verifyLogo();
    }

    @Test(priority = 2)
    @Parameters({"email", "pass"})
    //если параметр в xml отсутствует - работает @Optional
    public void paramCheck(@Optional("my@email.com")String email, @Optional("qwerty")String pass) {
        System.out.println(email);
        System.out.println(pass);
    }

    @Test(enabled = false)
    public void someBadTest() {
        //will not be run
    }

    @Test(priority = 3, expectedExceptions = NoSuchElementException.class)
    public void testException() {
        throw new NoSuchElementException("No such element!");
    }

    //run 10 times
    @Test(priority = 4, invocationCount = 10)
    public void anotherTest() {
        System.out.println("test #1");
    }

    //зависит от метода bTest(), но выполнится и без него
    @Test(priority = 5, dependsOnMethods = "bTest", alwaysRun = true)
    public void aTest() {}

    @Test(priority = 6)
    public void bTest() {
        Assert.fail(); //force fail test
    }
}
