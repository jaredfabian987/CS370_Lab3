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
        setTitle("Lab 3: Random Bar Chart");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout (new BorderLayout());

        // create a custom panel and add it to the center
        DrawingPanel dp = new DrawingPanel();
        add (dp, BorderLayout.CENTER);

        // create a new grid
        Grid g  = new Grid ();
        add (g, BorderLayout.CENTER);

        // create the redraw button
        // this places the button on the bottom
        JButton redrawButton = new JButton("Redraw");
        add (redrawButton, BorderLayout.SOUTH);


        // Set the window size
        setSize( 600, 700);

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
        // graphics is a java.awt class for drawing operations and Graphics 2D
        // is an even more advance class also from java.awt
        // case to graphics 25 to better drawing
        Graphics2D g2d = (Graphics2D) gfx;


    }
}

class Grid extends JPanel {
    // declare a constant for the size of the grid
    private static final int SIZE = 10;

    public Grid () {
        setBackground(Color.GRAY);
    }


    public void paintComponent (Graphics gfx) {
        super.paintComponent(gfx);

        Graphics2D g2d = (Graphics2D) gfx;

        // we need to get the dimensions of the panel
        int width = 600;
        int height = 700;

        // and then we also have to calculate the sizes of each cell
        int cellW = width / SIZE;
        int cellH = height / SIZE;

        // we also need to draw the lines going vertically

        g2d.setColor (Color.WHITE);
        for (int v = 0; v <= SIZE; v ++){
            int x = v *  cellW;
            g2d.drawLine (x,0,x, height);
        }

        // we  also need to draw the lines going veritcally
        for (int h = 0; h <= SIZE; h ++){
            int y = h *  cellH;
            g2d.drawLine (0, y, width, y);
        }

    }
}