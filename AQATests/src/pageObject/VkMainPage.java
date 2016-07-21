package pageObject;

import core.MethodsFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VkMainPage extends MethodsFactory{
    String VkLink = "http://vk.com/";
    By logField = By.cssSelector("input#quick_email.text");
    By passField = By.cssSelector("input#quick_pass.text");
    By logInBtn = By.cssSelector("button#quick_login_button");

    By friendsBtn = By.xpath("//*[@id='l_fr']//span/span[2]");
    By allFriendsBtn = By.xpath("//*[@id='tab_all']/a");
    By birthdaysBtn = By.xpath("//a[@id='section_birthdays']");

    By conversations = By.xpath("//div[@id='im_dialogs']//table");

    public VkMainPage() {
        driver.get(VkLink);
    }

    public void logIn(String login, String pass) {
        type(logField, login);
        type(passField, pass);
        click(logInBtn);
    }

    public void openMessages() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='l_msg']/a"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@id='im_more_dialogs']"))));

        WebElement showMoreConvBtn = driver.findElement(By.xpath("//a[@id='im_more_dialogs']"));//кнопка скролла по диалогам
        Actions action  = new Actions(driver);
        while (showMoreConvBtn.isDisplayed()) {
            action.moveToElement(showMoreConvBtn).build().perform();
        }

        List<WebElement> dialogs = driver.findElements(conversations);//список диалогов
        for (WebElement e : dialogs) {
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", e);
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='im_send']"))));

//            WebElement showMoreMsgsBtn = driver.findElement(By.xpath("//div[@id='im_rows']/div[6]/a[1]"));//кнопка скролла по сообщениям
            JavascriptExecutor jse = ((JavascriptExecutor) driver);
            int curStep = 1, prevStep = 0;
            List<WebElement> messages = new ArrayList<>();
            String com = String.format("window.scroll(0, %s)", 0);
            while (curStep != prevStep) {
                prevStep = curStep;
                Thread.sleep(500);
                jse.executeScript(com);
                messages = driver.findElements(By.xpath("//tr[contains(@id,'mess')]//*[@class='im_log_body']//*[@class='im_msg_text']"));
                curStep = messages.size();
            }
            for (WebElement msg : messages) {
                System.out.print(msg.getText() + "|||");
            }
            System.out.println("\nNumber of messages is: " + messages.size());
        }

    }

    public static String genRandomWish() {
        String[] wishes = {"Celebrate your birthday today. Celebrate being Happy every day!",
                "May your birthday and every day be filled with the warmth of sunshine, the happiness of smiles, the sounds of laughter, the feeling of love and the sharing of good cheer!",
                "Happy birthday! Enjoy this year and use it as a launchpad for your future!",
                "You are special and I hope that you float through the day with a big smile on your face. Happy Birthday!",
                "Take a day off to celebrate you birthday. Take a year off and tell people you are younger. Happy Birthday.",
                "Set the world on fire with your dreams and use the flame to light a birthday candle. HAPPY BIRTHDAY!!",
                "Thinking of you on your birthday, and wishing you all the best! I hope it is as fantastic as you are, you deserve the best and nothing less.",
                "Some people get wiser with age. Some people get richer with age. But everybody gets older with age. So good luck on the other two & Happy Birthday!",
                "Your birthday should be a national holiday. I need a day off. Happy Birthday!"};
        Random random = new Random();
        return wishes[random.nextInt(wishes.length+1)];
    }

    public void openCal() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(friendsBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(allFriendsBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(birthdaysBtn)).click();
    }

    public void sendBdayMsg() {
        openCal();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        if (!driver.findElement(By.xpath("//div[@class='bd_recent_birthdays']")).isDisplayed()) {
            System.out.println("No birthdays today");
            return;
        }
        List<WebElement> bdays = driver.findElements(By.xpath("//div[@class='bd_recent_birthdays']/div"));
        if (bdays.size()==0) {
            System.out.println("No birthdays today!");
        } else {
            for (WebElement e : bdays) {
                String bWish = "Dear " + e.findElement(By.xpath(".//div[2]/a")).getText() + "!\n" + genRandomWish();
                e.findElement(By.xpath("./div[3]/a[1]")).click();
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='mail_box_send']")));
                type(By.xpath("//*[@id='mail_box_editable']"), bWish);
//            click(By.xpath("//*[@id='mail_box_send']"));
                click(By.xpath("//*[@id='mail_box_topic_wrap']/a"));
            }
        }
    }
}
