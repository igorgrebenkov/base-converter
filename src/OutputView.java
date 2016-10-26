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
        //setPreferredSize(new Dimension(600, 150));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));



        outputLabel = new JLabel("Output");
        outputLabel.setFont(outputLabel.getFont().deriveFont(outputLabel.getFont().getSize() * 1.8F));
        outputLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        outputLabel.setForeground(Color.WHITE);
        outputLabel.setAlignmentX( Component.CENTER_ALIGNMENT );
        outputLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        JLabel outBinaryLabel = new JLabel("Binary:");
        outBinaryLabel.setLabelFor(outputLabel);


                outBinaryField = new JTextField();
        //outBinaryField.setPreferredSize(new Dimension(400, 30));
        outBinaryField.setMaximumSize(new Dimension(MAX_FIELD_WIDTH, 30));
        outBinaryField.setAlignmentX(Component.CENTER_ALIGNMENT);
        outBinaryField.setFont(outBinaryField.getFont().deriveFont(outBinaryField.getFont().getSize() * 1.8f));


        outOctalField = new JTextField();
        //outOctalField.setPreferredSize(new Dimension(400, 30));
        outOctalField.setMaximumSize(new Dimension(MAX_FIELD_WIDTH, 30));
        outOctalField.setAlignmentX(Component.CENTER_ALIGNMENT);
        outOctalField.setFont(outOctalField.getFont().deriveFont(outOctalField.getFont().getSize() * 1.8f));

        outDecimalField = new JTextField();
        //outDecimalField.setPreferredSize(new Dimension(400, 30));
        outDecimalField.setMaximumSize(new Dimension(MAX_FIELD_WIDTH, 30));
        outDecimalField.setAlignmentX(Component.CENTER_ALIGNMENT);
        outDecimalField.setFont(outDecimalField.getFont().deriveFont(outDecimalField.getFont().getSize() * 1.8f));

        outHexField = new JTextField();
        //outHexField.setPreferredSize(new Dimension(400, 30));
        outHexField.setMaximumSize(new Dimension(MAX_FIELD_WIDTH, 30));
        outHexField.setAlignmentX(Component.CENTER_ALIGNMENT);
        outHexField.setFont(outHexField.getFont().deriveFont(outHexField.getFont().getSize() * 1.8f));

        add(Box.createRigidArea(new Dimension(0, 10)));
        add(outputLabel);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(outBinaryField);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(outOctalField);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(outDecimalField);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(outHexField);
        add(Box.createRigidArea(new Dimension(0,10)));

    }

    public void update() {
        revalidate();
        repaint();
    }
}
