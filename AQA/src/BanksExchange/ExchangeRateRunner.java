package BanksExchange;

public class ExchangeRateRunner {

    public static String getAverageExchangeRate() {
        Privat.getPrivatExchangeRate();
        UkrSib.getUsbExchangeRate();
        Aval.getAvalExchangeRate();
        Oschad.getOschadExchangeRate();
        Nbu.getNbuExchangeRate();

        double avBuyRates = (Privat.pBuy + UkrSib.usbBuy +
                Aval.avalBuy + Oschad.oschadBuy) / 4;
        double avSellRates = (Privat.pSell + UkrSib.usbSell +
                Aval.avalSell + Oschad.oschadSell + Nbu.nbuSell) / 5;
        String avBRate = "Average buy rate is: " + String.valueOf(avBuyRates);
        String avSRate = "Average sell rate is: " + String.valueOf(avSellRates);
        return avBRate + "\n" + avSRate;
    }

    public static String getMinBuyRate() {
        Privat.getPrivatExchangeRate();
        UkrSib.getUsbExchangeRate();
        Aval.getAvalExchangeRate();
        Oschad.getOschadExchangeRate();

        double[] minUsdBuyRate = new double[4];
        minUsdBuyRate[0] = Privat.pBuy;
        minUsdBuyRate[1] = UkrSib.usbBuy;
        minUsdBuyRate[2] = Aval.avalBuy;
        minUsdBuyRate[3] = Oschad.oschadBuy;

        double min = minUsdBuyRate[0];
        for (int i = 0; i < minUsdBuyRate.length; i++) {
            if (min > minUsdBuyRate[i]) {
                min = minUsdBuyRate[i];
            }
        }

        String lowestBuyRate;
        if (min == Privat.pBuy) {
            lowestBuyRate = "Lowest exchange buy rate is in PrivatBank: " + min;
            return lowestBuyRate;
        } else if (min == UkrSib.usbBuy) {
            lowestBuyRate = "Lowest exchange buy rate is in UkrSibBank: " + min;
            return lowestBuyRate;
        } else if (min == Aval.avalBuy) {
            lowestBuyRate = "Lowest exchange buy rate is in AvalBank: " + min;
            return lowestBuyRate;
        } else {
            lowestBuyRate = "Lowest exchange buy rate is in OschadBank: " + min;
            return lowestBuyRate;
        }
    }

    public static String getMaxSellRate() {
        Privat.getPrivatExchangeRate();
        UkrSib.getUsbExchangeRate();
        Aval.getAvalExchangeRate();
        Oschad.getOschadExchangeRate();
        Nbu.getNbuExchangeRate();

        double[] maxUsdSellRate = new double[5];
        maxUsdSellRate[0] = Privat.pSell;
        maxUsdSellRate[1] = UkrSib.usbSell;
        maxUsdSellRate[2] = Aval.avalSell;
        maxUsdSellRate[3] = Oschad.oschadSell;
        maxUsdSellRate[4] = Nbu.nbuSell;

        double max = maxUsdSellRate[0];
        for (int i = 0; i < maxUsdSellRate.length; i++) {
            if (max < maxUsdSellRate[i]) {
                max = maxUsdSellRate[i];
            }
        }

        String highestSellRate;
        if (max == Privat.pSell) {
            highestSellRate = "Highest exchange sell rate is in PrivatBank: " + max;
            return highestSellRate;
        } else if (max == UkrSib.usbSell) {
            highestSellRate = "Highest exchange sell rate is in UkrSibBank: " + max;
            return highestSellRate;
        } else if (max == Aval.avalSell) {
            highestSellRate = "Highest exchange sell rate is in AvalBank: " + max;
            return highestSellRate;
        } else if (max == Oschad.oschadSell) {
            highestSellRate = "Highest exchange sell rate is in OschadBank: " + max;
            return highestSellRate;
        } else {
            highestSellRate = "Highest exchange sell rate is in NBU: " + max;
            return highestSellRate;
        }
    }

    public static void main(String[] args) {
        String avExRate = getAverageExchangeRate();
        String buyRate = getMinBuyRate();
        String sellRate = getMaxSellRate();
        System.out.println(avExRate + "\n" + buyRate + "\n" + sellRate);
    }
}
