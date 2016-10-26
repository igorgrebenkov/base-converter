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
    private final static int MAX_FIELD_WIDTH = 400;

    public InputView(Model model, Controller controller) {
        this.model = model;
        setBackground(Color.darkGray);
        setFocusable(true);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        inputField = new JTextField();
        inputField.setMaximumSize(new Dimension(MAX_FIELD_WIDTH,30));
        inputField.setFont(inputField.getFont().deriveFont(inputField.getFont().getSize() * 1.8f));

        JLabel spacer = new JLabel("              ");
        spacer.setFont(spacer.getFont().deriveFont(spacer.getFont().getSize() * 1.4f));
        spacer.setLabelFor(inputField);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        add(spacer);
        c.gridwidth = GridBagConstraints.REMAINDER;
        add(inputField, c);
    }

    public void update() {
        revalidate();
        repaint();
    }
}
