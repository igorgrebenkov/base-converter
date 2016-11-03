import javax.swing.*;
import java.awt.*;

/**
 * The class <b>View</b> contains the main View of the program.
 * <p>
 * It extends JFrame.
 *
 * @author Igor Grebenkov
 */
public class View extends JFrame {

    private InputView inputView;    // The view for the top (input) portion
    private OutputView outputView;  // The view for the bottom (output) portion
    private static final int WIDTH = 525;
    private static final int HEIGHT = 300;


    public View(Model model, Controller controller) {
        super("Base Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);
        setVisible(true);
        setFocusable(false);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.setBackground(Color.darkGray);

        JPanel inputLabelPanel = new JPanel();
        inputLabelPanel.setBackground(Color.darkGray);
        JLabel inputLabel = new JLabel("          Input");  // super hacky spacing
        inputLabel.setFont(inputLabel.getFont().deriveFont(inputLabel.getFont().getSize() * 1.8f));
        inputLabel.setForeground(Color.WHITE);
        inputLabelPanel.add(inputLabel);
        inputView = new InputView(model, controller);
        inputView.setMaximumSize(new Dimension(475, 100));

        JPanel outputLabelPanel = new JPanel();
        outputLabelPanel.setBackground(Color.darkGray);
        JLabel outputLabel = new JLabel("          Output");  // super hacky spacing
        outputLabel.setFont(outputLabel.getFont().deriveFont(outputLabel.getFont().getSize() * 1.8f));
        outputLabel.setForeground(Color.WHITE);
        outputLabelPanel.add(outputLabel);
        outputView = new OutputView(model, controller);
        outputView.setMaximumSize(new Dimension(475, 700));

        mainPanel.add(inputLabelPanel, BorderLayout.PAGE_START);
        mainPanel.add(inputView, BorderLayout.NORTH);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(outputLabelPanel, BorderLayout.SOUTH);
        mainPanel.add(outputView, BorderLayout.PAGE_END);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        add(mainPanel);
        inputView.getInputField().requestFocus();
        pack();
    }

    public OutputView getOutputView() {
        return outputView;
    }

    public void update() {
        inputView.update();
        outputView.update();
        revalidate();
        repaint();
    }
}
