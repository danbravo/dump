package tests;

import core.BrowserFactory;
import org.testng.annotations.Test;
import pageObject.ImdbTopMoviesPage;

public class ImdbTopMoviesTest extends BrowserFactory{

    @Test
    public void viewTopMovies() {
        ImdbTopMoviesPage movies = new ImdbTopMoviesPage();
        movies.getTopMovies();
        movies.showMovies();
        movies.showOldestMovie();
        movies.showNewestMovies();
    }

    @Test
    public void compareImdbKinopoiskMovies() {
        ImdbTopMoviesPage movies = new ImdbTopMoviesPage();
        movies.compareImdbKinopoiskRates();
    }
}
