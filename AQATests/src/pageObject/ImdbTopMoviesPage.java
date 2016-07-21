package pageObject;

import core.MethodsFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImdbTopMoviesPage extends MethodsFactory{
    String topMoviesPageLink = "http://www.imdb.com/chart/top?ref_=nv_wl_img_3";
    static List<WebElement> moviesList;
    List<String> movieTitles;
    List<String> movieRates;

    By searchKinopoisk = By.xpath("//*[@id='search_input']");
    List<String> kinopoiskMovies;

    public ImdbTopMoviesPage() {
        driver.get(topMoviesPageLink);
    }

    public void getTopMovies() {
        new WebDriverWait(driver, 6)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@class='lister-list']/tr")));
        moviesList = driver.findElements(By.xpath("//tbody[@class='lister-list']/tr"));
    }

    public void getMovieTitlesRates() {
        driver.get(topMoviesPageLink);
        movieTitles = new ArrayList<>();
        movieRates = new ArrayList<>();
        for (int i=1; i<251; i++) {
            movieTitles.add(driver.findElement(By.xpath("//tbody[@class='lister-list']/tr["+i+"]/td[2]/a")).getText());
            movieRates.add(driver.findElement(By.xpath("//tbody[@class='lister-list']/tr["+i+"]/td[3]/strong")).getText());
        }
    }

    public void getKinopoiskMovies() {
        driver.get("http://www.kinopoisk.ru/");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(searchKinopoisk));
        kinopoiskMovies = new ArrayList<>();
        for (int i=0; i<250; i++) {
            type(searchKinopoisk, movieTitles.get(i));
            click(By.xpath("//*[@id='top_form']/input[3]"));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='search_results_top']")));

            if (driver.findElements(By.xpath("//*[@class='element most_wanted']/div/div")).size() != 0) {
                kinopoiskMovies.add(driver.findElement(By.xpath("//*[@class='element most_wanted']/div/div")).getText());
            } else {
                kinopoiskMovies.add("Movie "+movieTitles.get(i)+" not found");
            }
        }
    }

    public void compareImdbKinopoiskRates() {
        getMovieTitlesRates();
        getKinopoiskMovies();
        List<String> compareList = new ArrayList<>();
        for (int i=1; i<4; i++) {
            compareList.add(movieTitles.get(i) + ": IMDB " + movieRates.get(i) + " / kinopoisk " + kinopoiskMovies.get(i));
        }
        Collections.sort(compareList);
        for (String s : compareList) {
            System.out.println(s);
        }
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
