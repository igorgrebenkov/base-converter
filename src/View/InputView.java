package View;

import Controller.*;
import Model.*;

import javax.swing.*;
import java.awt.*;

/**
 * <p>The class <b>View.InputView</b> gives the view of the top portion of the program (for user input).</p>
 * <p>
 * <p>It extends JPanel.</p>
 *
 * @author Igor Grebenkov
 */
public class InputView extends JPanel {
    private Model model;
    private JTextField inputField = new JTextField();       // the field for user input
    private static final float TEXT_SCALING_FACTOR = 1.4f;  // scaling factor for label text

    /**
     * Constructor.
     *
     * @param model      the model
     * @param controller the controller
     */
    public InputView(Model model, Controller controller) {
        this.model = model;
        setBackground(Color.darkGray);
        setFocusable(true);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        inputField = new TextField();
        inputField.setEditable(true);
        inputField.setFocusable(true);
        inputField.getDocument().addDocumentListener(controller);
        inputField.addKeyListener(controller);

        JLabel spacer = new JLabel("                 "); // Maintains spacing with output TextFields
        spacer.setFont(
                spacer.getFont().deriveFont(
                        spacer.getFont().getSize() * TEXT_SCALING_FACTOR));
        spacer.setLabelFor(inputField);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        add(spacer);
        c.gridwidth = GridBagConstraints.REMAINDER;
        add(inputField, c);
    }

    /**
     * Getter for the InputField.
     *
     * @return the InputField
     */
    public JTextField getInputField() {
        return inputField;
    }

    /**
     * Updates the InputField and updates the Model.Model with its text.
     */
    public void update() {
        model.setInput(inputField.getText());
        revalidate();
        repaint();
    }
}
