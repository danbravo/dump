package LessonFiveGame;

public class GameRunner {
    public static void main(String[] args) {
        Game firstGame = new Game(100, 0);
        Player player = new Player("Dan");
        Player bot = new Player("Bot");
        int playerInput = player.makeMove();
        System.out.println(player.getName() + " input is " + playerInput);
        int botInput = bot.makeAutoMove();
        System.out.println(bot.getName() + " input is " + botInput);
        System.out.println("Target digit was " + firstGame.generalDigit);
        firstGame.getResults(playerInput, botInput);
    }
}
