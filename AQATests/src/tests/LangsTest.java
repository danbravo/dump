package tests;

import core.BrowserFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.FooterBlock;

public class LangsTest extends BrowserFactory{

    @Test
    public void langTest() {
        FooterBlock footerBlock = new FooterBlock();
        assert footerBlock.getUrl().equals("https://kismia.com/");

        footerBlock.clickEglishLangBtn();
        boolean urlWait = waitForUrlContains("en.", 10);
        Assert.assertTrue(urlWait);
//
//        footerBlock.clickPortugLangBtn();
//        WebDriverWait wait1 = new WebDriverWait(driver, 10);
//        boolean result1 = wait1.until(ExpectedConditions.urlContains("pt.kismia"));
//        Assert.assertTrue(result1);
//
//        footerBlock.clickEspanLangBtn();
//        WebDriverWait wait2 = new WebDriverWait(driver, 10);
//        boolean result2 = wait2.until(ExpectedConditions.urlContains("es.kismia"));
//        Assert.assertTrue(result2);
    }
}
