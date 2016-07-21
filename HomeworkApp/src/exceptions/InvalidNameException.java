package exceptions;

public class InvalidNameException extends Exception{
    private String input;

    public InvalidNameException(final String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }
}
