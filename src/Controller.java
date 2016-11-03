import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.datatransfer.*;
import java.awt.Toolkit;

/**
 * The class <b>Controller</b> handles all events and communicates changes between the model and view.
 * <p>
 * It implements ActionListener, DocumentListener, and KeyListener.
 *
 * @author Igor Grebenkov
 */
public class Controller implements ActionListener, DocumentListener, KeyListener {
    private Model model;
    private View view;

    public Controller() {
        model = new Model();
        view = new View(model, this);
    }

    /***************************
     * ActionEvent Handlers
     **************************/
    /**
     * The actionPerformed ActionEvent handler. Currently unused.
     * @param e the ActionEvent
     */
    public void actionPerformed(ActionEvent e) {

    }

    /************************
     * KeyListenerEvent Handlers
     ************************/
    /**
     * The keyTyped KeyEvent handler. Unused.
     * @param e the KeyEvent
     */
    public void keyTyped(KeyEvent e) {
    }

    /**
     * The KeyPressed KeyEvent handler. Used to implement keyboard
     * shortcuts for copying conversion outputs to the clipboard.
     * <p>
     * CTRL+5 -> binary
     * CTRL+2 -> octal
     * CTRL+3 -> decimal
     * CTRL+3 -> hex
     *
     * @param e the KeyEvent
     */
    public void keyPressed(KeyEvent e) {

        if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_5) {         // copy binary output to clipboard
            StringSelection stringSelection = new StringSelection(model.getOutBinary());
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
        } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_2) {  // copy octal output to clipboard
            StringSelection stringSelection = new StringSelection(model.getOutOctal());
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
        } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_3) {  // copy octal output to clipboard
            StringSelection stringSelection = new StringSelection(model.getOutDecimal());
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
        } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_4) {  // copy hex output to clipboard
            StringSelection stringSelection = new StringSelection(model.getOutHex());
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
        } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_I) {  // copy current input to clipboard
            StringSelection stringSelection = new StringSelection(model.getInput().substring(1).trim());
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
        }
    }

    /**
     * The keyReleased KeyEvent handler. Unused.
     * @param e the KeyEvent
     */
    public void keyReleased(KeyEvent e) {
    }


    /*************************
     * DocumentEvent Handlers
     *************************/
    /**
     * The insertUpdate DocumentEvent handler.
     *
     * Used to get input string for conversion from the input textfield.
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
     * @param de the DocumentEvent
     */
    public void changedUpdate(DocumentEvent de) {
    }

    /**
     * The removeUpdate DocumentEvent handler.
     *
     * Used to update the input string when digits are being deleted.
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
     * input string is converted and output via the Conversion class.
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
        }
    }
}
