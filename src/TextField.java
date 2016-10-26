import javax.swing.*;
import java.awt.*;

/**
 * The class <b>TextField</b> is used for all input/output text fields.
 *
 * It extends JTextField
 */
public class TextField extends JTextField {
    private final static int MAX_FIELD_WIDTH = 400;

    public TextField() {
        setMaximumSize(new Dimension(MAX_FIELD_WIDTH, 30));
        setFont(getFont().deriveFont(getFont().getSize() * 1.8f));
        setEditable(false);
        setHorizontalAlignment(JTextField.CENTER);

    }
}
