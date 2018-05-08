package nl.sanderkastelein.views;

import nl.sanderkastelein.models.Movie;
import nl.sanderkastelein.models.MovieRepository;

import javax.swing.*;
import java.awt.*;

public class ListMoviesView extends AbstractView {


    private MovieRepository movieRepository;

    public JComboBox movieList;

    public ListMoviesView(MovieRepository movieRepository)
    {
        this.movieRepository = movieRepository;

        Component label = new Label("Films in DB");
        getContentPane().add(label);
        Dimension size = label.getPreferredSize();
        label.setBounds(10, 10, size.width, size.height);

        movieList = new JComboBox();
        getContentPane().add(movieList);
        movieList.setBounds(10, 40, 370, movieList.getPreferredSize().height);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Point middle = new Point(screenSize.width / 2, screenSize.height / 2);
        Point newLocation = new Point(middle.x - (getWidth() / 2),middle.y - (getHeight() / 2));
        setLocation(newLocation);

        Button submit = new Button("Verwijder film");
        getContentPane().add(submit);

        submit.setBounds(10, 220, 370, submit.getPreferredSize().height);

        /**
         * Lambda
         */
        submit.addActionListener(actionEvent -> {
            Movie selectedMovie = movieRepository.find((String) movieList.getSelectedItem());
            movieRepository.remove(selectedMovie);
        });
    }

}
