package GisWeather;

import Lesson1.Browser;
import org.openqa.selenium.By;

public class Gismeteo extends Browser {
    static String gismeteo = "https://www.gismeteo.ua/";
    static By kievBtn = By.xpath("//*[@id='cities-teaser']//a[@href='/weather-kyiv-4944/']");

    static By night = By.xpath("//tbody[1]/tr[1]/th[1]");
    static By nState = By.xpath("//tbody[1]/tr[1]/td[2]");
    static By nTemp1 = By.xpath("//tbody[1]/tr[1]/td[3]/span[1]");
    static By nTemp2 = By.xpath("//tbody[1]/tr[1]/td[7]/span[1]");

    static By morning = By.xpath("//tbody[1]/tr[2]/th[1]");
    static By mState = By.xpath("//tbody[1]/tr[2]/td[2]");
    static By mTemp1 = By.xpath("//tbody[1]/tr[2]/td[3]/span[1]");
    static By mTemp2 = By.xpath("//tbody[1]/tr[2]/td[7]/span[1]");

    static By day = By.xpath("//tbody[1]/tr[3]/th[1]");
    static By dState = By.xpath("//tbody[1]/tr[3]/td[2]");
    static By dTemp1 = By.xpath("//tbody[1]/tr[3]/td[3]/span[1]");
    static By dTemp2 = By.xpath("//tbody[1]/tr[3]/td[7]/span[1]");

    static By evening = By.xpath("//tbody[1]/tr[4]/th[1]");
    static By eState = By.xpath("//tbody[1]/tr[4]/td[2]");
    static By eTemp1 = By.xpath("//tbody[1]/tr[4]/td[3]/span[1]");
    static By eTemp2 = By.xpath("//tbody[1]/tr[4]/td[7]/span[1]");

    static String nightVal;
    static String nStateVal;
    static String nTemp1Val;
    static String nTemp2Val;

    static String morningVal;
    static String mStateVal;
    static String mTemp1Val;
    static String mTemp2Val;

    static String dayVal;
    static String dStateVal;
    static String dTemp1Val;
    static String dTemp2Val;

    static String eveningVal;
    static String eStateVal;
    static String eTemp1Val;
    static String eTemp2Val;

    public static void main(String[] args) {
        startChrome();
        goTo(gismeteo);
        press(kievBtn);

        nightVal = getText(night);
        nStateVal = getText(nState);
        nTemp1Val = getText(nTemp1);
        nTemp2Val = getText(nTemp2);

        morningVal = getText(morning);
        mStateVal = getText(mState);
        mTemp1Val = getText(mTemp1);
        mTemp2Val = getText(mTemp2);

        dayVal = getText(day);
        dStateVal = getText(dState);
        dTemp1Val = getText(dTemp1);
        dTemp2Val = getText(dTemp2);

        eveningVal = getText(evening);
        eStateVal = getText(eState);
        eTemp1Val = getText(eTemp1);
        eTemp2Val = getText(eTemp2);

        exitChrome();

        System.out.println(nightVal + " - " + nStateVal + ". Температура " + nTemp1Val + " Ощущается " + nTemp2Val);
        System.out.println(morningVal + " - " + mStateVal + ". Температура " + mTemp1Val + " Ощущается " + mTemp2Val);
        System.out.println(dayVal + " - " + dStateVal + ". Температура " + dTemp1Val + " Ощущается " + dTemp2Val);
        System.out.println(eveningVal + " - " + eStateVal + ". Температура " + eTemp1Val + " Ощущается " + eTemp2Val);
    }
}
