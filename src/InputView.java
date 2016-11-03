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
    private Model model;
    private JTextField inputField = new JTextField();  // the field for user input

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

        JLabel spacer = new JLabel("            "); // Maintains spacing with output TextFields
        spacer.setFont(spacer.getFont().deriveFont(spacer.getFont().getSize() * 1.4f));
        spacer.setLabelFor(inputField);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        add(spacer);
        c.gridwidth = GridBagConstraints.REMAINDER;
        add(inputField, c);
    }

    public JTextField getInputField() {
        return inputField;
    }

    public void update() {
        model.setInput(inputField.getText());
        revalidate();
        repaint();
    }
}
