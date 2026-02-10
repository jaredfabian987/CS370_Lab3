import javax.swing.*;
import java.awt.*;
import java.util.Random;

// works cited/references
// yt video : https://www.youtube.com/watch?v=Kmgo00avvEw
public class Main extends JFrame {

    public Main () {
        setTitle("Lab 3: Random Bar Chart");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout (new BorderLayout());

        // Create ONE panel that does everything
        DrawingPanel dp = new DrawingPanel();
        add (dp, BorderLayout.CENTER);

        // Create the redraw button
        JButton redrawButton = new JButton("Redraw");
        add (redrawButton, BorderLayout.SOUTH);

        // Set the window size
        setSize(600, 700);

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
    private static final int GRID_SIZE = 10;  // Grid constant
    private Random random;  // For random colors/heights

    public DrawingPanel() {
        setBackground(Color.GRAY);
        random = new Random();  // Initialize random generator
    }

    @Override
    public void paintComponent(Graphics gfx) {
        super.paintComponent(gfx);
        Graphics2D g2d = (Graphics2D) gfx;

        // Get panel dimensions
        int width = 600;
        int height = 700;

        // Calculate cell sizes
        int cellWidth = width / GRID_SIZE;
        int cellHeight = height / GRID_SIZE;

        // STEP 4: Draw the 10x10 grid
        g2d.setColor(Color.WHITE);

        // Draw vertical lines
        for (int i = 0; i <= GRID_SIZE; i++) {
            g2d.drawLine(i * cellWidth, 0, i * cellWidth, height);
        }

        // Draw horizontal lines
        for (int i = 0; i <= GRID_SIZE; i++) {
            g2d.drawLine(0, i * cellHeight, width, i * cellHeight);
        }

        // draw a random colored bar
        g2d.setStroke(new BasicStroke(10)); // Line thickness of 10

        // Random color
        Color randomColor = new Color(random.nextInt(256),  // Red: 0-255
                random.nextInt(256),  // Green: 0-255
                random.nextInt(256)   // Blue: 0-255
        );
        g2d.setColor(randomColor);

        // Draw a vertical bar in the middle
        int x = width / 2;  // Center of panel
        int barHeight = 100 + random.nextInt(200);  // Random height 100-300
        int y1 = height - 50;  // Bottom of bar (leave some space)
        int y2 = y1 - barHeight;  // Top of bar

        g2d.drawLine(x, y1, x, y2);
    }
    // added one comment
}