package Controller;

import View.*;
import Model.*;
import sun.java2d.loops.ProcessPath;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.datatransfer.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

/**
 * <p>The class <b>Controller.Controller</b> handles all events and
 * communicates changes between the model and view.</p>
 * <p>
 * <p>It implements ActionListener, DocumentListener, and KeyListener.</p>
 *
 * @author Igor Grebenkov
 */
public class Controller implements ActionListener, DocumentListener, KeyListener {
    private Model model;
    private View view;

    /**
     * Constructor.
     */
    public Controller() {
        model = new Model();
        view = new View(model, this);
    }

    /***************************
     * ActionEvent Handlers
     **************************/
    /**
     * The actionPerformed ActionEvent handler. Currently unused.
     *
     * @param e the ActionEvent
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("helpDialog")) {
            helpMenuItemAction();
        } else if (e.getActionCommand().equals("aboutDialog")) {
            aboutMenuItemAction();
        }
    }

    /************************
     * KeyListenerEvent Handlers
     ************************/
    /**
     * The keyTyped KeyEvent handler. Unused.
     *
     * @param e the KeyEvent
     */
    public void keyTyped(KeyEvent e) {
    }

    /**
     * The KeyPressed KeyEvent handler. Used to implement keyboard
     * shortcuts.
     * <p>
     * CTRL+5 -> copy binary output
     * CTRL+2 -> copy octal output
     * CTRL+3 -> copy decimal output
     * CTRL+3 -> copy hex output
     * CTRL+i -> copy input
     * CTRL+c -> clear input (and output)
     *
     * @param e the KeyEvent
     */
    public void keyPressed(KeyEvent e) {
        if (e.isControlDown()) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_5:
                    clipBoardAction(model.getOutBinary());
                    break;
                case KeyEvent.VK_2:
                    clipBoardAction(model.getOutOctal());
                    break;
                case KeyEvent.VK_3:
                    clipBoardAction(model.getOutDecimal());
                    break;
                case KeyEvent.VK_4:
                    clipBoardAction(model.getOutHex());
                    break;
                case KeyEvent.VK_I:
                    clipBoardAction(model.getInput().substring(1).trim());
                    break;
                case KeyEvent.VK_C:
                    model.setInput("");
                    view.getInputView().getInputField().setText("");
                    view.getOutputView().setAllFields("");
                    break;
            }
        }
    }

    /**
     * The keyReleased KeyEvent handler. Unused.
     *
     * @param e the KeyEvent
     */
    public void keyReleased(KeyEvent e) {
    }


    /*************************
     * DocumentEvent Handlers
     *************************/
    /**
     * The insertUpdate DocumentEvent handler.
     * <p>
     * Used to get input string for conversion from the input textfield.
     *
     * @param de the DocumentEvent
     */
    public void insertUpdate(DocumentEvent de) {
        Document source = de.getDocument();
        String input = "";
        try {
            input += source.getText(0, source.getLength());
        } catch (BadLocationException e) {
            System.out.println("BadLocationException: " + e.getMessage());
        }
        processInput(input);
    }

    /**
     * The changedUpdate DocumentEvent handler. Unused.
     *
     * @param de the DocumentEvent
     */
    public void changedUpdate(DocumentEvent de) {
    }

    /**
     * The removeUpdate DocumentEvent handler.
     * <p>
     * Used to update the input string when digits are being deleted.
     *
     * @param de the DocumentEvent
     */
    public void removeUpdate(DocumentEvent de) {
        Document source = de.getDocument();
        String input = "";
        try {
            input += source.getText(0, source.getLength());
        } catch (BadLocationException e) {
            System.out.println("BadLocationException: " + e.getMessage());
        }
        processInput(input);
    }

    /**
     * Private helper function that process the input. When a valid
     * prefix (% - binary, @ octal, # - decimal, $ - hex) is detected, the
     * input string is converted and output via the Controller.Conversion class.
     *
     * @param input the input string
     */
    private void processInput(String input) {
        if (input.length() > 1) {
            if (input.charAt(0) == '%' ||
                    input.charAt(0) == '@' ||
                    input.charAt(0) == '#' ||
                    input.charAt(0) == '$') {
                try {
                    char basePrefix = input.charAt(0);
                    Conversion.convertNumber(basePrefix, input.substring(1), model);
                    view.update();
                } catch (NumberFormatException e) {
                    view.getOutputView().setAllFields("invalid number");
                }
            }
        } else if (input.length() == 1 && !(
                input.charAt(0) == '%' ||
                        input.charAt(0) == '@' ||
                        input.charAt(0) == '#' ||
                        input.charAt(0) == '$')) {
            view.getOutputView().setAllFields("Need valid prefix (%, @, #, $).");

        } else {
            model.setOutBinary("");
            model.setOutOctal("");
            model.setOutDecimal("");
            model.setOutHex("");
            view.update();
        }
    }

    /**
     * Private helper function that copies a string to the clipboard.
     * <p>
     * Used to implement keyboard shortcuts for copying input/output fields.
     */
    private void clipBoardAction(String s) {
        StringSelection stringSelection = new StringSelection(s);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    /**
     * Private helper function for the help sub-item in the help JMenuBar item.
     * <p>
     * Reads from the help.bin file to load html documentation for how to
     * use the application. Loads the text into a JEditorPane and displays
     * it in an external window.
     */
    private void helpMenuItemAction() {
        // Constants for Swing element dimensions
        final int PANE_WIDTH = 900;
        final int PANE_HEIGHT = 700;
        final int BORDER_WIDTH = 10;

        /********** Main JFrame for Help Window **********/
        JFrame helpTextFrame = new JFrame();
        helpTextFrame.setBackground(Color.white);

        /********** JEditorPane for Help Text ***********/
        JEditorPane helpEditorPane = new JEditorPane();
        helpEditorPane.setContentType("text/html");
        helpEditorPane.setEditable(false);
        helpEditorPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        helpEditorPane.setPreferredSize(new Dimension(PANE_WIDTH, PANE_HEIGHT));
        helpEditorPane.setBorder(new EmptyBorder(
                BORDER_WIDTH,
                BORDER_WIDTH,
                BORDER_WIDTH,
                BORDER_WIDTH));

        // Get help html from external file
        try {
            FileReader reader = new FileReader("docs/QuickGuide.html");
            BufferedReader br = new BufferedReader(reader);
            helpEditorPane.read(br, null);
            br.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("FileNotFoundException: " + fnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println("IOException: " + ioe.getMessage());
        }

        /********** JScrollPane for JEditorPane *********/
        JScrollPane helpScrollPane = new JScrollPane(helpEditorPane);
        helpScrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        helpScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        /********** JPanel for Help Window **********/
        JPanel helpTextPanel = new JPanel();
        helpTextPanel.setLayout(new BorderLayout());
        helpTextPanel.setBackground(Color.white);

        /********** Add to JFrame and display **********/
        helpTextPanel.add(helpScrollPane, BorderLayout.CENTER);
        helpTextFrame.add(helpTextPanel);
        helpTextFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        helpTextFrame.pack();
        helpTextFrame.setVisible(true);
    }

    /**
     * Private helper function for the about sub-item in the help JMenuBar item.
     * <p>
     * Displays a JOptionPane that has info about the program.
     *
     * Got the code for generating url in an EditorPane from StackOverflow:
     * http://stackoverflow.com/questions/8348063/clickable-links-in-joptionpane
     */
    private static void aboutMenuItemAction() {
        // for copying style
        JLabel label = new JLabel();
        Font font = label.getFont();

        // create some css from the label's font
        StringBuffer style = new StringBuffer("font-family:" + font.getFamily() + ";");
        style.append("font-weight:" + (font.isBold() ? "bold" : "normal") + ";");
        style.append("font-size:" + font.getSize() + "pt;");

        String urlString = "https://github.com/igorgrebenkov/base-converter";
        // html content
        JEditorPane ep = new JEditorPane("text/html", "<html><body style=\"" + style + "\">" //
                + "<b>Version:</b> 0.9" + "<br>"
                + "<b>Author:</b> Igor Grebenkov" + "<br>"
                + "<b>GitHub: </b>"
                + "<a href=\" " + urlString + "\">" + urlString + "</a>" //
                + "</body></html>");

        // handle link events
        ep.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if (e.getEventType().equals(HyperlinkEvent.EventType.ACTIVATED))
                    try {
                        Desktop.getDesktop().browse(new URL(urlString).toURI());
                    } catch (Exception de) {
                        de.printStackTrace();
                    }
            }
        });
        ep.setEditable(false);
        ep.setBackground(label.getBackground());

        JOptionPane.showMessageDialog(null, ep);
    }
}
