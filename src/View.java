import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * The class <b>View</b> contains the main View of the program.
 * <p>
 * It extends JFrame.
 *
 * @author Igor Grebenkov
 */
public class View extends JFrame {

    InputView inputView;    // The view for the top (input) portion
    OutputView outputView;  // The view for the bottom (output) portion
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
        mainPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        mainPanel.setBackground(Color.darkGray);

        JPanel inputLabelPanel = new JPanel();
        inputLabelPanel.setBackground(Color.darkGray);
        JLabel inputLabel = new JLabel("Input");
        inputLabel.setFont(inputLabel.getFont().deriveFont(inputLabel.getFont().getSize() * 1.8f));
        inputLabel.setForeground(Color.WHITE);
        inputLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        inputLabelPanel.add(inputLabel);
        inputView = new InputView(model, controller);
        inputView.setMaximumSize(new Dimension(475, 100));
        inputView.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputView.setAlignmentY(Component.CENTER_ALIGNMENT);


        JPanel outputLabelPanel = new JPanel();
        outputLabelPanel.setBackground(Color.darkGray);
        JLabel outputLabel = new JLabel("Output");
        outputLabel.setFont(outputLabel.getFont().deriveFont(outputLabel.getFont().getSize() * 1.8f));
        outputLabel.setForeground(Color.WHITE);
        outputLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        outputLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        outputLabelPanel.add(outputLabel);
        outputView = new OutputView(model, controller);
        outputView.setMaximumSize(new Dimension(475, 700));
        outputView.setAlignmentX(Component.CENTER_ALIGNMENT);
        outputView.setAlignmentY(Component.CENTER_ALIGNMENT);

        mainPanel.add(inputLabelPanel, BorderLayout.PAGE_START);
        mainPanel.add(inputView, BorderLayout.NORTH);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(outputLabelPanel, BorderLayout.SOUTH);
        mainPanel.add(outputView, BorderLayout.PAGE_END);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        add(mainPanel);

        pack();
    }

    public void update() {
        revalidate();
        repaint();
    }
}
