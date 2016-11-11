/**
 * <p>The class <b>Model</b> contains the state of the program.</p>
 *
 * @author Igor Grebenkov
 */
public class Model {
    private String input;       // the number to convert
    private String outBinary;   // the converted number in binary    - prefix %
    private String outOctal;    // the converted number in octal     - prefix @
    private String outDecimal;  // the converted number in decimal   - prefix #
    private String outHex;      // the converted number in hex       - prefix $

    /**
     * Constructor.
     */
    public Model() {
        input = "";
        outBinary = "";
        outOctal = "";
        outDecimal = "";
        outHex = "";
    }

    /**
     * Getter for the input string.
     *
     * @return the input string
     */
    public String getInput() {
        return input;
    }

    /**
     * Setter for the input string.
     *
     * @param input the new input string
     */
    public void setInput(String input) {
        this.input = input;
    }

    /**
     * Getter for the binary output string.
     *
     * @return the binary output string
     */
    public String getOutBinary() {
        return outBinary;
    }

    /**
     * Setter for the binary output string.
     *
     * @param outBinary the new binary string
     */
    public void setOutBinary(String outBinary) {
        this.outBinary = outBinary;
    }

    /**
     * Getter for the octal output string.
     *
     * @return the octal string
     */
    public String getOutOctal() {
        return outOctal;
    }

    /**
     * Setter for the octal output string.
     *
     * @param outOctal the new octal output string
     */
    public void setOutOctal(String outOctal) {
        this.outOctal = outOctal;
    }

    /**
     * Getter for the decimal output string.
     *
     * @return the decimal output string
     */
    public String getOutDecimal() {
        return outDecimal;
    }

    /**
     * Setter for the decimal output string.
     *
     * @param outDecimal the new decimal output string
     */
    public void setOutDecimal(String outDecimal) {
        this.outDecimal = outDecimal;
    }

    /**
     * Getter for the hex output string.
     *
     * @return the hex output string
     */
    public String getOutHex() {
        return outHex;
    }

    /**
     * Setter for the hex output string.
     *
     * @param outHex the new hex output string
     */
    public void setOutHex(String outHex) {
        this.outHex = outHex;
    }
}
