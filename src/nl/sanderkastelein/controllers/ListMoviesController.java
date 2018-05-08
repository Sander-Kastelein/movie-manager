package nl.sanderkastelein.controllers;

import nl.sanderkastelein.models.Movie;
import nl.sanderkastelein.models.MovieRepository;
import nl.sanderkastelein.observers.MovieRepositoryObserverInterface;
import nl.sanderkastelein.views.ListMoviesView;

public class ListMoviesController implements MovieRepositoryObserverInterface {


    private final MovieRepository movieRepository;
    private final ListMoviesView listMoviesView;

    public ListMoviesController(MovieRepository movieRepository, ListMoviesView listMoviesView){
        this.movieRepository = movieRepository;
        movieRepository.attach(this);

        this.listMoviesView = listMoviesView;
    }

    @Override
    public void update() {
        this.listMoviesView.movieList.removeAllItems();

        for(Movie m : this.movieRepository.getMovies()){
            this.listMoviesView.movieList.addItem(m.toString());
        }
    }
}
