package core;

public abstract class AbstractReg extends MethodsFactory{
    public abstract void openPage();
    public abstract void typeName(String name);
    public abstract void typeSurname(String surname);
    public abstract void typeEmail(String email);
    public abstract void typePass(String pass);
    public abstract void chooseBirthDate(int date, int month, int year);
    public abstract void chooseGender(String gender);
    public abstract void clickSubmitButton();
    public abstract void verifyRegData();

    public void reg(String name, String surname, String email, String pass,
                    int date, int month, int year, String gender) {
        openPage();
        typeName(name);
        typeSurname(surname);
        typeEmail(email);
        typePass(pass);
        chooseBirthDate(date, month, year);
        chooseGender(gender);
        verifyRegData();
    }
}
