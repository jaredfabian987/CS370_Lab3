import javax.swing.*;
import java.awt.*;

// works cited/references
// yt video : https://www.youtube.com/watch?v=Kmgo00avvEw
public class Main extends JFrame {

    public Main () {
        // Set the window title

        // What happens when user clicks the X button
        // use the border layout method to create a border
        // divides the window into 5 regions being : s,w,n,e,c
        setTitle("Random BarChart");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout (new BorderLayout());

        // create a custom panel and add it to the center
        DrawingPanel dp = new DrawingPanel();
        add (dp, BorderLayout.CENTER);

        // create the redraw button
        // this places the button on the bottom
        JButton redrawButton = new JButton("Redraw");
        add (redrawButton, BorderLayout.SOUTH);


        // Set the window size
        setSize(450, 550);

        // Center the window on screen
        setLocationRelativeTo(null);

        // Make the window visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}

class DrawingPanel extends JPanel {
    public DrawingPanel () {
        setBackground(Color.GRAY);
    }


    public void paintComponent (Graphics gfx){
        // always call this first
        super.paintComponent(gfx);

        // case to graphics 25 to better drawing
        Graphics2D g2d = (Graphics2D) gfx;


    }
}