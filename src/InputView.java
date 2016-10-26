import javax.swing.*;
import java.awt.*;

/**
 * The class <b>InputView</b> gives the view of the top portion of the program (for user input).
 *
 * It extends JPanel.
 *
 * @author Igor Grebenkov
 */
public class InputView extends JPanel {
    private Model model;        // the model
    private JLabel inputLabel;  // Label for the input field
    private JTextField inputField = new JTextField();  // the field for user input

    public InputView(Model model) {
        this.model = model;
        setBackground(Color.darkGray);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setFocusable(true);

        inputLabel = new JLabel("Input");

        inputField = new JTextField();

        add(inputLabel);
        add(inputField);
    }

    public void update() {
        revalidate();
        repaint();
    }
}
