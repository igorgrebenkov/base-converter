import javax.swing.*;
import java.awt.*;

/**
 * The class <b>OutputView</b> gives the view of the bottom portion of the program (for output).
 * <p>
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
    private JLabel outOctalLabel;
    private JLabel outDecimalLabel;
    private JLabel outHexLabel;

    private final static int MAX_FIELD_WIDTH = 400;


    public OutputView(Model model, Controller controller) {
        this.model = model;
        setBackground(Color.darkGray);
        setFocusable(true);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        outputLabel = new JLabel("Output");
        outputLabel.setFont(outputLabel.getFont().deriveFont(outputLabel.getFont().getSize() * 1.8F));
        outputLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        outputLabel.setForeground(Color.WHITE);
        outputLabel.setAlignmentX( Component.CENTER_ALIGNMENT );
        outputLabel.setAlignmentY(Component.CENTER_ALIGNMENT);

        outBinaryField = new JTextField();
        outBinaryField.setMaximumSize(new Dimension(MAX_FIELD_WIDTH, 30));
        outBinaryField.setFont(outBinaryField.getFont().deriveFont(outBinaryField.getFont().getSize() * 1.8f));
        outBinaryField.setEditable(false);
        JLabel outBinaryLabel = new JLabel("Binary  ");
        outBinaryLabel.setLabelFor(outBinaryField);
        outBinaryLabel.setFont(outBinaryLabel.getFont().deriveFont(outBinaryLabel.getFont().getSize() * 1.4f));
        outBinaryLabel.setForeground(Color.WHITE);

        outOctalField = new JTextField();
        outOctalField.setMaximumSize(new Dimension(MAX_FIELD_WIDTH, 30));
        outOctalField.setFont(outOctalField.getFont().deriveFont(outOctalField.getFont().getSize() * 1.8f));
        outOctalField.setEditable(false);
        JLabel outOctalLabel = new JLabel("Octal  ");
        outOctalLabel.setLabelFor(outOctalField);
        outOctalLabel.setFont(outOctalLabel.getFont().deriveFont(outOctalLabel.getFont().getSize() * 1.4f));
        outOctalLabel.setForeground(Color.WHITE);

        outDecimalField = new JTextField();
        outDecimalField.setMaximumSize(new Dimension(MAX_FIELD_WIDTH, 30));
        outDecimalField.setFont(outDecimalField.getFont().deriveFont(outDecimalField.getFont().getSize() * 1.8f));
        outDecimalField.setEditable(false);
        JLabel outDecimalLabel = new JLabel("Decimal  ");
        outDecimalLabel.setLabelFor(outDecimalField);
        outDecimalLabel.setFont(outDecimalLabel.getFont().deriveFont(outDecimalLabel.getFont().getSize() * 1.4f));
        outDecimalLabel.setForeground(Color.WHITE);

        outHexField = new JTextField();
        outHexField.setMaximumSize(new Dimension(MAX_FIELD_WIDTH, 30));
        outHexField.setFont(outHexField.getFont().deriveFont(outHexField.getFont().getSize() * 1.8f));
        outHexField.setEditable(false);
        JLabel outHexLabel = new JLabel("Hex  ");
        outHexLabel.setLabelFor(outHexField);
        outHexLabel.setFont(outHexLabel.getFont().deriveFont(outHexLabel.getFont().getSize() * 1.4f));
        outHexLabel.setForeground(Color.WHITE);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;

        add(outBinaryLabel);
        c.gridwidth = GridBagConstraints.REMAINDER;
        add(outBinaryField, c);

        add(outOctalLabel);
        add(outOctalField, c);

        add(outDecimalLabel);
        add(outDecimalField, c);

        add(outHexLabel);
        add(outHexField, c);
    }

    public void update() {
        revalidate();
        repaint();
    }
}
