import javax.swing.*;
import java.awt.*;

/**
 * The class <b>View</b> contains the main View of the program.
 *
 * It extends JFrame.
 *
 * @author Igor Grebenkov
 */
public class View extends JFrame {

    public View(Model model, Controller controller) {
        super("Base Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setMinimumSize(new Dimension(400, 800));
        setPreferredSize(new Dimension(400, 800));
        setResizable(true);
        setVisible(true);
        setFocusable(false);
        pack();
    }

    public void update() {
        revalidate();
        repaint();
    }
}
