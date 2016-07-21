package pageObject;

import core.AbstractReg;
import org.openqa.selenium.By;
import org.testng.Assert;

public class RegMailRu extends AbstractReg {

    @Override
    public void openPage() {
        driver.get("https://e.mail.ru/signup");
    }

    @Override
    public void typeName(String name) {
        type(By.xpath("//form/div[2]/span[1]/input"), name);
    }

    @Override
    public void typeSurname(String surname) {
        type(By.xpath("//form/div[3]/span[1]/input"), surname);
    }

    @Override
    public void typeEmail(String email) {
        type(By.xpath("//form/div[7]/span[1]/input"), email);
    }

    @Override
    public void chooseBirthDate(int date, int month, int year) {
        click(By.xpath("//*[@id='registrationForm']/div[4]//select[1]"));
        click(By.xpath("//*[@id='registrationForm']/div[4]//select[1]/option[@value='"+date+"']"));

        click(By.xpath("//*[@id='registrationForm']/div[4]//select[2]"));
        click(By.xpath("//*[@id='registrationForm']/div[4]//select[2]/option[@value='"+month+"']"));

        click(By.xpath("//*[@id='registrationForm']/div[4]//select[3]"));
        click(By.xpath("//*[@id='registrationForm']/div[4]//select[3]/option[@value='"+year+"']"));
    }

    @Override
    public void chooseGender(String gender) {
        click(gender.equalsIgnoreCase("male") ? By.xpath("//*[@id='man1']") : By.xpath("//*[@id='man2']"));
    }

    @Override
    public void typePass(String pass) {
        type(By.xpath("//form/div[8]/span[1]/input"), pass);
        type(By.xpath("//form/div[9]/span[1]/input"), pass);
    }

    @Override
    public void verifyRegData() {
        clickSubmitButton();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='MailRuConfirm']/div/a")).isDisplayed());
        //span[@class='error']/span[string-length(text())>0]
    }

    @Override
    public void clickSubmitButton() {
        click(By.xpath("//*[@id='registrationForm']/div[15]//button"));
    }
}
