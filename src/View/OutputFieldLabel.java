package View;

import javax.swing.*;
import java.awt.*;

/**
 * <p>The class <b>View.OutputFieldLabel</b> is used for making the labels associated with output text fields.</p>
 * <p>
 * <p>It extends JLabel.</p>
 *
 * @author Igor Grebenkov
 */
public class OutputFieldLabel extends JLabel {
    private static final float TEXT_SCALING_FACTOR = 1.8f;  // scaling factor for label text

    /**
     * Constructor.
     *
     * @param label the label text
     */
    public OutputFieldLabel(String label) {
        super(label);
        setFont(getFont().deriveFont(getFont().getSize() * TEXT_SCALING_FACTOR));
        setForeground(Color.WHITE);
    }
}
