import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * The class <b>Controller</b> handles all events and communicates changes between the model and view.
 * <p>
 * It extends ActionListener.
 *
 * @author Igor Grebenkov
 */
public class Controller implements ActionListener, DocumentListener {
    private Model model;  // the model
    private View view;    // the view

    public Controller() {
        model = new Model();
        view = new View(model, this);
    }

    public void actionPerformed(ActionEvent e) {

    }

    public void insertUpdate(DocumentEvent de) {
        Document source = de.getDocument();
        String input  = "";
        try {
            input += source.getText(0, source.getLength());
        } catch (BadLocationException e) {
            System.out.println("BadLocationException: " + e.getMessage());
        }
        processInput(input);
    }

    public void changedUpdate(DocumentEvent de) {
    }

    public void removeUpdate(DocumentEvent de) {
        Document source = de.getDocument();
        String input  = "";
        try {
            input += source.getText(0, source.getLength());
        } catch (BadLocationException e) {
            System.out.println("BadLocationException: " + e.getMessage());
        }
        processInput(input);
    }

    private void processInput(String input) {
        if (input.length() > 1) {
            if (input.charAt(0) == '%' ||
                    input.charAt(0) == '@' ||
                    input.charAt(0) == '#' ||
                    input.charAt(0) == '$') {
                char basePrefix = input.charAt(0);
                Conversion.convertNumber(basePrefix, input.substring(1), view.getOutputView());
                view.update();
            }
        }
    }
}
