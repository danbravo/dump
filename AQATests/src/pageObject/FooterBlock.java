package pageObject;

import core.MethodsFactory;
import org.openqa.selenium.By;

public class FooterBlock extends MethodsFactory {
    String mainPage = "https://kismia.com/";
    By aboutProjectBtn = By.xpath("//a[@href='/info/about']");
    By supportBtn = By.xpath("//a[@href='/support']");
    By tipsBtn = By.xpath("//a[@href='/info/tips']");
    By storiesBtn = By.xpath("//a[@href='/info/stories']");
    By contactsBtn = By.xpath("//a[@href='/info/contacts']");
    By termsBtn = By.xpath("//a[@href='/info/mterms']");
    By privacyBtn = By.xpath("//a[@href='/info/privacy']");
    By partnersBtn = By.xpath("//a[@href='/info/partners']");

    By russianLangBtn = By.xpath("//ul[@class='languages']/li[1]/a");
    By englishLangBtn = By.xpath("//ul[@class='languages']/li[2]/a");
    By portugLangBtn = By.xpath("//ul[@class='languages']/li[3]/a");
    By espanLangBtn = By.xpath("//ul[@class='languages']/li[4]/a");

    public FooterBlock() {
        driver.get(mainPage);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void clickAboutBtn() {
        driver.findElement(aboutProjectBtn).click();
    }

    public void clickSupportBtn() {
        driver.findElement(supportBtn).click();
    }

    public void clickTipsBtn() {
        driver.findElement(tipsBtn).click();
    }

    public void clickStoriesBtn() {
        driver.findElement(storiesBtn).click();
    }

    public void clickContactsBtn() {
        driver.findElement(contactsBtn).click();
    }

    public void clickTermsBtn() {
        driver.findElement(termsBtn).click();
    }

    public void clickPrivacyBtn() {
        driver.findElement(privacyBtn).click();
    }

    public void clickPartnersBtn() {
        driver.findElement(partnersBtn).click();
    }



    public void clickRussianLangBtn() {
        driver.findElement(russianLangBtn).click();
    }
    public void clickEglishLangBtn() {
        driver.findElement(englishLangBtn).click();
    }
    public void clickPortugLangBtn() {
        driver.findElement(portugLangBtn).click();
    }
    public void clickEspanLangBtn() {
        driver.findElement(espanLangBtn).click();
    }
}
