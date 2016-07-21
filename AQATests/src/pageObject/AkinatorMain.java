package pageObject;

import core.MethodsFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Scanner;

public class AkinatorMain extends MethodsFactory{
    String akinatorLink = "http://ru.akinator.com/";
    By playGameBtn = By.xpath("//a[@class='rouge']");

    By questionMain = By.xpath("//div[@id='bulle-inner']");
    By infoQuestion = By.xpath("//*[@id='infos-area-title']/h2");
    By ageQuestion = By.xpath("//*[@id='infos-area-content']/p/label");
    By ageInputField = By.xpath("//*[@id='elokence_sitebundle_identification_age']");
    By playBtn = By.xpath("//*[@id='infos-area-footer']/input");

    By questionNum = By.xpath(".//*[@id='questionNo']");
    By answerOne = By.xpath("//*[@id='reponse1']");
    By answerTwo = By.xpath("//*[@id='reponse2']");
    By answerThree = By.xpath("//*[@id='reponse3']");
    By answerFour = By.xpath("//*[@id='reponse4']");
    By answerFive = By.xpath("//*[@id='reponse5']");

    public AkinatorMain() {
        driver.get(akinatorLink);
    }

    public void play() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(playGameBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(questionMain));
        System.out.println(driver.findElement(questionMain).getText().replace(" ,", ","));
        System.out.println(driver.findElement(infoQuestion).getText());
        System.out.println(driver.findElement(ageQuestion).getText());

        Scanner scInt = new Scanner(System.in);
        int age = scInt.nextInt();

        type(ageInputField, age);
        click(playBtn);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menu']")));
        boolean gameIn = true;
        while (gameIn) {
            //question
            wait.until(ExpectedConditions.elementToBeClickable(questionNum));
            System.out.println(driver.findElement(questionNum).getText());
            System.out.println(driver.findElement(questionMain).getText());

            //answers
            System.out.println(driver.findElement(answerOne).getText() + ": 1\t"
                    + driver.findElement(answerTwo).getText() + ": 2\t"
                    + driver.findElement(answerThree).getText() + ": 3\t"
                    + driver.findElement(answerFour).getText() + ": 4\t"
                    + driver.findElement(answerFive).getText() + ": 5");

            switch (scInt.nextInt()) {
                case 1: click(answerOne); break;
                case 2: click(answerTwo); break;
                case 3: click(answerThree); break;
                case 4: click(answerFour); break;
                case 5: click(answerFive); break;
            }

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menu']")));

            //условие, если акинатор дал возможный вариант ответа
            if (waitForUrlContains("propose", 2)) {
                System.out.println(driver.findElement(By.xpath("//*[@id='infos-perso-title']/p")).getText() + "\n" +
                        driver.findElement(By.xpath("//*[@id='perso']")).getText() + "\n" +
                        driver.findElement(By.xpath("//*[@id='description']")).getText());

                System.out.println(driver.findElement(By.xpath("//*[@id='yesLink']")).getText() + ": 1\t"
                        + driver.findElement(By.xpath("//*[@id='noLink']")).getText() + ": 2");

                //кнопки Да Нет соответственно
                click(scInt.nextInt()==1 ? By.xpath("//*[@id='yesLink']") : By.xpath("//*[@id='noLink']"));

                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menu']")));
                //условие, если акинатор угадал, выход из игры
                if (driver.getCurrentUrl().contains("valide")) {
                    System.out.println(driver.findElement(questionMain).getText());
                    gameIn = false;
                }
                //условие, если акинатор не угадал. продолжить игру?
                if (driver.findElements(By.xpath("//h2[contains(text(), '?')]")).size() > 0) {
                    System.out.println(driver.findElement(By.xpath("//h2[contains(text(), '?')]")).getText());
                    System.out.println(driver.findElement(By.xpath("//*[@id='yesLink']")).getText() + ": 1\t"
                            + driver.findElement(By.xpath("//*[@id='noLink']")).getText() + ": 2");

                    click(scInt.nextInt()==1 ? By.xpath("//*[@id='yesLink']") : By.xpath("//*[@id='noLink']"));
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menu']")));
                    //условие, если не хотим продолжать игру
                    if ((driver.findElements(By.xpath("//*[@id='notinthelist']")).size() > 0) ||
                            (driver.findElements(By.xpath("//*[@id='searchbutton']")).size() > 0)) {
                        gameIn = false;
                    }
                }
            }
        }
    }

}
