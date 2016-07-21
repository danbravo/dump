package Game2048;

import Lesson1.Browser;
import org.openqa.selenium.By;

public class GamePlay extends Browser{
    static String gameLink = "http://gabrielecirulli.github.io/2048/";

    static By row1cell1 = By.xpath("//div[@class='grid-container']/div[1]/div[1]");
    static By row1cell2 = By.xpath("//div[@class='grid-container']/div[1]/div[2]");
    static By row1cell3 = By.xpath("//div[@class='grid-container']/div[1]/div[3]");
    static By row1cell4 = By.xpath("//div[@class='grid-container']/div[1]/div[4]");

    static By row2cell1 = By.xpath("//div[@class='grid-container']/div[2]/div[1]");
    static By row2cell2 = By.xpath("//div[@class='grid-container']/div[2]/div[2]");
    static By row2cell3 = By.xpath("//div[@class='grid-container']/div[2]/div[3]");
    static By row2cell4 = By.xpath("//div[@class='grid-container']/div[2]/div[4]");

    static By row3cell1 = By.xpath("//div[@class='grid-container']/div[3]/div[1]");
    static By row3cell2 = By.xpath("//div[@class='grid-container']/div[3]/div[2]");
    static By row3cell3 = By.xpath("//div[@class='grid-container']/div[3]/div[3]");
    static By row3cell4 = By.xpath("//div[@class='grid-container']/div[3]/div[4]");

    static By row4cell1 = By.xpath("//div[@class='grid-container']/div[4]/div[1]");
    static By row4cell2 = By.xpath("//div[@class='grid-container']/div[4]/div[2]");
    static By row4cell3 = By.xpath("//div[@class='grid-container']/div[4]/div[3]");
    static By row4cell4 = By.xpath("//div[@class='grid-container']/div[4]/div[4]");

    static String[][] cells = new String[4][4];

    public static void main(String[] args) {
        startChrome();
        goTo(gameLink);

    }
}
