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



    public OutputView(Model model, Controller controller) {
        this.model = model;
        setBackground(Color.darkGray);
        setFocusable(true);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        outputLabel = new JLabel("Output");
        outputLabel.setFont(outputLabel.getFont().deriveFont(outputLabel.getFont().getSize() * 1.8F));
        outputLabel.setForeground(Color.WHITE);

        outBinaryField = new TextField();
        JLabel outBinaryLabel = new OutputFieldLabel("Binary  ");

        outOctalField = new TextField();
        JLabel outOctalLabel = new OutputFieldLabel("Octal  ");

        outDecimalField = new TextField();
        JLabel outDecimalLabel = new OutputFieldLabel("Decimal  ");

        outHexField = new TextField();
        JLabel outHexLabel = new OutputFieldLabel("Hex  ");

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

    public void setOutBinaryFieldText(String s) {
        outBinaryField.setText(s);
    }

    public void setOutOctalFieldText(String s) {
        outOctalField.setText(s);
    }

    public void setOutDecimalFieldText(String s) {
        outDecimalField.setText(s);
    }

    public void setOutHexFieldText(String s) {
        outHexField.setText(s);
    }

    public void update() {
        revalidate();
        repaint();
    }
}
