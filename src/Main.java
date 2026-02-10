import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

// works cited/references
// yt video : https://www.youtube.com/watch?v=Kmgo00avvEw

// This is our main window - it sets up everything the user sees
public class Main extends JFrame {

    public Main () {
        // Name the window
        setTitle("Lab 3: Random Bar Chart");

        // Close the program when the user hits the X button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Use BorderLayout so we can put the chart in the middle
        // and the button at the bottom
        setLayout(new BorderLayout());

        // Create our drawing area and place it in the middle of the window
        DrawingPanel dp = new DrawingPanel();
        add(dp, BorderLayout.CENTER);

        // Create the Redraw button and place it at the bottom
        JButton redrawButton = new JButton("Redraw");

        // When the user clicks the button, call redraw() on our drawing panel
        redrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dp.redraw();
            }
        });
        add(redrawButton, BorderLayout.SOUTH);

        // Set the window size and center it on screen
        setSize(600, 700);
        setLocationRelativeTo(null);

        // Show the window
        setVisible(true);
    }

    // This is where the program starts
    public static void main(String[] args) {
        new Main();
    }
}

// This is our drawing area - it handles the grid and the bars
class DrawingPanel extends JPanel {

    // We want a 10x10 grid, so this never needs to change
    private static final int GRID_SIZE = 10;

    // We use a seed to control what random values get generated
    // Saving the seed means the same bars stay on screen until Redraw is clicked
    private long seed;
    private Random random;

    public DrawingPanel() {
        // Start with a gray background
        setBackground(Color.GRAY);

        // Pick a random starting seed when the app opens
        // making sure that it's random each time
        seed = System.currentTimeMillis();
        random = new Random(seed);
    }

    // Called when the Redraw button is clicked
    // Picks a new seed so we get a fresh set of bars
    public void redraw() {
        seed = System.currentTimeMillis();
        repaint();
    }

    // Java calls this automatically whenever the panel needs to be drawn
    // (on startup, on resize, or when we call repaint())
    @Override
    public void paintComponent(Graphics gfx) {
        // Always do this first to clear the screen before redrawing
        super.paintComponent(gfx);

        // Upgrade our drawing tool so we can control line thickness
        Graphics2D g2d = (Graphics2D) gfx;

        // Reset random with our saved seed so the same bars are drawn every time
        // until the user clicks Redraw
        random = new Random(seed);

        // Get the current size of the panel so the drawing always fits
        int width = 600;
        int height = 700;

        // Figure out how wide and tall each grid cell should be
        int cellWidth = width / GRID_SIZE;
        int cellHeight = height / GRID_SIZE;


        g2d.setColor(Color.WHITE);

        // Draw 11 vertical lines to make 10 columns
        for (int i = 0; i <= GRID_SIZE; i++) {
            g2d.drawLine(i * cellWidth, 0, i * cellWidth, height);
        }

        // Draw 11 horizontal lines to make 10 rows
        for (int i = 0; i <= GRID_SIZE; i++) {
            g2d.drawLine(0, i * cellHeight, width, i * cellHeight);
        }

        // draw the bars

        // Split the panel into 10 equal sections, one for each bar
        int barWidth = width / 10;

        // Make the girth of bars 10 per instructions
        g2d.setStroke(new BasicStroke(10));

        for (int i = 0; i < 10; i++) {
            // Pick a random color by mixing random amounts of Red, Green, and Blue
            Color randomColor = new Color(
                    random.nextInt(256),  // how much red
                    random.nextInt(256),  // how much green
                    random.nextInt(256)   // how much blue
            );
            g2d.setColor(randomColor);

            // Place the bar in the center of its section
            int x = i * barWidth + barWidth / 2;

            // Start the bar near the bottom of the panel
            int y1 = height - 50;

            // determine a random height for the bar
            // I just did -100 so that it doesnt reach the top of the window
            int barHeight = random.nextInt(height - 100);
            int y2 = y1 - barHeight;

            // Draw the bar as a thick vertical line
            g2d.drawLine(x, y1, x, y2);
        }
    }
}