package BanksExchange;

import Lesson1.Browser;
import org.openqa.selenium.By;

public class UkrSib extends Browser{
    static String urkSibLink = "https://my.ukrsibbank.com/ru/personal/operations/currency_exchange/";
    static By usdSellElem = By.xpath("//*[@id='no_tabs_content']/table/tbody/tr[1]/td[4]");
    static By usdBuyElem = By.xpath("//*[@id='no_tabs_content']/table/tbody/tr[1]/td[3]");
    static double usbSell;
    static double usbBuy;

    public static void getUsbExchangeRate() {
        startChrome();
        goTo(urkSibLink);
        String sell = getText(usdSellElem);
        String buy = getText(usdBuyElem);
        sell = sell.replace(",", ".").trim();
        buy = buy.replace(",", ".").trim();
        usbSell = Double.valueOf(sell);
        usbBuy = Double.valueOf(buy);
        exitChrome();
    }
}
