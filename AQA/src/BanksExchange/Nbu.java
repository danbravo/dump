package BanksExchange;

import Lesson1.Browser;
import org.openqa.selenium.By;

public class Nbu extends Browser{
    static String nbuLink = "http://www.bank.gov.ua/control/uk/curmetal/detail/currency?period=daily";
    static By nbuSellElm = By.xpath("//div[@class='content']/table[4]//tr[7]/td[5]");
    static double nbuSell;

    public static void getNbuExchangeRate() {
        startChrome();
        goTo(nbuLink);
        String sell = getText(nbuSellElm);
        nbuSell = Double.valueOf(sell) / 100;
        exitChrome();
    }
}
