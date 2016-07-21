package exceptions;

public class InvalidPhoneNumberException extends Exception{
    private String input;

    public InvalidPhoneNumberException(final String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }
}
