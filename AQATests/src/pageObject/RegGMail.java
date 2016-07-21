package pageObject;

import core.AbstractReg;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegGMail extends AbstractReg{
    @Override
    public void openPage() {
        driver.get("https://accounts.google.com/SignUp");
    }

    @Override
    public void typeName(String name) {
        type(By.xpath("//*[@id='FirstName']"), name);
    }

    @Override
    public void typeSurname(String surname) {
        type(By.xpath("//*[@id='LastName']"), surname);
    }

    @Override
    public void typeEmail(String email) {
        type(By.xpath("//*[@id='GmailAddress']"), email);
    }

    @Override
    public void typePass(String pass) {
        type(By.xpath("//*[@id='Passwd']"), pass);
        type(By.xpath("//*[@id='PasswdAgain']"), pass);
    }

    @Override
    public void chooseBirthDate(int date, int month, int year) {
        type(By.xpath("//*[@id='BirthDay']"), date);

        click(By.xpath("//*[@id='BirthMonth']/div[1]"));
        click(By.xpath("//*[@id='BirthMonth']/div[2]/div["+month+"]"));

        type(By.xpath("//*[@id='BirthYear']"), year);
    }

    @Override
    public void chooseGender(String gender) {
        click(By.xpath("//*[@id='Gender']/div[1]"));
        click(gender.equalsIgnoreCase("female") ? By.xpath("//*[@id='Gender']/div[2]/div[1]") :
                (gender.equalsIgnoreCase("male") ? By.xpath("//*[@id='Gender']/div[2]/div[2]") : By.xpath("//*[@id='Gender']/div[2]/div[3]")));
    }

    @Override
    public void clickSubmitButton() {
        click(By.xpath("//*[@id='SkipCaptcha']"));//captcha skip
        click(By.xpath("//*[@id='TermsOfService']"));//terms of service
        click(By.xpath("//*[@id='submitbutton']"));

    }

    @Override
    public void verifyRegData() {
        clickSubmitButton();
        new WebDriverWait(driver, 3).until(ExpectedConditions.urlContains("UserSignUpIdvChallenge"));
    }
}
