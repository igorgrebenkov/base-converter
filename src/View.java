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
    private static final int WIDTH = 500;
    private static final int HEIGHT = 375;


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



        inputView = new InputView(model, controller);
        inputView.setLayout(new BoxLayout(inputView, BoxLayout.PAGE_AXIS));


        outputView = new OutputView(model, controller);
        outputView.setLayout(new BoxLayout(outputView, BoxLayout.PAGE_AXIS));


        mainPanel.add(inputView, BorderLayout.PAGE_START);
        mainPanel.add(outputView, BorderLayout.PAGE_END);

        add(mainPanel);

        pack();
    }

    public void update() {
        revalidate();
        repaint();
    }
}
