package nl.sanderkastelein.views;

import javax.swing.*;
import java.awt.*;

public class AbstractView extends JFrame {

    public AbstractView()
    {
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setPreferredSize(new Dimension(400, 300));
        pack();
    }


}
