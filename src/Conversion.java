import java.math.BigInteger;

import static java.lang.Long.toBinaryString;
import static java.lang.Long.toHexString;
import static java.lang.Long.toOctalString;

/**
 * The class Conversion contains helper functions for converting numbers between bases.
 * <p>
 * After a conversion, it updates the appropriate text fields.
 * <p>
 * It contains only static methods.
 *
 * @author Igor Grebenkov
 */
public class Conversion {

    /**
     * Calls the appropriate methods to make the requested conversion.
     *
     * @param prefix      the first character in the string; indicates the base of the input
     * @param inputString the input number, minus the prefix
     */
    public static void convertNumber(char prefix, String inputString, Model model) throws NumberFormatException {
        String result = "";
        switch (prefix) {
            case '%':
                convertBinary(inputString, model);
                break;
            case '@':
                convertOctal(inputString, model);
                break;
            case '#':
                convertDecimal(inputString, model);
                break;
            case '$':
                convertHex(inputString, model);
                break;
        }

    }

    private static void convertBinary(String inputString, Model model) throws NumberFormatException {
        Long inputNum = Long.parseLong(inputString, 2);

        model.setOutBinary(formatBinaryString(inputString));
        model.setOutOctal(toOctalString(inputNum));
        model.setOutDecimal(inputNum.toString());
        model.setOutHex(toHexString(inputNum).toUpperCase());
    }

    private static void convertOctal(String inputString, Model model) throws NumberFormatException {
        Long inputNum = Long.parseLong(inputString, 8);

        model.setOutBinary(toBinaryString(inputNum));
        model.setOutOctal(inputString);
        model.setOutDecimal(inputNum.toString());
        model.setOutHex(toHexString(inputNum).toUpperCase());
    }

    private static void convertDecimal(String inputString, Model model) throws NumberFormatException {
        Long inputNum = Long.parseLong(inputString, 10);

        model.setOutBinary(toBinaryString(inputNum));
        model.setOutOctal(toOctalString(inputNum));
        model.setOutDecimal(inputNum.toString());
        model.setOutHex(toHexString(inputNum).toUpperCase());
    }

    private static void convertHex(String inputString, Model model) throws NumberFormatException {
        Long inputNum = Long.parseLong(inputString, 16);

        model.setOutBinary(toBinaryString(inputNum));
        model.setOutOctal(toOctalString(inputNum));
        model.setOutDecimal(inputNum.toString());
        model.setOutHex(toHexString(inputNum).toUpperCase());
    }

    private static String formatBinaryString(String binary) {
        // Pad with zeros if necessary
        if (binary.length() > 3) {
            switch (binary.length() % 4) {
                case 1:
                    binary = "000" + binary;
                    break;
                case 2:
                    binary = "00" + binary;
                    break;
                case 3:
                    binary = "0" + binary;
                    break;
            }
        }

        String result = "";

        // Add spaces to group into fours
        for (int i = 0; i < binary.length(); ++i) {
            char c = binary.charAt(i);
            if (i % 4 == 0 && i != 0) {
                result += " ";
            }
            result += c;
        }
        return result;
    }
}
