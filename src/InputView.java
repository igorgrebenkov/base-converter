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
        setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

        inputLabel = new JLabel("Input");
        inputLabel.setFont(inputLabel.getFont().deriveFont(inputLabel.getFont().getSize() * 1.8f));
        inputLabel.setForeground(Color.WHITE);
        inputLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputLabel.setAlignmentY(Component.CENTER_ALIGNMENT);

        inputField = new JTextField();
        inputField.setPreferredSize(new Dimension(400,30));
        inputField.setMaximumSize(new Dimension(MAX_FIELD_WIDTH,30));
        inputField.setAlignmentX( Component.CENTER_ALIGNMENT );
        inputField.setFont(inputField.getFont().deriveFont(inputField.getFont().getSize() * 1.8f));

        add(Box.createRigidArea(new Dimension(0,10)));
        add(inputLabel);
        add(Box.createRigidArea(new Dimension(0,10)));
        add(inputField);
    }

    public void update() {
        revalidate();
        repaint();
    }
}
