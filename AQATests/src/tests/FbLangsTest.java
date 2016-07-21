package tests;

import core.BrowserFactory;
import org.testng.annotations.Test;
import pageObject.FacebookMain;

public class FbLangsTest extends BrowserFactory{

    @Test
    public void langTest() {
        FacebookMain fb = new FacebookMain();
        fb.clickEnglishLangBtn();
        fb.clickBulgarianLangBtn();
        fb.clickSerbianLangBtn();
        fb.clickNepalLangBtn();
        fb.clickArabianLangBtn();
        fb.clickEspanolLangBtn();
        fb.clickNetherLangBtn();
        fb.clickThaiLangBtn();
        fb.clickKoreanLangBtn();
        fb.clickJapanLangBtn();
        fb.clickDeutschLangBtn();
        fb.clickItalianoLangBtn();
        fb.clickFilipinoLangBtn();
        fb.clickJavaneseLangBtn();
        fb.clickFrenchLangBtn();
    }
}
