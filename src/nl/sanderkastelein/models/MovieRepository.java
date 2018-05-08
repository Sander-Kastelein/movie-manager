package nl.sanderkastelein.models;

import nl.sanderkastelein.observers.ObserverInterface;

import java.util.ArrayList;
import java.util.List;

/** Data Access Object Pattern **/
 public class MovieRepository{

    private List<Movie> movies;
    private List<ObserverInterface<MovieRepository>> observers;


    public MovieRepository()
    {
        movies = new ArrayList<Movie>();
        observers = new ArrayList<ObserverInterface<MovieRepository>>();
    }

    public void add(Movie movie) {
        this.movies.add(movie);
        notifyAllObservers();
    }

    public void remove(Movie movie){
        movies.remove(movie);
        notifyAllObservers();
    }

    public List<Movie> getMovies(){
        return movies;
    }

    public void attach(ObserverInterface<MovieRepository> observer){
        observers.add(observer);
    }

    private void notifyAllObservers(){
        for (ObserverInterface<MovieRepository> observer : observers) {
            observer.update();
        }
    }

    public Movie find(String selectedItem) {
        for(Movie m : this.movies){
            if(m.toString().equals(selectedItem)){
                return m;
            }
        }
        return null;
    }
}
