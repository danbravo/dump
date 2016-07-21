package BanksExchange;

import Lesson1.Browser;
import org.openqa.selenium.By;

public class Oschad extends Browser{
    static String oschadLink = "http://www.oschadbank.ua/ua/";
    static By oschadBuyElm = By.xpath("//strong[@class='buy-USD']");
    static By oschadSellElm = By.xpath("//strong[@class='sell-USD']");
    static double oschadBuy;
    static double oschadSell;

    public static void getOschadExchangeRate() {
        startChrome();
        goTo(oschadLink);
        String sell = getText(oschadSellElm);
        String buy = getText(oschadBuyElm);
        sell = sell.replace(",", ".").trim();
        buy = buy.replace(",", ".").trim();
        oschadSell = Double.valueOf(sell);
        oschadBuy = Double.valueOf(buy);
        exitChrome();
    }
}
