package Kino;

import Lesson1.Browser;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AladinTest extends Browser{

    @BeforeTest
    public void setUp() {
        startChrome();
    }

    @Test
    public void test() {
        AladinMovies alMovies = new AladinMovies();

//        alMovies.clickRandomTime(alMovies.showTime);
        alMovies.clickShowTime(1, 1);
        alMovies.viewSeats();

    }

    @AfterTest
    public void exit() {
        exitChrome();
    }
}
