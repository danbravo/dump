package pageObject;

import core.AbstractReg;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookReg extends AbstractReg {

    @Override
    public void openPage() {
        driver.get("https://www.facebook.com");
    }

    @Override
    public void typeName(String name) {
        type(By.xpath("//*[@id='u_0_1']"), name);
    }

    @Override
    public void typeSurname(String surname) {
        type(By.xpath("//*[@id='u_0_3']"), surname);
    }

    @Override
    public void typeEmail(String email) {
        type(By.xpath("//*[@id='u_0_6']"), email);
        type(By.xpath("//*[@id='u_0_9']"), email);
    }

    @Override
    public void typePass(String pass) {
        type(By.xpath("//*[@id='u_0_b']"), pass);
    }

    @Override
    public void chooseBirthDate(int date, int month, int year) {
        click(By.xpath("//*[@id='day']"));
        click(By.xpath("//*[@id='day']/option[@value='"+date+"']"));

        click(By.xpath("//*[@id='month']"));
        click(By.xpath("//*[@id='month']/option[@value='"+month+"']"));

        click(By.xpath("//*[@id='year']"));
        click(By.xpath("//*[@id='year']/option[@value='"+year+"']"));
    }

    @Override
    public void chooseGender(String gender) {
        click(gender.equalsIgnoreCase("male") ? By.xpath("//*[@id='u_0_f']") : By.xpath("//*[@id='u_0_e']"));
    }

    @Override
    public void clickSubmitButton() {
        click(By.xpath("//*[@id='u_0_j']"));
    }

    @Override
    public void verifyRegData() {

    }

    public void reg(String name, String surname, String email, String pass,
                    int date, int month, int year, String gender) {
        openPage();
        typeName(name);
        typeSurname(surname);
        typeEmail(email);
        typePass(pass);
        chooseBirthDate(date, month, year);
        chooseGender(gender);
        clickSubmitButton();
    }

    public void checkEmail(String email) {
        openPage();
        typeEmail(email);
    }
}
