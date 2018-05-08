package nl.sanderkastelein;

import nl.sanderkastelein.controllers.AddMovieController;
import nl.sanderkastelein.controllers.ListMoviesController;
import nl.sanderkastelein.controllers.StatisticsController;
import nl.sanderkastelein.models.MovieRepository;
import nl.sanderkastelein.views.AddMovieView;
import nl.sanderkastelein.views.ListMoviesView;
import nl.sanderkastelein.views.StatisticsView;

public class Main {

    private MovieRepository movieRepository;

    public static void main(String[] args) {
        (new Main()).run();
    }

    public void run(){

        // MVC Patterns
        MovieRepository movieRepository = new MovieRepository();

        AddMovieView addMovieView = new AddMovieView(movieRepository);
        ListMoviesView listMoviesView = new ListMoviesView(movieRepository);
        StatisticsView statisticsView = new StatisticsView(movieRepository);

        AddMovieController addMovieController = new AddMovieController(movieRepository, addMovieView);
        ListMoviesController listMoviesController = new ListMoviesController(movieRepository, listMoviesView);
        StatisticsController statisticsController = new StatisticsController(movieRepository, statisticsView);
    }

}
