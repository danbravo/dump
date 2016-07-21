package pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public class FooterBlock extends MethodsFactory {
    private By aboutProjectBtn = By.xpath("//a[@href='/info/about']");
    private By supportBtn = By.xpath("//a[@href='/support']");
    private By tipsBtn = By.xpath("//a[@href='/info/tips']");
    private By storiesBtn = By.xpath("//a[@href='/info/stories']");
    private By contactsBtn = By.xpath("//a[@href='/info/contacts']");
    private By privacyBtn = By.xpath("//a[@href='/info/privacy']");
    private By partnersBtn = By.xpath("//a[@href='/info/partners']");

    private By russianLangBtn = By.xpath("//ul[@class='languages']/li[1]/a");
    private By englishLangBtn = By.xpath("//ul[@class='languages']/li[2]/a");
    private By portugLangBtn = By.xpath("//ul[@class='languages']/li[3]/a");
    private By espanLangBtn = By.xpath("//ul[@class='languages']/li[4]/a");
    private By frenchLangBtn = By.xpath("//ul[@class='languages']/li[5]/a");

    @Step("Pressing 'About' Button")
    public void clickAboutBtn() {
        driver.findElement(aboutProjectBtn).click();
        Assert.assertTrue(waitForUrlContains("info/about", 10));
    }

    @Step("Pressing 'Support' Button")
    public void clickSupportBtn() {
        driver.findElement(supportBtn).click();
        Assert.assertTrue(waitForUrlContains("support", 10));
    }

    @Step("Pressing 'Tips' Button")
    public void clickTipsBtn() {
        driver.findElement(tipsBtn).click();
        Assert.assertTrue(waitForUrlContains("info/tips", 10));
    }

    @Step("Pressing 'Stories' Button")
    public void clickStoriesBtn() {
        driver.findElement(storiesBtn).click();
        Assert.assertTrue(waitForUrlContains("info/stories", 10));
    }

    @Step("Pressing 'Contacts' Button")
    public void clickContactsBtn() {
        driver.findElement(contactsBtn).click();
        Assert.assertTrue(waitForUrlContains("info/contacts", 10));
    }

    @Step("Pressing 'Privacy' Button")
    public void clickPrivacyBtn() {
        driver.findElement(privacyBtn).click();
        Assert.assertTrue(waitForUrlContains("info/privacy", 10));
    }

    @Step("Pressing 'Partners' Button")
    public void clickPartnersBtn() {
        driver.findElement(partnersBtn).click();
        Assert.assertTrue(waitForUrlContains("info/partners", 10));
    }

    //lang buttons
    @Step("Pressing 'English Language' Button")
    public void clickEnglishLangBtn() {
        driver.findElement(englishLangBtn).click();
        Assert.assertTrue(waitForUrlContains("en.", 10));
    }

    @Step("Pressing 'Portuguese Language' Button")
    public void clickPortugLangBtn() {
        driver.findElement(portugLangBtn).click();
        Assert.assertTrue(waitForUrlContains("pt.", 10));
    }

    @Step("Pressing 'Espanol Language' Button")
    public void clickEspanLangBtn() {
        driver.findElement(espanLangBtn).click();
        Assert.assertTrue(waitForUrlContains("es.", 10));
    }

    @Step("Pressing 'French Language' Button")
    public void clickFrenchLangBtn() {
        driver.findElement(frenchLangBtn).click();
        Assert.assertTrue(waitForUrlContains("fr.", 10));
    }

    @Step("Pressing 'Russian Language' Button")
    public void clickRussianLangBtn() {
        driver.findElement(russianLangBtn).click();
        Assert.assertTrue(waitForUrlContains("https://kismia.com/", 10));
    }
}
