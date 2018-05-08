package nl.sanderkastelein.controllers;

import nl.sanderkastelein.models.MovieRepository;
import nl.sanderkastelein.views.AddMovieView;

public class AddMovieController {

    private MovieRepository movieRepository;
    private AddMovieView addMovieView;

    public AddMovieController(MovieRepository movieRepository, AddMovieView addMovieView){
        this.movieRepository = movieRepository;
        this.addMovieView = addMovieView;
    }



}
