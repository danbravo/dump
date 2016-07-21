package pageObject;

import core.MethodsFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FacebookMain extends MethodsFactory{
    String facebookLink = "https://www.facebook.com/";
    By showLangs = By.xpath("//*[@id='pageFooter']//li[12]/a");

    public FacebookMain() {
        driver.get(facebookLink);
    }

    public void clickLangsMenu() {
        click(showLangs);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//body/div[3]/div[2]/div/div/div/div[1]"))));
        Assert.assertTrue(driver.findElements(By.xpath("//body/div[3]/div[2]/div/div/div/div[1]")).size()!=0);
    }

    public void clickEnglishLangBtn() {
        clickLangsMenu();
        driver.findElement(By.xpath("//div[@id='intl-region']/div[1]//a[contains(text(), 'English (UK)')][1]")).click();
        boolean urlWait = waitForUrlContains("en-gb", 10);
        Assert.assertTrue(urlWait);
    }

    public void clickBulgarianLangBtn() {
        clickLangsMenu();
        driver.findElement(By.xpath("//div[@id='intl-region']/div[1]//a[contains(text(), 'Български')][1]")).click();
        boolean urlWait = waitForUrlContains("bg-bg", 10);
        Assert.assertTrue(urlWait);
    }

    public void clickSerbianLangBtn() {
        clickLangsMenu();
        driver.findElement(By.xpath("//div[@id='intl-region']/div[1]//a[contains(text(), 'Српски')][1]")).click();
        boolean urlWait = waitForUrlContains("sr-rs", 10);
        Assert.assertTrue(urlWait);
    }

    public void clickNepalLangBtn() {
        clickLangsMenu();
        driver.findElement(By.xpath("//div[@id='intl-region']/div[1]//a[contains(text(), 'नेपाली')][1]")).click();
        boolean urlWait = waitForUrlContains("ne-np", 10);
        Assert.assertTrue(urlWait);
    }

    public void clickArabianLangBtn() {
        clickLangsMenu();
        driver.findElement(By.xpath("//div[@id='intl-region']/div[1]//a[contains(text(), '\u200Fالعربية\u200F')][1]")).click();
        boolean urlWait = waitForUrlContains("ar-ar", 10);
        Assert.assertTrue(urlWait);
    }

    public void clickEspanolLangBtn() {
        clickLangsMenu();
        driver.findElement(By.xpath("//div[@id='intl-region']/div[1]//a[contains(text(), '\u200EEspañol\u200E')][1]")).click();
        boolean urlWait = waitForUrlContains("es-la", 10);
        Assert.assertTrue(urlWait);
    }

    public void clickNetherLangBtn() {
        clickLangsMenu();
        driver.findElement(By.xpath("//div[@id='intl-region']/div[1]//a[contains(text(), 'Nederlands')][1]")).click();
        boolean urlWait = waitForUrlContains("nl-nl", 10);
        Assert.assertTrue(urlWait);
    }

    public void clickThaiLangBtn() {
        clickLangsMenu();
        driver.findElement(By.xpath("//div[@id='intl-region']/div[1]//a[contains(text(), 'ภาษาไทย')][1]")).click();
        boolean urlWait = waitForUrlContains("th-th", 10);
        Assert.assertTrue(urlWait);
    }

    public void clickKoreanLangBtn() {
        clickLangsMenu();
        driver.findElement(By.xpath("//div[@id='intl-region']/div[1]//a[contains(text(), '한국어')][1]")).click();
        boolean urlWait = waitForUrlContains("ko-kr", 10);
        Assert.assertTrue(urlWait);
    }

    public void clickJapanLangBtn() {
        clickLangsMenu();
        driver.findElement(By.xpath("//div[@id='intl-region']/div[1]//a[contains(text(), '日本語')][1]")).click();
        boolean urlWait = waitForUrlContains("ja-jp", 10);
        Assert.assertTrue(urlWait);
    }

    public void clickDeutschLangBtn() {
        clickLangsMenu();
        driver.findElement(By.xpath("//div[@id='intl-region']/div[1]//a[contains(text(), 'Deutsch')][1]")).click();
        boolean urlWait = waitForUrlContains("de-de", 10);
        Assert.assertTrue(urlWait);
    }

    public void clickItalianoLangBtn() {
        clickLangsMenu();
        driver.findElement(By.xpath("//div[@id='intl-region']/div[1]//a[contains(text(), 'Italiano')][1]")).click();
        boolean urlWait = waitForUrlContains("it-it", 10);
        Assert.assertTrue(urlWait);
    }

    public void clickFilipinoLangBtn() {
        clickLangsMenu();
        driver.findElement(By.xpath("//div[@id='intl-region']/div[1]//a[contains(text(), 'Filipino')][1]")).click();
        boolean urlWait = waitForUrlContains("tl-ph", 10);
        Assert.assertTrue(urlWait);
    }

    public void clickJavaneseLangBtn() {
        clickLangsMenu();
        driver.findElement(By.xpath("//div[@id='intl-region']/div[1]//a[contains(text(), 'Basa Jawa')][1]")).click();
        boolean urlWait = waitForUrlContains("jv-id", 10);
        Assert.assertTrue(urlWait);
    }

    public void clickFrenchLangBtn() {
        clickLangsMenu();
        driver.findElement(By.xpath("//div[@id='intl-region']/div[1]//a[contains(text(), 'Français (France)')][1]")).click();
        boolean urlWait = waitForUrlContains("fr-fr", 10);
        Assert.assertTrue(urlWait);
    }
}
