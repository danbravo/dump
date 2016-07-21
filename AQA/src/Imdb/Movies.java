package Imdb;

import Lesson1.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class Movies extends Browser{
    private static List<WebElement> moviesList;

    public Movies() {
        new WebDriverWait(driver, 6)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@class='lister-list']/tr")));
        moviesList = driver.findElements(By.xpath("//tbody[@class='lister-list']/tr"));
    }

    public void showMovies() {
        for (WebElement e : moviesList) {
            String name = e.findElement(By.xpath("./td[2]/a")).getText();
            String year = e.findElement(By.xpath("./td[2]/span")).getText();
            String rate = e.findElement(By.xpath("./td[3]/strong")).getText();
            System.out.println(name + "\t" + year + "\t" + rate);
        }
    }

    public void showOldestMovie() {
        int oldestYear = Integer.parseInt(driver.findElement(By.xpath("//tbody[@class='lister-list']/tr[1]/td[2]/span")).getText()
                .replace("(", "").replace(")", ""));
        String oldestName = driver.findElement(By.xpath("//tbody[@class='lister-list']/tr[1]/td[2]/a")).getText();
        for (WebElement e : moviesList) {
            int movY = Integer.parseInt(e.findElement(By.xpath("./td[2]/span")).getText()
                    .replace("(", "").replace(")", ""));
            String movN = e.findElement(By.xpath("./td[2]/a")).getText();
            if (oldestYear > movY) {
                oldestYear = movY;
                oldestName = movN;
            }
        }
        System.out.println("\nOldest movie: " + oldestName + "\t" + oldestYear);
    }

    public void showNewestMovies() {
        int newestYear = Integer.parseInt(driver.findElement(By.xpath("//tbody[@class='lister-list']/tr[1]/td[2]/span")).getText()
                .replace("(", "").replace(")", ""));
        String newestName = driver.findElement(By.xpath("//tbody[@class='lister-list']/tr[1]/td[2]/a")).getText();
        for (WebElement e : moviesList) {
            int movY = Integer.parseInt(e.findElement(By.xpath("./td[2]/span")).getText()
                    .replace("(", "").replace(")", ""));
            String movN = e.findElement(By.xpath("./td[2]/a")).getText();
            if (newestYear < movY) {
                newestYear = movY;
                newestName = movN;
            }
        }
        System.out.println("\nNewest movie: " + newestName + "\t" + newestYear);
    }
}
