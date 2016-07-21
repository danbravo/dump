package pageObject;

import core.MethodsFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImdbMainPage extends MethodsFactory{
    String mainPageLink = "http://www.imdb.com/";
    By moviesDropDownBtn = By.xpath("//*[@id='navWatchlistMenu']/p");

    public ImdbMainPage() {
        driver.get(mainPageLink);
    }

    public void openTopMoviesPage() {
        click(moviesDropDownBtn);
        WebElement dynamicElement = new WebDriverWait(driver, 6)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='explore-more']/div[1]/a[1]")));
        dynamicElement.click();
    }
}
