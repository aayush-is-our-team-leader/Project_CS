import javax.swing.*;

/**
 * Main class with main method invoked on app start.
 */
public class Main {
    /**
     * Invoked on start.
     * @param args ignored
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sample App");
        JLabel label = new JLabel("Hello from Java!", SwingConstants.CENTER);
        frame.add(label);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
