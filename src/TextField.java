import javax.swing.*;
import java.awt.*;

/**
 * <p>The class <b>TextField</b> is used for all input/output text fields.</p>
 * <p>
 * <p>It extends JTextField.</p>
 *
 * @author Igor Grebenkov
 */
public class TextField extends JTextField {
    private final static int MAX_FIELD_WIDTH = 400;         // max width of the TextField
    private final static int MAX_FIELD_HEIGHT = 30;
    private static final float TEXT_SCALING_FACTOR = 1.8f;  // scaling factor for label text

    /**
     * Constructor.
     */
    public TextField() {
        setMaximumSize(new Dimension(MAX_FIELD_WIDTH, MAX_FIELD_HEIGHT));
        setFont(getFont().deriveFont(getFont().getSize() * TEXT_SCALING_FACTOR));
        setEditable(false);
        setHorizontalAlignment(JTextField.CENTER);
        setFocusable(false);
    }
}
