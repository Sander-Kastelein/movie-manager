package nl.sanderkastelein.controllers;

import nl.sanderkastelein.models.Movie;
import nl.sanderkastelein.models.MovieRepository;
import nl.sanderkastelein.observers.MovieRepositoryObserverInterface;
import nl.sanderkastelein.views.StatisticsView;

import java.util.Map;
import java.util.stream.Collectors;

public class StatisticsController implements MovieRepositoryObserverInterface {

    private final MovieRepository movieRepository;
    private final StatisticsView statisticsView;

    public StatisticsController(MovieRepository movieRepository, StatisticsView statisticsView){
        this.movieRepository = movieRepository;
        movieRepository.attach(this);

        this.statisticsView = statisticsView;
    }

    @Override
    public void update() {
        Map<String, Long> chartData = movieRepository.getMovies().stream().collect(Collectors.groupingBy(Movie::getCountryOfOrigin, Collectors.counting()));
        this.statisticsView.chart.setData(chartData);
        this.statisticsView.repaint();
    }
}
