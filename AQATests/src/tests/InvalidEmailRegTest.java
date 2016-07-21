package tests;

import core.BrowserFactory;
import core.DataProvidersClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.FacebookReg;

public class InvalidEmailRegTest extends BrowserFactory{

    @Test(dataProvider = "invalidEmails", dataProviderClass = DataProvidersClass.class)
    public void tryInvalidEmails(String invalidEmail) {
        new FacebookReg().checkEmail(invalidEmail);
        //alertElement check
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='u_0_5']/i[1]")).isDisplayed());
    }

}
