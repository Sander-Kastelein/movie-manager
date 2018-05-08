package nl.sanderkastelein.views;

import nl.sanderkastelein.models.Movie;
import nl.sanderkastelein.models.MovieRepository;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMovieView extends AbstractView {


    private MovieRepository movieRepository;

    public AddMovieView(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
        pack();

        Component label = new Label("Voeg film toe");
        getContentPane().add(label);
        label.setBounds(10, 10, label.getPreferredSize().width, label.getPreferredSize().height);

        Component movieNameLabel = new Label("Film naam");
        getContentPane().add(movieNameLabel);
        movieNameLabel.setBounds(10, 40, movieNameLabel.getPreferredSize().width, movieNameLabel.getPreferredSize().height);

        TextField movieNameField = new TextField();
        getContentPane().add(movieNameField);
        movieNameField.setBounds(90, 40, 290, movieNameField.getPreferredSize().height + 3);


        Component movieReleaseYearLabel = new Label("Film jaar");
        getContentPane().add(movieReleaseYearLabel);
        movieReleaseYearLabel.setBounds(10, 80, movieReleaseYearLabel.getPreferredSize().width, movieReleaseYearLabel.getPreferredSize().height);


        TextField movieReleaseYearField = new TextField();
        getContentPane().add(movieReleaseYearField);
        movieReleaseYearField.setBounds(90, 80, 290, movieReleaseYearField.getPreferredSize().height + 3);

        Component movieCountryOfOriginLabel = new Label("Herkomst");
        getContentPane().add(movieCountryOfOriginLabel);
        movieCountryOfOriginLabel.setBounds(10, 120, movieCountryOfOriginLabel.getPreferredSize().width, movieCountryOfOriginLabel.getPreferredSize().height);


        TextField movieCountryOfOriginField = new TextField();
        getContentPane().add(movieCountryOfOriginField);
        movieCountryOfOriginField.setBounds(90, 120, 290, movieCountryOfOriginField.getPreferredSize().height + 3);

        Component budgetLabel = new Label("Budget");
        getContentPane().add(budgetLabel);
        budgetLabel.setBounds(10, 160, budgetLabel.getPreferredSize().width, budgetLabel.getPreferredSize().height);


        TextField budgetField = new TextField();
        getContentPane().add(budgetField);
        budgetField.setBounds(90, 160, 290, budgetField.getPreferredSize().height + 3);


        Button submit = new Button("Voeg film toe");
        getContentPane().add(submit);

        submit.setBounds(10, 220, 370, submit.getPreferredSize().height);



        /**
         * Lambda
         */
        submit.addActionListener(actionEvent -> {

            Movie newMovie = new Movie(
                    movieNameField.getText(),
                    Integer.parseInt(movieReleaseYearField.getText()),
                    movieCountryOfOriginField.getText(),
                    Double.parseDouble(budgetField.getText())
            );

            movieNameField.setText("");
            movieReleaseYearField.setText("");
            movieCountryOfOriginField.setText("");
            budgetField.setText("");

            movieRepository.add(newMovie);
        });


        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Point middle = new Point(screenSize.width / 2 - 500, screenSize.height / 2);
        Point newLocation = new Point(middle.x - (getWidth() / 2),middle.y - (getHeight() / 2));
        setLocation(newLocation);
}

}
