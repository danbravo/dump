package Imdb;

import Lesson1.Browser;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ImdbRunner extends Browser {

    @BeforeTest
    public void setUp() {
        startChrome();
    }

    @Test
    public void viewTopMovies() {
        MainPage mainPage = new MainPage();
        mainPage.openTopMoviesPage();
        Movies movies = new Movies();
        movies.showMovies();
        movies.showOldestMovie();
        movies.showNewestMovies();
    }

    @AfterTest
    public void exit() {
        exitChrome();
    }
}
