package Lesson10;

public abstract class AbstractLogin extends MethodsFact{

    public abstract void openPage();
    public abstract void typeLogin(String login);
    public abstract void typePassword(String pass);
    public abstract void clickSubmit();

    public void login(String login, String pass) {
        openPage();
        typeLogin(login);
        typePassword(pass);
        clickSubmit();
    }

}
