import javax.swing.*;
import java.awt.*;

/**
 * The class <b>Main</b> contains the main method of the program.
 *
 * @author Igor Grebenkov
 */
public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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
