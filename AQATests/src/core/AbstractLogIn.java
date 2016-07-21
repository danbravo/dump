package core;

public abstract class AbstractLogIn extends MethodsFactory{
    public abstract void openPage();
    public abstract void typeEmail(String email);
    public abstract void typePass(String pass);
    public abstract void clickSubmit();
    public abstract void verifyLogIn();

    public void logIn(String email, String pass) {
        openPage();
        typeEmail(email);
        typePass(pass);
        clickSubmit();
        verifyLogIn();
    }
}
