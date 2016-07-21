package LessonFiveGame;

import java.util.Random;

public class Game {
    public int generalDigit;

    public Game(int maxVal, int minVal) {
        startGame(maxVal, minVal);
    }

    public void startGame(int max, int min) {
        generalDigit = new Random().nextInt(max - min + 1) + min;
    }

    public void getResults(int input1, int input2) {
        if (Math.abs(generalDigit-input1) < Math.abs(generalDigit-input2)) {
            System.out.println("player with " + input1 + " input wins!");
        } else {
            System.out.println("player with " + input2 + " input wins!");
        }
    }
}
