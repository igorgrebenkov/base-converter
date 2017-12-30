import Controller.*;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.Font;

/**
 * The class <b>Main</b> contains the main method of the program.
 *
 * @author Igor Grebenkov
 */
public class BaseConverter {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.put("Label.font", new FontUIResource(
                    new Font("Verdana", Font.PLAIN, 14) ));
            UIManager.put("TextField.font", new FontUIResource(
                    new Font("Verdana", Font.PLAIN, 14) ));
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException: " + e.getMessage());
        } catch (InstantiationException e) {
            System.err.println("InstantiationException: " + e.getMessage());
        } catch (IllegalAccessException e) {
            System.err.println("IllegalAccessException: " + e.getMessage());
        } catch (UnsupportedLookAndFeelException e) {
            System.err.println("UnsupportedLookAndFeelException: " + e.getMessage());
        }
        new Controller();
    }
}
