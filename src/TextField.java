import javax.swing.*;
import java.awt.*;

/**
 * The class <b>TextField</b> is used for all input/output text fields.
 *
 * It extends JTextField.
 */
public class TextField extends JTextField {
    private final static int MAX_FIELD_WIDTH = 400; // max width of the TextField
    private final static float TEXT_SCALING_FACTOR = 1.8f;

    /**
     * Constructor.
     */
    public TextField() {
        setMaximumSize(new Dimension(MAX_FIELD_WIDTH, 30));
        setFont(getFont().deriveFont(getFont().getSize() * TEXT_SCALING_FACTOR));
        setEditable(false);
        setHorizontalAlignment(JTextField.CENTER);
        setFocusable(false);
    }
}
