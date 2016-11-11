import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * The class <b>View</b> contains the main View of the program.
 * <p>
 * It extends JFrame.
 *
 * @author Igor Grebenkov
 */
public class View extends JFrame {

    private InputView inputView;            // The View for the top (input) portion
    private OutputView outputView;          // The View for the bottom (output) portion
    private static final int WIDTH = 525;   // the preferred width of the JFrame
    private static final int HEIGHT = 300;  // the preferred height of the JFrame

    /**
     * Constructor
     *
     * @param model      the model
     * @param controller the controller
     */
    public View(Model model, Controller controller) {
        super("Base Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);
        setVisible(true);
        setFocusable(false);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        /******************* Main Panel *******************/
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.setBackground(Color.darkGray);

        /******************** Menu bar ********************/
        JMenuBar menuBar;       // the menuBar
        JMenu helpMenu;         // the helpMenu
        JMenuItem helpItem;     // opens help dialog; in help menu
        JMenuItem aboutItem;    // opens about dialog; in help menu

        menuBar = new JMenuBar();

        // Help menu
        helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);
        helpMenu.getAccessibleContext().setAccessibleDescription(
                "Contains items that open the help and about dialogs."
        );
        menuBar.add(helpMenu);

        // Help menu item
        helpItem = new JMenuItem("Help", KeyEvent.VK_H);
        helpItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_H, ActionEvent.ALT_MASK));
        helpItem.getAccessibleContext().setAccessibleDescription(
                "Opens the help dialog."
        );
        helpMenu.add(helpItem);

        // About menu item
        aboutItem = new JMenuItem("About", KeyEvent.VK_A);
        aboutItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_A, ActionEvent.ALT_MASK));
        aboutItem.getAccessibleContext().setAccessibleDescription(
                "Opens the about dialog."
        );
        helpMenu.add(aboutItem);
        setJMenuBar(menuBar);

        /*************** Input Label & View ****************/
        JPanel inputLabelPanel = new JPanel();
        inputLabelPanel.setBackground(Color.darkGray);
        JLabel inputLabel = new JLabel("          Input");  // super hacky spacing
        inputLabel.setFont(inputLabel.getFont().deriveFont(inputLabel.getFont().getSize() * 1.8f));
        inputLabel.setForeground(Color.WHITE);
        inputLabelPanel.add(inputLabel);
        inputView = new InputView(model, controller);
        inputView.setMaximumSize(new Dimension(475, 100));

        /*************** Output Label & View ***************/
        JPanel outputLabelPanel = new JPanel();
        outputLabelPanel.setBackground(Color.darkGray);
        JLabel outputLabel = new JLabel("          Output");  // super hacky spacing
        outputLabel.setFont(outputLabel.getFont().deriveFont(outputLabel.getFont().getSize() * 1.8f));
        outputLabel.setForeground(Color.WHITE);
        outputLabelPanel.add(outputLabel);
        outputView = new OutputView(model, controller);
        outputView.setMaximumSize(new Dimension(475, 700));

        /*********** Add everything to mainPanel **********/
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

    /**
     * Getter for the InputView.
     *
     * @return the OutputView
     */
    public InputView getInputView() {
        return inputView;
    }

    /**
     * Getter for the OutputView.
     *
     * @return the OutputView
     */
    public OutputView getOutputView() {
        return outputView;
    }

    /**
     * Updates the JFrame, as well as the InputView and OutputView.
     */
    public void update() {
        inputView.update();
        outputView.update();
        revalidate();
        repaint();
    }
}
