package View;

import Controller.*;
import Model.*;

import javax.swing.*;
import javax.swing.plaf.basic.BasicMenuBarUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

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
    private static final int FRAME_HEIGHT = 250;            // the preferred height of the JFrame

    /**
     * Constructor
     *
     * @param model      the model
     * @param controller the controller
     */
    public View(Model model, Controller controller) {
        super("base-converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(true);
        setVisible(true);
        setFocusable(false);
        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        setMinimumSize(new Dimension(FRAME_WIDTH, 250));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 250));

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
        helpMenu = new JMenu("Help");
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

        inputView = new InputView(model, controller);
        outputView = new OutputView(model, controller);

        /*********** Add everything to mainPanel **********/
        final int SPACER_HEIGHT = 10;           // Height of RigidArea used as a spacer

        mainPanel.add(inputView, BorderLayout.NORTH);
        mainPanel.add(Box.createRigidArea(new Dimension(0, SPACER_HEIGHT)));
        mainPanel.add(outputView, BorderLayout.PAGE_END);
        mainPanel.add(Box.createRigidArea(new Dimension(0, SPACER_HEIGHT)));
        add(mainPanel);
        inputView.getInputField().requestFocus();
        pack();
        setLocationRelativeTo(null);
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
