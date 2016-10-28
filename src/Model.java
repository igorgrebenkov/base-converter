/**
 * The class Model contains the state of the program.
 *
 * @author Igor Grebenkov
 */
public class Model {
    private String input;       // the number to convert
    private String outBinary;   // the converted number in binary; prefix %
    private String outOctal;    // the converted number in octal;  prefix @
    private String outDecimal;  // the converted number in decimal prefix #
    private String outHex;      // the converted number in hex     prefix $

    public Model() {
        input = "";
        outBinary = "";
        outOctal = "";
        outDecimal = "";
        outHex = "";
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutBinary() {
        return outBinary;
    }

    public void setOutBinary(String outBinary) {
        this.outBinary = outBinary;
    }

    public String getOutOctal() {
        return outOctal;
    }

    public void setOutOctal(String outOctal) {
        this.outOctal = outOctal;
    }

    public String getOutDecimal() {
        return outDecimal;
    }

    public void setOutDecimal(String outDecimal) {
        this.outDecimal = outDecimal;
    }

    public String getOutHex() {
        return outHex;
    }

    public void setOutHex(String outHex) {
        this.outHex = outHex;
    }
}
