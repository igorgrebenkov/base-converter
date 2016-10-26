import javax.swing.*;
import java.awt.*;

/**
 * The class <b>OutputFieldLabel</b> is used for making the labels associated with output text fields.
 *
 * It extends JLabel.
 */
public class OutputFieldLabel extends JLabel {
    public OutputFieldLabel(String label) {
        super(label);
        setFont(getFont().deriveFont(getFont().getSize() * 1.4f));
        setForeground(Color.WHITE);
    }
}
