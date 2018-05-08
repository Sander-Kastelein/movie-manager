package nl.sanderkastelein.views;

import nl.sanderkastelein.models.MovieRepository;
import nl.sanderkastelein.views.util.ChartPanel;

import java.awt.*;

public class StatisticsView extends AbstractView {

    private MovieRepository movieRepository;

    public ChartPanel chart;

    public StatisticsView(MovieRepository movieRepository)
    {
        this.movieRepository = movieRepository;

        Component label = new Label("Films per herkomst");
        getContentPane().add(label);
        Dimension size = label.getPreferredSize();
        label.setBounds(10, 10, size.width, size.height);

        chart = new ChartPanel(
                new double[]{}, new String[]{}
        );

        getContentPane().add(chart);

        chart.setBounds(10, 40, 370, 200);


        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Point middle = new Point(screenSize.width / 2 + 500, screenSize.height / 2);
        Point newLocation = new Point(middle.x - (getWidth() / 2),middle.y - (getHeight() / 2));
        setLocation(newLocation);
    }


}
