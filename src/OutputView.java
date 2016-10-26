import javax.swing.*;
import java.awt.*;

/**
 * The class <b>OutputView</b> gives the view of the bottom portion of the program (for output).
 *
 * It extends JPanel.
 *
 * @author Igor Grebenkov
 */
public class OutputView extends JPanel {
    private Model model;                // the model
    private JLabel outputLabel;         // the label for the output fields
    private JTextField outBinaryField;  // the binary output field
    private JTextField outOctalField;   // the octal output field
    private JTextField outDecimalField; // the decimal output field
    private JTextField outHexField;     // the hex output field


    public OutputView(Model model) {
        this.model = model;
        setBackground(Color.darkGray);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setFocusable(true);

       outputLabel = new JLabel("Output");

        outBinaryField = new JTextField();
        outOctalField = new JTextField();
        outDecimalField = new JTextField();
        outHexField = new JTextField();

        add(outputLabel);
        add(outOctalField);
        add(outDecimalField);
        add(outHexField);
    }

    public void update() {
        revalidate();
        repaint();
    }
}
