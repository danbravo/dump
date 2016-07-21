package BanksExchange;

import Lesson1.Browser;
import org.openqa.selenium.By;

public class Aval extends Browser{
    static String avalLink = "https://www.aval.ua/ru/personal/everyday/exchange/exchange/";
    static By avalSellElm = By.xpath("//*[@class='body-currency-block-rba']//tr[2]/td[3]");
    static By avalBuyElm = By.xpath("//*[@class='body-currency-block-rba']//tr[2]/td[2]");
    static double avalSell;
    static double avalBuy;

    public static void getAvalExchangeRate() {
        startChrome();
        goTo(avalLink);
        String sell = getText(avalSellElm);
        String buy = getText(avalBuyElm);
        sell = sell.replace(",", ".").trim();
        buy = buy.replace(",", ".").trim();
        avalSell = Double.valueOf(sell);
        avalBuy = Double.valueOf(buy);
        exitChrome();
    }
}
