package Imdb;

import Lesson1.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends Browser {
    static String mainPageLink = "http://www.imdb.com/";
    static By moviesDropDownBtn = By.xpath("//*[@id='navWatchlistMenu']/p");

    public MainPage() {
        goTo(mainPageLink);
    }

    public void openTopMoviesPage() {
        press(moviesDropDownBtn);
        WebElement dynamicElement = new WebDriverWait(driver, 6)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='explore-more']/div[1]/a[1]")));
        dynamicElement.click();
    }
}
