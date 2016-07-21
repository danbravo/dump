package tests;

import core.BrowserFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.FooterBlock;

public class FooterTest extends BrowserFactory{

    @Test
    public void aboutBtnTest() {
        FooterBlock footerBlock = new FooterBlock();
        footerBlock.clickAboutBtn();
        Assert.assertTrue(waitForUrlContains("info/about", 10));
    }

    @Test
    public void supportBtnTest() {
        FooterBlock footerBlock = new FooterBlock();
        footerBlock.clickSupportBtn();
        Assert.assertTrue(waitForUrlContains("support", 10));
    }

    @Test
    public void tipsBtnTest() {
        FooterBlock footerBlock = new FooterBlock();
        footerBlock.clickTipsBtn();
        Assert.assertTrue(waitForUrlContains("info/tips", 10));
    }

    @Test
    public void storiesBtnTest() {
        FooterBlock footerBlock = new FooterBlock();
        footerBlock.clickStoriesBtn();
        Assert.assertTrue(waitForUrlContains("info/stories", 10));
    }

    @Test
    public void contactsBtnTest() {
        FooterBlock footerBlock = new FooterBlock();
        footerBlock.clickContactsBtn();
        Assert.assertTrue(waitForUrlContains("info/contacts", 10));
    }

    @Test
    public void termsBtnTest() {
        FooterBlock footerBlock = new FooterBlock();
        footerBlock.clickTermsBtn();
        Assert.assertTrue(waitForUrlContains("info/mterms", 10));
    }

    @Test
    public void privacyBtnTest() {
        FooterBlock footerBlock = new FooterBlock();
        footerBlock.clickPrivacyBtn();
        Assert.assertTrue(waitForUrlContains("info/privacy", 10));
    }

    @Test
    public void partnersBtnTest() {
        FooterBlock footerBlock = new FooterBlock();
        footerBlock.clickPartnersBtn();
        Assert.assertTrue(waitForUrlContains("info/partners", 10));
    }
}
