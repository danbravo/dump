package Kino;

import Lesson1.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AladinMovies extends Browser {
    static String page;
    List<String> showTime;

    public AladinMovies() {
        showTime = new ArrayList<>();
        page = "http://liniakino.com/showtimes/aladdin/";
        goTo(page);
    }

    //for 5th block aka "18 мая"
    public void clickRandomTime(List<String> list) {
        List<WebElement> days = driver.findElements(By.xpath("//li//a[contains(text(), 'Протистояння')]/../../div[2]/div"));
        for (int i=1; i<days.size(); i++) {
            list.add("//li//a[contains(text(), 'Протистояння')]/../..//label[contains(text(), '18 травня')]/following-sibling::*//li["+i+"]/a");
        }
        Collections.shuffle(list);
        press(By.xpath(list.get(0)));
    }

    public void clickShowTime(int day, int show) {
        String path = "//li//a[contains(text(), 'Протистояння')]/../../div[2]/div["+day+"]//li["+show+"]/a";
        try {
            press(By.xpath(path));
        } catch (NoSuchElementException e) {
            System.out.println("No such day("+day+") or show("+show+")");
            throw e;
        }
    }

    public void viewSeats() {
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));

        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mobapp-anchor>a")));

        List<WebElement> seats = driver.findElements(By.cssSelector("#hall-scheme-container>div>div"));
        for (WebElement s : seats) {
            if (s.getText().equals("1")) {
                System.out.print("\n" + "| " + s.getText() + " |");
            } else {
                if (s.getAttribute("class").equals("seat seat-color1") ||
                        s.getAttribute("class").equals("seat seat-color1 seat-hover")) {
                    System.out.print(" " + s.getText() + " |");
                } else {
                    System.out.print(" " + s.getText() + "*" + "|");
                }
            }
        }
        System.out.println("\nOccupied seats are the ones with *");
    }

    public String countSeats() {
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));

        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mobapp-anchor>a")));
        List<WebElement> seats = driver.findElements(By.cssSelector("#hall-scheme-container>div>div"));
        int sizeFree = driver.findElements(By.xpath("//div[@class='seat seat-color1']")).size();
        int sizeOccupied = driver.findElements(By.xpath("//div[@class='seat seat-occupied']")).size();
        return "Number of free seats: " + sizeFree +
                "\n" + "Number of occupied seats: " + sizeOccupied;
    }
}
