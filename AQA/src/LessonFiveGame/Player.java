package LessonFiveGame;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Player {
    String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int makeMove() {
        final Scanner sc = new Scanner(System.in);
        boolean playing = true;
        int finalDigit = 0;
        while (playing) {
            System.out.println("Choose a digit in 0..100 range: ");
            final int input = sc.nextInt();
            try {
                if (input<0 || input>100) {
                    System.out.println("Invalid input!\nMust be >0 and <100");
                } else if (input>=0 || input <=100) {
                    finalDigit = input;
                    playing = false;
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
            }

        }
        return finalDigit;
    }

    public int makeAutoMove() {
        return new Random().nextInt(100 + 1);
    }
}
