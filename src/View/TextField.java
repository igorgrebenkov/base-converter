package View;

import javax.swing.*;
import java.awt.*;

/**
 * <p>The class <b>View.TextField</b> is used for all input/output text fields.</p>
 * <p>
 * <p>It extends JTextField.</p>
 *
 * @author Igor Grebenkov
 */
public class TextField extends JTextField {
    private final static int MAX_FIELD_WIDTH = 400;         // max width of the View.TextField
    private final static int MAX_FIELD_HEIGHT = 30;

    /**
     * Constructor.
     */
    public TextField() {
        setMaximumSize(new Dimension(MAX_FIELD_WIDTH, MAX_FIELD_HEIGHT));
        setEditable(false);
        setHorizontalAlignment(JTextField.CENTER);
        setFocusable(false);
    }
}
