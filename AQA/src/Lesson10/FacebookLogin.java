package Lesson10;

public class FacebookLogin extends AbstractLogin{

    @Override
    public void openPage() {
        driver.get("https://www.facebook.com/");
    }

    @Override
    public void typeLogin(String login) {

    }

    @Override
    public void typePassword(String pass) {

    }

    @Override
    public void clickSubmit() {

    }

}
