package exceptions;

public class InvalidIdException extends Exception{
    private int input;

    public InvalidIdException(final int input) {
        this.input = input;
    }

    public int getInput() {
        return input;
    }
}
