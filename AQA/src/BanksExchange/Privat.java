package BanksExchange;

import Lesson1.Browser;
import org.openqa.selenium.By;

import java.util.Arrays;

public class Privat extends Browser {
    static String privatLink = "https://www.privat24.ua";
    static By pUsdElm = By.xpath("//header/div[1]/div[1]/div[2]");
    static double pSell;
    static double pBuy;
    static String[] pUsdValues;

    public static void getPrivatExchangeRate() {
        startChrome();
        goTo(privatLink);
        String usd = getText(pUsdElm);
        System.out.println(usd); //вывод текста элемента
        pUsdValues = usd.split("/");
        System.out.println(pUsdValues[0]);
        pBuy = Double.valueOf(pUsdValues[0].trim());
        pSell = Double.valueOf(pUsdValues[1].trim());
        System.out.println(pUsdValues[0]);
        exitChrome();
    }

    public static void getPrivatExchangeSource() {
        startChrome();
        goTo(privatLink);
        String source = driver.getPageSource();
        int begin = source.indexOf("ДОЛ:  </div> <div class=\"section-content rate\">  ") + "ДОЛ:  </div> <div class=\"section-content rate\">  ".length();
        int end = source.indexOf("  </div> </div>");

        pUsdValues = source.substring(begin, end).split("/");
//        System.out.println(pUsdValues[0]);
//        System.out.println(pUsdValues[1]);
        char lastChar0 = pUsdValues[0].charAt(pUsdValues[0].length()-1);
        char firstChar1 = pUsdValues[1].charAt(0);
        pBuy = Double.parseDouble(pUsdValues[0].replace(String.valueOf(lastChar0), ""));
        pSell = Double.parseDouble(pUsdValues[1].replace(String.valueOf(firstChar1), ""));
//        System.out.println(pBuy);
//        System.out.println(pSell);
        exitChrome();
    }

    public static void main(String[] args) {
        getPrivatExchangeSource();
    }
}
