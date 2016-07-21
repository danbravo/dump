package Game2048;

import Lesson1.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestGame extends Browser{
    public static void main(String[] args) {
        startChrome();
        goTo("http://gabrielecirulli.github.io/2048/");
        List<WebElement> tiles = driver.findElements(By.cssSelector("div.tile"));
        int[][] board = new int[5][5]; // need 5 instead of 4 because we are going to use indices 1-4 and not 0-3
        for (WebElement tile : tiles)
        {
            String className = tile.getAttribute("className");
            String regex = "tile tile-(\\d*) tile-position-(\\d)-(\\d) tile-new";
            Matcher matcher = Pattern.compile(regex).matcher(className);
            matcher.matches();
            int x = Integer.parseInt(matcher.group(2));
            int y = Integer.parseInt(matcher.group(3));
            int value = Integer.parseInt(matcher.group(1));
            board[x][y] = value;
        }
        System.out.println(tiles.toString());
    }
}
