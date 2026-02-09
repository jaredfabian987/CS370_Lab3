import javax.swing.*;

public class Main extends JFrame {
    // create a constructor for the java class
    public Main (){
        setTitle ("Lab 3: Random Bar Chart");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,700);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}