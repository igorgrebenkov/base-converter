import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The class <b>Controller</b> handles all events and communicates changes between the model and view.
 *
 * It extends ActionListener.
 *
 * @author Igor Grebenkov
 */
public class Controller implements ActionListener {
    private Model model;  // the model
    private View view;    // the view

    public Controller() {
        model = new Model();
        view = new View(model, this);
    }

    public void actionPerformed(ActionEvent e) {

    }
}
