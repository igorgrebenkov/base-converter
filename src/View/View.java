package View;

import Controller.*;
import Model.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.basic.BasicMenuBarUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * <p>The class <b>View.View</b> contains the main View.View of the program.</p>
 * <p>
 * <p>It extends JFrame.</p>
 *
 * @author Igor Grebenkov
 */
public class View extends JFrame {

    private InputView inputView;                            // The View.View for the top (input) portion
    private OutputView outputView;                          // The View.View for the bottom (output) portion
    private static final int FRAME_WIDTH = 525;             // the preferred width of the JFrame
    private static final int FRAME_HEIGHT = 300;            // the preferred height of the JFrame
    private static final float TEXT_SCALING_FACTOR = 1.8f;  // scaling factor for label text

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
        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));

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
        menuBar.setBorderPainted(false);
        menuBar.setUI(new BasicMenuBarUI() {
            public void paint(Graphics g, JComponent c) {
                g.setColor(Color.darkGray);
                g.fillRect(0, 0, c.getWidth(), c.getHeight());
            }
        });

        // Help menu
        helpMenu = new JMenu();
        // Sets icon for help menu by reading external image
        try {
            BufferedImage brImg = ImageIO.read(new File("img/menu_icon.png"));
            ImageIcon menuIcon = new ImageIcon(brImg);
            helpMenu.setIcon(menuIcon);
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }

        helpMenu.setMnemonic(KeyEvent.VK_H);
        helpMenu.getAccessibleContext().setAccessibleDescription(
                "Contains items that open the help and about dialogs."
        );
        helpMenu.setForeground(Color.white);
        menuBar.add(helpMenu);

        // Help menu item
        helpItem = new JMenuItem("Help", KeyEvent.VK_H);
        helpItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_H, ActionEvent.ALT_MASK));
        helpItem.getAccessibleContext().setAccessibleDescription(
                "Opens the help dialog."
        );
        helpItem.addActionListener(controller);
        helpItem.setActionCommand("helpDialog");
        helpMenu.add(helpItem);

        // About menu item
        aboutItem = new JMenuItem("About", KeyEvent.VK_A);
        aboutItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_A, ActionEvent.ALT_MASK));
        aboutItem.getAccessibleContext().setAccessibleDescription(
                "Opens the about dialog."
        );
        aboutItem.addActionListener(controller);
        aboutItem.setActionCommand("aboutDialog");
        helpMenu.add(aboutItem);

        setJMenuBar(menuBar);

        /*************** Input Label & View.View ****************/
        final int INPUT_PANEL_WIDTH = 475;      // Maximum width of the inputLabelPanel
        final int INPUT_PANEL_HEIGHT = 100;     // Maximum height of the inputLabelPanel

        JPanel inputLabelPanel = new JPanel();
        inputLabelPanel.setBackground(Color.darkGray);
        JLabel inputLabel = new JLabel("          Input");  // super hacky spacing
        inputLabel.setFont(
                inputLabel.getFont().deriveFont(
                        inputLabel.getFont().getSize() * TEXT_SCALING_FACTOR));
        inputLabel.setForeground(Color.WHITE);
        inputLabelPanel.add(inputLabel);
        inputView = new InputView(model, controller);
        inputView.setMaximumSize(new Dimension(
                INPUT_PANEL_WIDTH,
                INPUT_PANEL_HEIGHT));

        /*************** Output Label & View.View ***************/
        final int OUTPUT_PANEL_WIDTH = 475;     // Maximum width of the outputLabelPanel
        final int OUTPUT_PANEL_HEIGHT = 700;    // Maximum height of the outputLabelPanel

        JPanel outputLabelPanel = new JPanel();
        outputLabelPanel.setBackground(Color.darkGray);
        JLabel outputLabel = new JLabel("          Output");  // super hacky spacing
        outputLabel.setFont(
                outputLabel.getFont().deriveFont(
                        outputLabel.getFont().getSize() * TEXT_SCALING_FACTOR));
        outputLabel.setForeground(Color.WHITE);
        outputLabelPanel.add(outputLabel);
        outputView = new OutputView(model, controller);
        outputView.setMaximumSize(new Dimension(
                OUTPUT_PANEL_WIDTH,
                OUTPUT_PANEL_HEIGHT));

        /*********** Add everything to mainPanel **********/
        final int SPACER_HEIGHT = 10;           // Height of RigidArea used as a spacer

        mainPanel.add(inputLabelPanel, BorderLayout.PAGE_START);
        mainPanel.add(inputView, BorderLayout.NORTH);
        mainPanel.add(Box.createRigidArea(new Dimension(0, SPACER_HEIGHT)));
        mainPanel.add(outputLabelPanel, BorderLayout.SOUTH);
        mainPanel.add(outputView, BorderLayout.PAGE_END);
        mainPanel.add(Box.createRigidArea(new Dimension(0, SPACER_HEIGHT)));
        add(mainPanel);
        inputView.getInputField().requestFocus();
        pack();
    }

    /**
     * Getter for the View.InputView.
     *
     * @return the View.OutputView
     */
    public InputView getInputView() {
        return inputView;
    }

    /**
     * Getter for the View.OutputView.
     *
     * @return the View.OutputView
     */
    public OutputView getOutputView() {
        return outputView;
    }

    /**
     * Updates the JFrame, as well as the View.InputView and View.OutputView.
     */
    public void update() {
        inputView.update();
        outputView.update();
        revalidate();
        repaint();
    }
}
