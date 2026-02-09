import javax.swing.*;
import java.awt.*;

// works cited/references
// yt video : https://www.youtube.com/watch?v=Kmgo00avvEw
public class RandomBarChart extends JFrame {

    public RandomBarChart () {
        // Set the window title
        setTitle("Random BarChart");

        // What happens when user clicks the X button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // use the border layout method to create aborder
        // divides the window into 5 regions being : s,w,n,e,c
        setLayout (new BorderLayout());

        // create the redraw button
        JButton redrawButton = new JButton("Redraw");
        // this places the button on the bottom
        add (redrawButton, BorderLayout.SOUTH);
        // Set the window size (width, height)
        setSize(450, 550);

        // Center the window on screen
        setLocationRelativeTo(null);

        // Make the window visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new RandomBarChart();
    }
}