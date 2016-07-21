package Lesson1;

import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class StartWorkingWithSelenium extends Browser {
    public static void main(String[] args) throws InterruptedException {

        startFirefox();
        setImpWait(30, TimeUnit.SECONDS);
        String url = "https://google.com/";
        By searchButton = By.name("btnG");

        goTo(url);
        driver.findElement(By.id("lst-ib")).clear();
        driver.findElement(By.id("lst-ib")).sendKeys("hello world");
        driver.findElement(searchButton).click();
        driver.findElement(By.xpath("//div[@data-hveid='25']/h3/a")).click();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        String title = driver.getTitle();
//        assert (title.equalsIgnoreCase("hello world - Поиск в Google"));

        if (title.equalsIgnoreCase("Hello, world! — Википедия")) {
            System.out.println("title is ok");
        } else {
            System.out.println("title is not ok");
        }
        System.out.println(title);

        exitFirefox();
    }
}
